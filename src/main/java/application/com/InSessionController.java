package application.com;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import java.util.Random;


public class InSessionController extends Controller {
	
	@FXML
	private TextField minField;
	private int minsLeft;
	
	@FXML
	private TextField secField;
	private int secsLeft;
	
	@FXML
	private Button endButton;
	
	@FXML
	private Label colon;
	
	@FXML
	private Label inspirationLabel;
	private int labelIterator = 0;
	private String[] quotes;
	private SessionModel model;
	
	@FXML
	private Pane centrePane;
	private FloatingBall circleList[] = new FloatingBall[20];
	
	@FXML
	private Pane pane;
	private Timeline timerAnimation;
	private Timeline ballAnimation;
	private EventHandler<ActionEvent> eventHandler = e -> tick();
	private EventHandler<ActionEvent> ballHandler = e -> moveBalls();
	private Media pick;
	private MediaPlayer player; 
	
	/**
	 * Called to initialise object variables. 
	 */
	@FXML void initialize(){
		quotes = (String[]) resources.getObject("quotes");
	}
	/**
	 * Sets the timer display's time to the current remaining time left.
	 */
	private void setTime(){
		System.out.println("Time is - " + minsLeft + " : " + secsLeft  );
		if (minsLeft < 10)
			minField.setText("0"+minsLeft);
		else
			minField.setText(""+minsLeft);
		if (secsLeft < 10)
			secField.setText("0"+secsLeft);
		else
			secField.setText(""+secsLeft);
	}
	
	/**
	 * Moves all the floating balls in the background.
	 */
	private void moveBalls() {
		for (FloatingBall b: circleList)
			b.move();
	}

	/**
	 * Reduces the remaining time by one second. 
	 * If the time is up the and there are no remaining sessions, the final screen is opened.
	 * Else, the Victory Screen is opened.
	 * In either case, an alarm is sounded.
	 */
	private void tick(){
		if (secsLeft == 0 && minsLeft!=0){
			// New minute.
			minsLeft --;
			secsLeft = 59;
			
			if (labelIterator == quotes.length)
				labelIterator = 0;
			else
				labelIterator++;
			inspirationLabel.setText(quotes[labelIterator]);
		}
		else if (secsLeft == 0 && minsLeft == 0){
			model.setSessionsLeft(model.getSessionsLeft()-1);
			if (model.getSessionsLeft()==0){
				player.play();
				refreshModel();
				rootPane.openFinalView();
			}
			else{
				player.play();
				ballAnimation.stop();
				timerAnimation.stop();
				rootPane.openVictoryView();
			}
				
		}
		else
			secsLeft--;
		setTime();
	}
	
	/**
	 * Fills the screen with red circles that are in random positions and float slowly around.
	 */
	private void newBalls(){
		for(int i = 0; i < 20; i++){
			Random rand = new Random();
			Random rand1 = new Random();
	    int xPos = rand.nextInt(((int) (model.getWidth() - 30) - 30) + 1) + 30;
	    int yPos = rand1.nextInt(((int) (model.getHeight() - 235) - 30) + 1) + 30;
			if (circleList[i]==null){
					circleList[i] = new FloatingBall(xPos, yPos,  model.getWidth(), model.getHeight() - 220, i%4);
					centrePane.getChildren().add(circleList[i]);
					circleList[i].toBack();
			}
		}
	}
	
	/**
	 * This visualises the user interface based on the size values of the Screen.
	 */
	public void visualize(){
		getModel();
		inspirationLabel.setMinSize(model.getWidth()-30, 50);
		inspirationLabel.setLayoutX(15);
		inspirationLabel.setLayoutY(10);
		endButton.setLayoutX(model.getWidth()/2 - 95);
		endButton.toFront();
		colon.setPrefSize(30,70);
		secField.setPrefSize(model.getWidth()/2 - 45, 70);
		minField.setPrefSize(model.getWidth()/2 - 45, 70);
		minField.setLayoutX(30);
		minField.setLayoutY(15);
		secField.setLayoutY(15);
		colon.setLayoutY(15);
		colon.setLayoutX(30+minField.getPrefWidth());
		secField.setLayoutX(minField.getPrefWidth()+60);	
		newBalls();
	  pick = new Media(getClass().getResource("/media/alert.mp3").toString());
    player = new MediaPlayer(pick);
	  MediaView mediaView = new MediaView(player);
	  this.centrePane.getChildren().add(mediaView);
	}

	/**
	 * Begins the animations of the ticking clock and the floating balls.
	 */
	public void play(){
		minsLeft = model.getWorkMins();
		timerAnimation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		ballAnimation = new Timeline(new KeyFrame (Duration.millis(30), ballHandler));
		timerAnimation.setCycleCount(Timeline.INDEFINITE);
		ballAnimation.setCycleCount(Timeline.INDEFINITE);
		secsLeft = 0;
		setTime();
		timerAnimation.playFromStart();
		ballAnimation.playFromStart();
	}
	
	/**
	 * Refreshes the model of the system; initialising the values 0 for further use. 
	 * The animations are also stopped.
	 */
	private void refreshModel(){
		ballAnimation.stop();
		timerAnimation.stop();
		model.setRestMins(0);
		model.setWorkMins(0);
		model.setSessionsLeft(0);
	}
	
	/**
	 * When the user decides to quit mid-session, this opens the defeat screen.
	 */
	@FXML
	private void endSession(){
		refreshModel();
		rootPane.openDefeatView();
	}
}

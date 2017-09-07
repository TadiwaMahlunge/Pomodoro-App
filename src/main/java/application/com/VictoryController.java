package application.com;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class VictoryController extends Controller{
	@FXML
	private Pane centrePane;
	
	@FXML
	private Pane pane;
	@FXML
	private Label message;
	@FXML
	private Label decorLabel1;
	@FXML
	private Label decorLabel2;
	@FXML
	private Label decorLabel3;
	@FXML
	private Label colon;
	
	@FXML
	private TextField minField;
	private int minsLeft;
	
	@FXML
	private TextField secField;
	private int secsLeft;
	
	private Timeline animation;
	private EventHandler<ActionEvent> eventHandler = e -> tick();
	private Media pick;
	private MediaPlayer player; 
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
	 * Reduces the remaining time by one second. 
	 * If the time is up the inSessionView is opened and the animation stopped.
	 * An alarm is sounded.
	 */ 
	private void tick(){
		if (secsLeft == 0 && minsLeft!=0){
			// New minute.
			minsLeft --;
			secsLeft = 59;
		}
		else if (secsLeft == 0 && minsLeft == 0){
			player.play();
			animation.stop();
			rootPane.openInSessionView();
		}
		else
			secsLeft--;
		setTime();
	}
	/**
	 * This visualises the user interface based on the size values of the Screen.
	 */
	public void visualize(){
		getModel();
		message.setMinSize(model.getWidth()-30, 50);
		message.setLayoutX(15);
		message.setLayoutY(10);
		decorLabel2.setLayoutX(model.getWidth()/2 - 110);
		decorLabel1.setLayoutX(model.getWidth()/2 - 150);
		decorLabel3.setLayoutX(model.getWidth()/2 - 70);
		colon.setPrefSize(30,70);
		secField.setPrefSize(model.getWidth()/2 - 45, 70);
		minField.setPrefSize(model.getWidth()/2 - 45, 70);
		minField.setLayoutX(30);
		minField.setLayoutY(15);
		secField.setLayoutY(15);
		colon.setLayoutY(15);
		colon.setLayoutX(30+minField.getPrefWidth());
		secField.setLayoutX(minField.getPrefWidth()+60);	

		pick = new Media(getClass().getResource("/media/alert.mp3").toString());
    player = new MediaPlayer(pick);
	  MediaView mediaView = new MediaView(player);
	  this.centrePane.getChildren().add(mediaView);
	}
	/**
	 * Begins the animations of the ticking clock.
	 */
	public void play(){
		minsLeft = model.getRestMins();
	  secsLeft = 0;
		animation = new Timeline(new KeyFrame(Duration.millis(1000), eventHandler));
		animation.setCycleCount(Timeline.INDEFINITE);
		setTime();
		animation.playFromStart();
	}
}

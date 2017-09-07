package application.com;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class TimerSelectorController extends Controller{
	@FXML
	private Label header;
	
	@FXML
	private TextField workField;
	
	@FXML
	private TextField restField;

	@FXML
	private VBox tomatoPane;
	
	@FXML 
	private ImageView tomato0;
	
	@FXML 
	private ImageView tomato1;
	
	@FXML 
	private ImageView tomato2;
	
	@FXML 
	private ImageView tomato3;
	
	@FXML 
	private ImageView tomato4;
	
	@FXML 
	private ImageView tomato5;

	private ImageView images[];
	
	@FXML
	private Slider sessionSlider;
	
	@FXML
	private Button beginBtn;
	
	@FXML
	private Pane pane;
	
	private int sliderValue = 1;
	private EventHandler<? super MouseEvent> sliderHandler = e -> sliderDrag();
	/**
	 * Called to initialise object variables. 
	 */
	@FXML void initialize(){
		images = new ImageView[] {tomato0,tomato1, tomato2,tomato3,tomato4,tomato5};
	}
	/**
	 * This visualises the user interface based on the size values of the Screen.
	 */
	public void visualize(){
		restField.setText("");
		workField.setText("");		
		
		for (ImageView i : images)
			i.setVisible(false);
		images[0].setVisible(true);
			
		int textLength = header.getText().length();
		getModel();
		beginBtn.setMinSize(model.getWidth()-30, 65);
		beginBtn.setLayoutX(15);
		header.setLayoutX(model.getWidth()/2 - textLength*3);
		
		sessionSlider.setOnMouseClicked(sliderHandler);
		sessionSlider.setValue(1);
	}
	/**
	 * This takes the slider's current (changed) value and displays that many tomatoes.
	 */
	@FXML
	private void sliderDrag(){
		double sliderValue = Math.floor(sessionSlider.getValue());
		this.sliderValue = (int)sliderValue;
		visualiseTomatoes();
		System.out.println("Dragged " + this.sliderValue);
	}
	/**
	 * This visualises the number of tomatoes given in the slider value.
	 */
	private void visualiseTomatoes(){
		for (ImageView i : images)
			i.setVisible(false);
		for (int i = 0; i< sliderValue; i++ ){
			images[i].setVisible(true);
		}
	}
	/**
	 * If the user has incorrectly entered an integer value into the text fields, they will be prompted to correct that mistake in the title.
	 * The user input values are added to the application model.
	 * The inSessionView is opened.
	 */
	@FXML
	private void buttonClicked(){
		int workMins;
		int restMins;
		
		try{
			workMins = Integer.parseInt(workField.getText());
			if (restField.getText().isEmpty())
				restMins = 0;
			else
				restMins = Integer.parseInt(restField.getText());
		}catch (NumberFormatException exc){
			restField.setText("");
			workField.setText("");
			header.setText("Please enter a whole number only.");
			return;
		}
		
		model.setNumSessions(sliderValue);
		model.setRestMins(restMins);
		model.setWorkMins(workMins);
		model.setSessionsLeft(sliderValue);
		
		rootPane.openInSessionView();
	}
}

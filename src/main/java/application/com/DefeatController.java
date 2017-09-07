package application.com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class DefeatController extends Controller{
	@FXML
	private Button homeBtn;	
	@FXML
	private Label decorLabel1;
	@FXML
	private Label decorLabel2;
	@FXML
	private Label decorLabel3;
	@FXML
	private Label message;
	@FXML
	private Pane centrePane;
	/**
	 * This visualises the user interface based on the size values of the Screen.
	 */
	public void visualize(){
		getModel();
		message.setMinSize(model.getWidth()-30, 50);
		message.setLayoutX(15);
		message.setLayoutY(10);
		homeBtn.setMinSize(model.getWidth()-30, 65);
		homeBtn.setLayoutX(15);
		decorLabel2.setLayoutX(model.getWidth()/2 - 110);
		decorLabel1.setLayoutX(model.getWidth()/2 - 150);
		decorLabel3.setLayoutX(model.getWidth()/2 - 70);
	}
	/**
	 * This will open the timerSelectorView.
	 * @throws IOException This exception will arise if the rootPane object is not instantiated.
	 */
	@FXML
	private void openHome() throws IOException{
		System.out.println("home clicked.");
		model = ((SessionModel) resources.getObject("model"));
		model.setNumSessions(0);
		rootPane.openTimerSelectorView();
	}
}

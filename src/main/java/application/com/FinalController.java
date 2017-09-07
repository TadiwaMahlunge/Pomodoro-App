package application.com;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class FinalController extends Controller{
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
	private Label title;
	
	@FXML
	private Label wellDone;
	
	@FXML 
	private ImageView tomato5;
	
	@FXML
	private Button homeBtn;

	private ImageView images[];
	
	private int sessionsCompleted;

	/**
	 * Initialises object values after construction.
	 */
	@FXML void initialize(){
		images = new ImageView[] {tomato0,tomato1, tomato2,tomato3,tomato4,tomato5};
	}
	
	/**
	 * Visualises user interface based on Screen size values.
	 */
	public void visualize(){
		getModel();
		sessionsCompleted = model.getNumSessions();
		for (ImageView i : images){
			i.setVisible(false);
		}
		tomato0.setLayoutX(model.getWidth()/2-40);
		tomato1.setLayoutX(model.getWidth()/2-80);
		tomato2.setLayoutX(model.getWidth()/2);
		tomato3.setLayoutX(model.getWidth()/2-40);
		tomato4.setLayoutX(model.getWidth()/2-120);
		tomato5.setLayoutX(model.getWidth()/2+40);
		wellDone.setLayoutX(model.getWidth()/2 - 60);
		title.setLayoutX(model.getWidth()/2 - 145);
		homeBtn.setLayoutX(model.getWidth()/2 - 150);
		homeBtn.setLayoutY(model.getHeight() - 80);
		
		for (int i = 0; i< sessionsCompleted; i++ )
			images[i].setVisible(true);
		model.setNumSessions(0);
		if (sessionsCompleted ==  1)
			title.setText("You collected "+ sessionsCompleted + " Pomodoro!");
		else
			title.setText("You collected "+ sessionsCompleted + " Pomodoros!");
		System.out.println("Session in Final: "+ sessionsCompleted);
	}
	
	/**
	 * This will open the home screen if the user wants to begin another session.
	 * @throws IOException This occurs if the home screen is not found for some reason.
	 */
	@FXML
	private void openHome() throws IOException{
		System.out.println("home clicked.");
		rootPane.openTimerSelectorView();
	}
}

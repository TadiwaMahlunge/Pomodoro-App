package application.com;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class BeginController extends Controller{
	@FXML
	private ImageView tomato;

	@FXML
	private Label title;
	
	@FXML
	private Button btn;
	
	@FXML
	private BorderPane panel;
	
	/**
	 * This visualises the user interface based on the size values of the Screen.
	 */
	public void visualize(){
		getModel();
		btn.setLayoutX(model.getWidth()/2  - btn.getPrefWidth()/2);
		btn.setLayoutY(model.getHeight() - 80);
		title.setLayoutX(btn.getLayoutX() + 20);
		tomato.setLayoutX(model.getWidth()/2 - (tomato.getFitWidth()/2));
	}
	/**
	 * This will open the timerSelectorView.
	 * @throws IOException This exception will arise if the rootPane object is not instantiated.
	 */
	@FXML
	private void openHome() throws IOException{
		System.out.println("home clicked.");
		rootPane.openTimerSelectorView();
	}
}

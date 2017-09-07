package application.com;

import java.util.ResourceBundle;

import javafx.fxml.FXML;

public class Controller {
	@FXML
  protected ResourceBundle resources ;
	
	protected SessionModel model;
	
	protected VisiblePane rootPane;
	
	protected void getModel(){
		model = (SessionModel) resources.getObject("model");
	}
	
	protected void setRootPane(VisiblePane rootPane){
		this.rootPane = rootPane;
	}
}

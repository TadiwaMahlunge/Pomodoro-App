package application.com;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class VisiblePane extends StackPane{
	private ResourceBundle resources;
	private BorderPane beginView;
	private BorderPane inSessionView;
	private BorderPane victoryView;
	private BorderPane defeatView;
	private BorderPane timerSelectorView;
	private BorderPane finalView;
	private BeginController beginController;
	private DefeatController defeatController;
	private InSessionController inSessionController;
	private FinalController finalController;
	private TimerSelectorController timerSelectorController;
	private VictoryController victoryController;
	private SessionModel model;
	
	/**
	 * This constructor will load all views' respective BoarderPanes from FXML files.
	 * The Screens' are initialised and sized.
	 * The Begin Screen is then opened.
	 */
	public VisiblePane(){
		super();
		try {
			resources = ResourceBundle.getBundle("application.com.MyResources", Locale.getDefault());
			model = (SessionModel) resources.getObject("model");
			loadViews();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		sizeViews();
		openBeginView();
	}
	
	/**
	 * This will load the screens from the FXML files and will initialise their controllers.
	 * @throws Exception This will either be a NullPointer Exception or IO Exception depending on whether a resource is not found or an uninitialised variable is called.
	 */
	public void loadViews() throws Exception{
  	FXMLLoader loader = new FXMLLoader(getClass().getResource("/beginView.fxml"), resources);
  	this.beginView = loader.load();
  	beginController = loader.getController();
  	beginController.setRootPane(this);
  	if (beginView !=null)
  		System.out.println("beginView loaded successfully...");
  	
  	loader = new FXMLLoader(getClass().getResource("/timerSelectorView.fxml"), resources);
  	this.timerSelectorView = loader.load();
  	timerSelectorController = loader.getController();
  	timerSelectorController.setRootPane(this);
  	if (timerSelectorView !=null)
  		System.out.println("timerSelectorView loaded successfully...");
  	
  	loader = new FXMLLoader(getClass().getResource("/defeatView.fxml"), resources);
  	this.defeatView = loader.load();
  	defeatController = loader.getController();
  	defeatController.setRootPane(this);
  	if (defeatView !=null)
  		System.out.println("defeatView loaded successfully...");
  	
  	loader = new FXMLLoader(getClass().getResource("/victoryView.fxml"), resources);
  	this.victoryView = loader.load();
  	victoryController = loader.getController();
  	victoryController.setRootPane(this);
  	if (victoryView !=null)
  		System.out.println("victoryView loaded successfully...");
  	
  	loader = new FXMLLoader(getClass().getResource("/finalView.fxml"), resources);
  	this.finalView = loader.load();
  	finalController = loader.getController();
  	finalController.setRootPane(this);
  	if (finalView !=null)
  		System.out.println("finalView loaded successfully...");
  	
  	loader = new FXMLLoader(getClass().getResource("/inSessionView.fxml"), resources);
  	this.inSessionView = loader.load();
  	inSessionController = loader.getController();
  	inSessionController.setRootPane(this);
  	if (inSessionView !=null)
  		System.out.println("inSessionView loaded successfully...");
  }
	
	/**
	 * This will set the views' sizes to the device size.
	 */
	public void sizeViews(){
		BorderPane views[] = {beginView, inSessionView, victoryView, defeatView, timerSelectorView, finalView};
		System.out.println("Height :" + model.getHeight() + "\nWidth : " + model.getWidth() );
		for (BorderPane b : views)
			b.setPrefSize(model.getHeight(), model.getWidth());
	}
	
	/**
	 * This will open the beginView.
	 */
	public void openBeginView(){
		beginController.visualize();
		this.getChildren().add(beginView);
	}
	/**
	 * This will open the inSessionView.
	 */
  public void openInSessionView(){
  	inSessionController.visualize();
  	inSessionController.play();
  	this.getChildren().remove(0);
  	this.getChildren().add(inSessionView);
  }
  /**
	 * This will open the finalView.
	 */
  public void openFinalView(){
  	finalController.visualize();
  	this.getChildren().remove(0);
  	this.getChildren().add(finalView);
  }
  /**
	 * This will open the victoryView.
	 */
  public void openVictoryView(){
  	victoryController.visualize();
  	victoryController.play();
  	this.getChildren().remove(0);
  	this.getChildren().add(victoryView);
  }
  /**
	 * This will open the defeatView.
	 */
  public void openDefeatView(){
  	defeatController.visualize();
  	this.getChildren().remove(0);
  	this.getChildren().add(defeatView);
  }
  /**
	 * This will open the timeSelectorView.
	 */
  public void openTimerSelectorView(){
  	timerSelectorController.visualize();
  	this.getChildren().remove(0);
  	this.getChildren().add(timerSelectorView);
  }
}

package application.com;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class PomodoroMain extends Application {
	private VisiblePane rootPane;
	private Scene scene;
	private Stage primaryStage;
	
  @Override
  /**
   * This will open the primary Stage of the application, setting the scene for the begin Screen.
   * @param stage This is the stage (main window) value passed when the application is launched.
   */
  public void start(Stage stage) {
  	this.primaryStage = stage;
    this.rootPane = new VisiblePane();
    
    Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
    scene = new Scene(rootPane, visualBounds.getWidth(), visualBounds.getHeight());

    Image icon = new Image(getClass().getResourceAsStream("/media/tomato.png"));
    primaryStage.getIcons().add(icon);
    primaryStage.setTitle("Pomodoro Technique App");
    primaryStage.setScene(scene);
    primaryStage.show();
   }
}

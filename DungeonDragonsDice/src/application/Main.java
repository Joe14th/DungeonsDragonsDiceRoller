package application;
	
import java.net.URL;

import controller.MainController;
import controller.StartController;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			URL url = this.getClass().getResource("../view/StartView.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			
			StartController controller = new StartController();
			loader.setController(controller);
			
			Parent root = loader.load();
			Scene scene = new Scene(root,400,400);
			primaryStage.setTitle("Dungeons and Dragons Dice Roller");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

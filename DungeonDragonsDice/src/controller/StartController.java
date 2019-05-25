package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController {
	@FXML
	private Button start;
	
	public StartController() {
		
	}
	
	public void startHandler(ActionEvent event) {
		try {
			URL url = this.getClass().getResource("../view/MainView.fxml");
			FXMLLoader loader = new FXMLLoader(url);
			
			MainController controller = new MainController();
			loader.setController(controller);
			
			Parent root = loader.load();
			Scene scene = new Scene(root,400,400);
			Stage stage = (Stage)start.getScene().getWindow();
			stage.setScene(scene);
			stage.show();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

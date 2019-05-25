package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import model.Rolls;
public class MainController implements Initializable{
	private final int CAPACITY = 20;
	@FXML
	private Button d4, d6, d8, d10, d12, d20, subtraction, addition;
	@FXML
	private RadioButton regular, advantage, disadvantage;
	@FXML
	private Pane pane;
	@FXML
	private Label result, results, numRolls;
	@FXML
	private ListView<String> history;
	
	private ObservableList<String> rolls = FXCollections.observableArrayList();
	
	private Scene scene;
	
	private int numDice = 1;
	
	public MainController() {
		
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		regular.setSelected(true);
		history.setItems(rolls);
	}
	
	public void handler(ActionEvent event) {
		
		String dice = ((Button)event.getSource()).getId();
		int sides = Integer.valueOf(dice.substring(1));
		
		checkCapacity();
		rollByType(dice,sides);
	}
	
	public void rollByType(String dice, int sides) {
		int res = 0;
		
		Rolls roll = new Rolls(numDice);
		if(regular.isSelected())
			res = roll.regularRoll(sides);
		else if(advantage.isSelected()) {
			res = roll.advantageRoll(sides);
		}
		else if(disadvantage.isSelected()) {
			res = roll.disadvantageRoll(sides);
		}
		result.setText(Integer.toString(res));
		results.setText(roll.getAllResults());
		rolls.add(0, numDice+dice + " : " + res);
	}
	
	public void checkCapacity() {
		if(rolls.size() == CAPACITY) {
			rolls.remove(CAPACITY-1);
		}
	}
	public void subHandler(ActionEvent event) {
		numDice--;
		numRolls.setText(Integer.toString(numDice));
	}
	public void addHandler(ActionEvent event) {
		numDice++;
		numRolls.setText(Integer.toString(numDice));
	}
	
	public void handleRollType(ActionEvent event) {
		RadioButton b = (RadioButton)event.getSource();
		if(b.equals(regular)) {
			advantage.setSelected(false);
			disadvantage.setSelected(false);
		}
		else if(b.equals(advantage)) {
			regular.setSelected(false);
			disadvantage.setSelected(false);
		}
		else if(b.equals(disadvantage)) {
			regular.setSelected(false);
			advantage.setSelected(false);
		}
	}
/*
 * TODO: FUTURE IDEA, Maybe add some dice animation?
 */
	public void handled6(ActionEvent event) {
/*		final PhongMaterial redMaterial = new PhongMaterial();
//	    redMaterial.setSpecularColor(Color.ORANGE);
//	    redMaterial.setDiffuseColor(Color.RED);
//	       
//		Box box = new Box(40,40,40);
//		box.setMaterial(redMaterial);
//		box.setTranslateX(300);
//		box.setTranslateY(300);
//		pane.getChildren().add(box);

//--------------CAMERA---------------------
//		PerspectiveCamera camera = new PerspectiveCamera();
//      System.out.println(camera.translateXProperty());
//		camera.setTranslateX(100);
//      camera.setTranslateY(100);
//      camera.setTranslateZ(400);
//		scene = d4.getScene();
//      scene.setCamera(camera);
//        
//      RotateTransition rt = new RotateTransition(Duration.seconds(2), camera);
//      rt.setCycleCount(4);
//      rt.setFromAngle(-30);
//      rt.setToAngle(30);
//      //rt.setAutoReverse(true);
//      rt.setAxis(Rotate.X_AXIS);
//      rt.play();
//------------OBJECT----------------------
//      scene.getWindow().addEventHandler(KeyEvent.KEY_PRESSED, e -> {
//      	switch(e.getCode()) {
//			case W:
//				box.translateZProperty().set(box.getTranslateZ() + 10);
//				break;
//			case S:
//				box.translateZProperty().set(box.getTranslateZ() - 10);
//				break;
//			default:
//				break;
//        	
//        	}
//        });
*/
	}


	
}

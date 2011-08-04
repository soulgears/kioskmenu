package test;

import javafx.application.*;
import javafx.event.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import kioskfx.*;

public class TestApp extends Application {

    public static void main(String[] args) {
	Application.launch(TestApp.class, args);
    }

    @Override
    public void start(Stage primaryStage) {
	primaryStage.setTitle("TestApp");
	Group root = new Group();
	Scene scene = new Scene(root, 600, 450, Color.LIGHTGREEN);
	Button btn = new Button();
	btn.setLayoutX(100);
	btn.setLayoutY(80);
	btn.setText("Hello World");
	btn.setOnAction(new EventHandler<ActionEvent>() {

	    public void handle(ActionEvent event) {
		System.out.println("Hello World");
	    }
	});
	root.getChildren().add(btn);
	
	KiGlass glass=new KiGlass();
	glass.node().setTranslateX(20);
	glass.node().setTranslateY(30);
	root.getChildren().add(glass.node());
	
	primaryStage.setScene(scene);
	primaryStage.setVisible(true);
    }
}

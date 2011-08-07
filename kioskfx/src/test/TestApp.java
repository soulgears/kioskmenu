package test;

import javafx.application.*;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.stage.*;
import javafx.animation.*;
import javafx.util.*;
import java.util.*;
import javafx.scene.image.*;
import javafx.scene.shape.*;
import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
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
        DoubleProperty w=new DoubleProperty ();
        DoubleProperty h=new DoubleProperty ();
        w.set(350);
        h.set(250);
        
        glass.width(w) ;
        glass.height(h) ;
        w.set(99);
        
        
        Rectangle t = new Rectangle();
        t.setFill(Color.web("#ff0000"));
        t.setWidth(30);
        t.setHeight(50);
        glass.content(t) ;
        t.setFill(Color.web("#663300"));
        t.setHeight(90);
        t.setWidth(220);
        
        //glass.w
	glass.node().setTranslateX(20);
	glass.node().setTranslateY(30);
	root.getChildren().add(glass.node());
	
	primaryStage.setScene(scene);
	primaryStage.setVisible(true);
    }
}

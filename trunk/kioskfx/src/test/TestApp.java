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
        Scene scene = new Scene(root);//, 20, 20, Color.web("#333333"));
        scene.setFill(Color.web("#333333"));
        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);
        /*
        System.out.println(scene.getHeight());
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
        //w.set(99);
        
        
        Rectangle tRect = new Rectangle();
        tRect.setFill(Color.web("#ff0000"));
        tRect.setWidth(30);
        tRect.setHeight(50);
        glass.content(tRect) ;
        tRect.setFill(Color.web("#663300"));
        tRect.setWidth(20);
        tRect.setHeight(20);
        
        
        //glass.w
        glass.node().setTranslateX(20);
        glass.node().setTranslateY(30);
        root.getChildren().add(glass.node());
        
        primaryStage.setScene(scene);
        primaryStage.setVisible(true);
        w.set(150);
         */
        KiMenu menu = new KiMenu();
        root.getChildren().add(menu.node());
        //menu.node().setTranslateX(50);
        //menu.node().setTranslateY(50);
        menu.width(primaryStage.widthProperty());
        menu.height(primaryStage.heightProperty());


        primaryStage.setScene(scene);
        primaryStage.setVisible(true);

        menu.section(new KiSection().title("First"));
        menu.section(new KiSection().title("Secont"));
        menu.section(new KiSection().title("Third"));
    }
}

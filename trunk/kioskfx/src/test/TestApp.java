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
        SimpleDoubleProperty w = new SimpleDoubleProperty();
        w.bind(primaryStage.widthProperty().subtract(100));
        SimpleDoubleProperty h = new SimpleDoubleProperty();
        h.bind(primaryStage.heightProperty().subtract(100));
        menu.width(w);
        menu.height(h);
        menu.node().setTranslateX(50);
        menu.node().setTranslateY(50);


        primaryStage.setScene(scene);
        primaryStage.setVisible(true);

        menu.section(new KiSection().title("First").image(new Image(this.getClass().getResourceAsStream("info.png"))).action(new KiAction().title("1as srt")).action(new KiAction().title("2asser bsth")));
        menu.section(new KiSection().title("Второй")
                //.image(new Image(this.getClass().getResourceAsStream("color.png")))
                .action(new KiAction().title("1baerh aerh")).action(new KiAction().title("2bserth t")));
        menu.section(new KiSection().title("Third").image(new Image(this.getClass().getResourceAsStream("image.png"))).action(new KiAction().title("1csth sdrn")).action(new KiAction().title("2cbsetb st")));
        menu.section(new KiSection().title("Fourth").image(new Image(this.getClass().getResourceAsStream("size.png"))).action(new KiAction().title("1dsrtbn s5th")).action(new KiAction().title("2ddejrt6yj ")));
        menu.section(new KiSection().title("Fifth").image(new Image(this.getClass().getResourceAsStream("other.png"))).action(new KiAction().title("1esefb ")).action(new KiAction().title("2esdrgn srt")));
        menu.iconWidth(500).iconHeight(150).leftMargin(300).topMargin(50);
        menu.iconWidth(200);



        final SimpleIntegerProperty it = new SimpleIntegerProperty(0);
        it.set(0);
        it.set(2);
        menu.currentSection(it);
        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                System.out.println("current " + it.get());
            }
        });

/*
        SimpleDoubleProperty n = new SimpleDoubleProperty(0);
        n.addListener(new ChangeListener<Number>() {

            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("changed "+oldValue + " -> " + newValue);
            }
        });
        SimpleDoubleProperty other = new SimpleDoubleProperty(0);
        n.bindBidirectional(other);
        System.out.println(0);
        n.set(0);
        System.out.println(1);
        n.set(1);
        System.out.println(2);
        n.set(2);
        System.out.println(-1);
        n.set(-1);
        System.out.println(0);
        n.set(0);
        System.out.println(1);
        n.set(1);
        System.out.println(2);
        n.set(2);*/
    }
}

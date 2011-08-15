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
    /*
    KiJob informationAboutComponent=new KiJob(){
	@Override public void start() {
	    javax.swing.JOptionPane.showMessageDialog(null
		,"Component version is "+menu.version()
		,"KiskFX"
		,javax.swing.JOptionPane.INFORMATION_MESSAGE);
	    }
	};
    KiJob informationAboutAuthor=new KiJob(){
	@Override public void start() {
	    javax.swing.JOptionPane.showMessageDialog(null
		,"Sergey Surikov\nsee http://www.javafx.me"
		,"KiskFX"
		,javax.swing.JOptionPane.INFORMATION_MESSAGE);
	    }
	};
    KiJob backgroundDefault=new KiJob(){
	@Override public void start() {
	    menu.image(null);
	    }
	};
    KiJob backgroundCity=new KiJob(){
	@Override public void start() {
	    menu.image(new Image(this.getClass().getResourceAsStream("night.jpg")));
	    }
	};
    KiJob backgroundAncient=new KiJob(){
	@Override public void start() {
	    menu.image(new Image(this.getClass().getResourceAsStream("egypt.jpg")));
	    }
	};
    KiJob backgroundNature=new KiJob(){
	@Override public void start() {
	    menu.image(new Image(this.getClass().getResourceAsStream("tree.jpg")));
	    }
	};
    KiJob kioskColorDefault=new KiJob(){
	@Override public void start() {
	    menu.fog(null);
	    }
	};
    KiJob kioskColorBlue=new KiJob(){
	@Override public void start() {
	    menu.fog(Color.web("#000033"));
	    }
	};
    KiJob kioskColorGreen=new KiJob(){
	@Override public void start() {
	    menu.fog(Color.web("#003300"));
	    }
	};
    KiJob nope=new KiJob(){
	@Override public void start() {
	    javax.swing.JOptionPane.showMessageDialog(null
		,"Nope"
		,"KiskFX"
		,javax.swing.JOptionPane.INFORMATION_MESSAGE);
	    }
	};*/
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Kiosk component demo");
        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.web("#333333"));
        primaryStage.setWidth(1000);
        primaryStage.setHeight(700);
	final KiMenu menu = new KiMenu();
        menu
	    .width(primaryStage.widthProperty())
	    .height(primaryStage.heightProperty())
	    .section(new KiSection()
		.title("Information")
		.image(new Image(this.getClass().getResourceAsStream("info.png")))
		.action(new KiAction()
		    .title("About component")
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Component version is "+menu.version()
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		.action(new KiAction()
		    .title("About author")
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Sergey Surikov\nsee http://www.javafx.me"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		)
	    .section(new KiSection()
		.title("Background")
		.image(new Image(this.getClass().getResourceAsStream("image.png")))
		.action(new KiAction()
		    .title("Default")
		    .image(new Image(this.getClass().getResourceAsStream("refresh.png")))
		    .onSelect(new KiJob(){@Override public void start(){menu.image(null);}}))
		.action(new KiAction()
		    .title("City")
		    .onSelect(new KiJob(){@Override public void start(){menu.image(new Image(this.getClass().getResourceAsStream("night.jpg")));}}))
		.action(new KiAction()
		    .title("Ancient")
		    .onSelect(new KiJob(){@Override public void start(){menu.image(new Image(this.getClass().getResourceAsStream("egypt.jpg")));}}))
		.action(new KiAction()
		    .title("Nature")
		    .onSelect(new KiJob(){@Override public void start(){menu.image(new Image(this.getClass().getResourceAsStream("tree.jpg")));}}))
		)
	    .section(new KiSection()
		.title("Kiosk color")
		.image(new Image(this.getClass().getResourceAsStream("color.png")))
		.action(new KiAction()
		    .title("Default")
		    .image(new Image(this.getClass().getResourceAsStream("refresh.png")))
		    .onSelect(new KiJob(){@Override public void start(){menu.fog(null);}}))
		.action(new KiAction()
		    .title("Blue")
		    .onSelect(new KiJob(){@Override public void start(){menu.fog(Color.web("#000033"));}}))
		.action(new KiAction()
		    .title("Green")
		    .onSelect(new KiJob(){@Override public void start(){menu.fog(Color.web("#003300"));}}))
		)
	    .section(new KiSection()
		.title("Position")
		.image(new Image(this.getClass().getResourceAsStream("other.png")))
		.action(new KiAction()
		    .title("Decrease left margin")
		    .image(new Image(this.getClass().getResourceAsStream("down.png")))
		    .onSelect(new KiJob(){@Override public void start(){menu.leftMargin(menu.leftMargin()-10);}}))
		.action(new KiAction()
		    .title("Increase left margin")
		    .image(new Image(this.getClass().getResourceAsStream("up.png")))
		    .onSelect(new KiJob(){@Override public void start(){menu.leftMargin(menu.leftMargin()+10);}}))
		.action(new KiAction()
		    .title("Decrease top margin")
		    .image(new Image(this.getClass().getResourceAsStream("down.png")))
		    .onSelect(new KiJob(){@Override public void start(){menu.topMargin(menu.topMargin()-10);}}))
		.action(new KiAction()
		    .title("Increase top margin")
		    .image(new Image(this.getClass().getResourceAsStream("up.png")))
		    .onSelect(new KiJob(){@Override public void start(){menu.topMargin(menu.topMargin()+10);}}))
		)
	    .section(new KiSection()
		.title("Icon size")
		.image(new Image(this.getClass().getResourceAsStream("size.png")))
		.action(new KiAction()
		    .title("Decrease width")
		    .image(new Image(this.getClass().getResourceAsStream("down.png")))
		    .onSelect(new KiJob(){@Override public void start(){menu.iconWidth(menu.iconWidth()-10);}}))
		.action(new KiAction()
		    .title("Increase width")
		    .image(new Image(this.getClass().getResourceAsStream("up.png")))
		    .onSelect(new KiJob(){@Override public void start(){menu.iconWidth(menu.iconWidth()+10);}}))
		.action(new KiAction()
		    .title("Decrease height")
		    .image(new Image(this.getClass().getResourceAsStream("down.png")))
		    .onSelect(new KiJob(){@Override public void start(){menu.iconHeight(menu.iconHeight()-10);}}))
		.action(new KiAction()
		    .title("Increase height")
		    .image(new Image(this.getClass().getResourceAsStream("up.png")))
		    .onSelect(new KiJob(){@Override public void start(){menu.iconHeight(menu.iconHeight()+10);}}))
		)		
	    .section(new KiSection()
		.title("Item color")
		.image(new Image(this.getClass().getResourceAsStream("color.png")))
		.action(new KiAction()
		    .title("Default")
		    .image(new Image(this.getClass().getResourceAsStream("refresh.png")))
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		.action(new KiAction()
		    .title("Yellow")
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		.action(new KiAction()
		    .title("Cyan")
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		)		
	    .section(new KiSection()
		.title("Items size")
		.image(new Image(this.getClass().getResourceAsStream("size.png")))
		.action(new KiAction()
		    .title("Decrease height")
		    .image(new Image(this.getClass().getResourceAsStream("down.png")))
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		.action(new KiAction()
		    .title("Increase height")
		    .image(new Image(this.getClass().getResourceAsStream("up.png")))
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		)		
	    .section(new KiSection()
		.title("Title color")
		.image(new Image(this.getClass().getResourceAsStream("color.png")))
		.action(new KiAction()
		    .title("Default")
		    .image(new Image(this.getClass().getResourceAsStream("refresh.png")))
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		.action(new KiAction()
		    .title("Yellow")
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		.action(new KiAction()
		    .title("Cyan")
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		)		
	    .section(new KiSection()
		.title("Font size")
		.image(new Image(this.getClass().getResourceAsStream("font.png")))
		.action(new KiAction()
		    .title("Decrease title size")
		    .image(new Image(this.getClass().getResourceAsStream("down.png")))
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		.action(new KiAction()
		    .title("Increase title size")
		    .image(new Image(this.getClass().getResourceAsStream("up.png")))
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		.action(new KiAction()
		    .title("Decrease item size")
		    .image(new Image(this.getClass().getResourceAsStream("down.png")))
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		.action(new KiAction()
		    .title("Increase item size")
		    .image(new Image(this.getClass().getResourceAsStream("up.png")))
		    .onSelect(new KiJob(){@Override public void start(){
			javax.swing.JOptionPane.showMessageDialog(null
			    ,"Ops"
			    ,"KiskFX"
			    ,javax.swing.JOptionPane.INFORMATION_MESSAGE);
			    }}))
		)
	    ;
        root.getChildren().add(menu.node());
        primaryStage.setScene(scene);
        primaryStage.setVisible(true);
    }
}

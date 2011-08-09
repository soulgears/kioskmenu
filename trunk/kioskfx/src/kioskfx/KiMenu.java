package kioskfx;

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
import javafx.geometry.*;
import javafx.scene.transform.*;
import javafx.scene.effect.*;
import javafx.scene.text.*;

public class KiMenu {

    private Node node;
    private DoubleProperty width;
    private DoubleProperty height;
    private ObjectProperty<Color> fogColor;
    //private ImageView imageView;
    private Text label;
    private Vector<KiSection> sections;
    private Group sectionsGroup;
    private DoubleProperty iconWidth;
    private DoubleProperty iconHeight;
    private DoubleProperty leftMargin;
    private DoubleProperty topMargin;

    public KiMenu() {
        width = new DoubleProperty(900);
        height = new DoubleProperty(600);
        fogColor = new ObjectProperty<Color>(Color.web("#000000"));
        iconWidth = new DoubleProperty(150);
        iconHeight = new DoubleProperty(100);
        leftMargin = new DoubleProperty(100);
        topMargin = new DoubleProperty(100);
        Group root = new Group();

        /*Rectangle t = new Rectangle();
        t.setFill(Color.web("#330000"));
        t.widthProperty().bind(width);
        t.heightProperty().bind(height);
        root.getChildren().add(t);*/
        sections = new Vector<KiSection>();


        //Image backgroundImage = new Image(this.getClass().getResourceAsStream("background.jpg"));
        //KiBackground ff=new KiBackground().height(height).width(width).image(backgroundImage);
        //imageView = new ImageView();
        //imageView.setImage(backgroundImage);
        //defaultImageView.fitWidthProperty().bind(width);
        //imageView.setPreserveRatio(true);
        root.getChildren().add(new KiBackground().height(height).width(width).image(new Image(this.getClass().getResourceAsStream("background.jpg"))).node());



        Rectangle fog = new Rectangle();
        fog.widthProperty().bind(width);
        fog.heightProperty().bind(height.multiply(2));
        fog.translateYProperty().bind(height.divide(-2.0));
        fog.setFill(getFogFill());
        root.getChildren().add(fog);

        label = new Text();
        label.setFont(new Font("Verdana", 90));
        //label.setTranslateX(300);
        label.setTranslateY(0);
        label.setTextOrigin(VPos.TOP);
        label.setText("Text label");
        label.setFill(Color.web("#ffffff66"));
        label.translateXProperty().bind(leftMargin);
        root.getChildren().add(label);

        sectionsGroup = new Group();
        sectionsGroup.translateXProperty().bind(leftMargin);
        sectionsGroup.translateYProperty().bind(topMargin);
        root.getChildren().add(sectionsGroup);

        addWatchers();

        node = root;
    }

    private Paint getFogFill() {
        Color dark = new Color(fogColor.get().getRed(), fogColor.get().getGreen(), fogColor.get().getBlue(), 1.0);
        Color light = new Color(fogColor.get().getRed(), fogColor.get().getGreen(), fogColor.get().getBlue(), 0.5);
        Stop[] stops = new Stop[]{new Stop(0, light), new Stop(1, dark)};
        RadialGradient gr = new RadialGradient(0.0, 0.0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops);
        return gr;
    }

    void addWatchers() {
        /*width.addListener(new InvalidationListener<Number>() {
        
        @Override
        public void invalidated(ObservableValue<? extends Number> observable) {
        adjust();
        }
        });
        height.addListener(new InvalidationListener<Number>() {
        
        @Override
        public void invalidated(ObservableValue<? extends Number> observable) {
        adjust();
        }
        });*/
    }

    public Node node() {
        adjust();
        return node;
    }

    void adjust() {
        //double imageWidth = imageView.getBoundsInLocal().getWidth();
        //double imageHeight = imageView.getBoundsInLocal().getHeight();
        //double scaleWidth = width.get() / imageView.getBoundsInLocal().getWidth();
        //double scaleHeight = height.get() / imageView.getBoundsInLocal().getHeight();
        /*if (width.get() / imageView.getBoundsInLocal().getWidth() > height.get() / imageView.getBoundsInLocal().getHeight()) {
        imageView.setFitHeight(0);
        imageView.setFitWidth(width.get());
        } else {
        imageView.setFitWidth(0);
        imageView.setFitHeight(height.get());
        }*/
        //System.out.println(scaleWidth + "/" + scaleHeight);
    }

    public KiMenu width(DoubleProperty nn) {
        this.width.bind(nn);
        adjust();
        return this;
    }

    public KiMenu iconWidth(double nn) {
        this.iconWidth.set(nn);
        //adjust();
        return this;
    }

    public KiMenu leftMargin(double nn) {
        this.leftMargin.set(nn);
        //adjust();
        return this;
    }

    public KiMenu topMargin(double nn) {
        this.topMargin.set(nn);
        //adjust();
        return this;
    }

    public KiMenu iconHeight(double nn) {
        this.iconHeight.set(nn);
        //adjust();
        return this;
    }

    public KiMenu height(DoubleProperty nn) {
        this.height.bind(nn);
        adjust();
        return this;
    }

    private void move(int nn) {
        System.out.println(nn);
    }

    public KiMenu section(KiSection it) {
        //this.width.bind(nn);
        //adjust();
        
        final int n = sections.size();
        KiJob job = new KiJob() {

            @Override
            public void start() {
                move(n);
            }
        };
        it.order(sections.size()).width(iconWidth).height(iconHeight).onSelect(job);
        //it.image(new Image(this.getClass().getResourceAsStream("section.png")));
        sections.add(it);
        sectionsGroup.getChildren().add(it.node());
        return this;
    }
}

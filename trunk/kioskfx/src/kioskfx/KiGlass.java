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

public class KiGlass {

    private DoubleProperty width;
    private DoubleProperty opacity;
    private DoubleProperty height;
    private Node node;
    private Node content;
    private KiJob onSelect;
    private Rectangle flare;
    private Group contentGroup;
    private Group shadowGroup;
    //private double glassOpacity;
    //private boolean isFocused;
    private BooleanProperty active;
    
    Group backGroup;

    public KiGlass() {
        width = new DoubleProperty(90);
        height = new DoubleProperty(60);
        opacity = new DoubleProperty(0.99);
        active = new BooleanProperty(false);
        
        //glassOpacity = 0.1;
        //isFocused = false;
        Rectangle t = new Rectangle();
        t.setFill(Color.web("#ff0000"));
        content = t;
        backGroup = new Group();
        Rectangle r1 = new Rectangle();
        r1.setArcHeight(8);
        r1.setArcWidth(8);
        r1.setStroke(Color.web("#ffffff99"));
        r1.setStrokeWidth(1.0);
        r1.widthProperty().bind(width);
        r1.heightProperty().bind(height);
        r1.setFill(Color.web("#ffffff00"));
        backGroup.getChildren().add(r1);
        Rectangle r2 = new Rectangle();
        r2.setArcHeight(8);
        r2.setArcWidth(8);
        r2.setStroke(Color.web("#ffffff22"));
        r2.setStrokeWidth(5.0);
        r2.widthProperty().bind(width);
        r2.heightProperty().bind(height);
        r2.setFill(Color.web("#ffffff00"));
        backGroup.getChildren().add(r2);
        Rectangle r3 = new Rectangle();
        r3.setArcHeight(8);
        r3.setArcWidth(8);
        r3.setStroke(Color.web("#ffffff22"));
        r3.setStrokeWidth(7.0);
        r3.widthProperty().bind(width);
        r3.heightProperty().bind(height);
        r3.setFill(Color.web("#ffffff00"));
        backGroup.getChildren().add(r3);
        Rectangle r4 = new Rectangle();
        r4.setArcHeight(8);
        r4.setArcWidth(8);
        r4.widthProperty().bind(width);
        r4.heightProperty().bind(height);
        r4.setFill(Color.web("#ffffff00"));
        Stop[] s4 = new Stop[]{new Stop(0, Color.web("#ffffff99")), new Stop(1, Color.web("#ffffff00"))};
        LinearGradient g4 = new LinearGradient(0, 1, 0, 0.5, true, CycleMethod.NO_CYCLE, s4);
        r4.setFill(g4);
        backGroup.getChildren().add(r4);
        flare = new Rectangle();
        flare.setArcHeight(8);
        flare.setArcWidth(8);
        flare.widthProperty().bind(width);
        flare.heightProperty().bind(height);
        flare.setFill(Color.web("#ffffff00"));
        Stop[] s5 = new Stop[]{new Stop(0, Color.web("#ffffffcc")), new Stop(0.99, Color.web("#ffffff33")), new Stop(1, Color.web("#ffffff00"))};
        LinearGradient g5 = new LinearGradient(0, 0, 0.05, 0.5, true, CycleMethod.NO_CYCLE, s5);
        flare.setFill(g5);
        flare.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (onSelect != null) {
                    onSelect.start();
                }
            }
        });
        flare.hoverProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                adjust();
            }
        });
        opacity.addListener(new InvalidationListener<Number>() {

            @Override
            public void invalidated(ObservableValue<? extends Number> observable) {
                adjust();
            }
        });
        width.addListener(new InvalidationListener<Number>() {

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
        });
        active.addListener(new InvalidationListener<Boolean>() {

            @Override
            public void invalidated(ObservableValue<? extends Boolean> observable) {
                adjust();
            }
        });
        Group root = new Group();
        root.getChildren().add(backGroup);
        contentGroup = new Group();
        shadowGroup = new Group();
        contentGroup.boundsInLocalProperty().addListener(new InvalidationListener<Bounds>() {

            @Override
            public void invalidated(ObservableValue<? extends Bounds> observable) {
                adjust();
            }
        });
        DropShadow ds = new DropShadow();
        shadowGroup.setEffect(ds);
        contentGroup.boundsInLocalProperty().getValue();//bug with stupid lazy binding
        contentGroup.getChildren().add(content);
        backGroup.getChildren().add(shadowGroup);
        shadowGroup.getChildren().add(contentGroup);
        root.getChildren().add(flare);
        node = root;
        onSelect = new KiJob();
    }

    void adjustSize() {
        double contentWidth = content.getBoundsInLocal().getWidth();
        double contentHeight = content.getBoundsInLocal().getHeight();
        if (contentWidth > 0 && contentHeight > 0 && width.get() > 0 && height.get() > 0) {
            double widthScale = (width.get() - 16) / contentWidth;
            double heightScale = (height.get() - 16) / contentHeight;
            double scaleSize = widthScale < heightScale ? widthScale : heightScale;
            Scale scaleTransform = new Scale(scaleSize, scaleSize, 0, 0);
            contentGroup.getTransforms().clear();
            contentGroup.getTransforms().add(scaleTransform);
            double xShift = (width.get() - contentWidth * scaleSize - 16) / 2 + 8;
            double yShift = (height.get() - contentHeight * scaleSize - 16) / 2 + 8;
            contentGroup.setTranslateX(xShift);
            contentGroup.setTranslateY(yShift);
        }
    }

    void adjustOpacity() {
        if (flare.isHover()) {
            flare.setOpacity(1.0);
            //backGroup.setOpacity(1.0);
            if (node != null) {
                node.setOpacity(1.0);
            }
        } else {
            if (active.get()) {
                flare.setOpacity(1.0);
                if (node != null) {
                    node.setOpacity(1.0);
                }
            } else {
                flare.setOpacity(0.3);
                if (node != null) {
                    node.setOpacity(opacity.get());
                }
            }
        }
    }

    void adjust() {
        adjustOpacity();
        adjustSize();
    }

    public Node node() {
        adjust();
        return node;
    }

    public KiGlass content(Node n) {
        this.content = n;
        contentGroup.getChildren().clear();
        contentGroup.getChildren().add(content);
        adjust();
        return this;
    }

    public KiGlass width(DoubleProperty nn) {
        this.width.bind(nn);
        adjust();
        return this;
    }

    public KiGlass height(DoubleProperty nn) {
        this.height.bind(nn);
        adjust();
        return this;
    }
     public KiGlass onSelect(KiJob it) {
        onSelect=it;
        return this;
    }
}

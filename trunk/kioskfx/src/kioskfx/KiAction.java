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

public class KiAction {

    private String title;
    private Node node;
    Text label;
    private SimpleDoubleProperty order;
    private ImageView imageView;
    private SimpleDoubleProperty height;
    private double margin = 0;
    private KiJob onSelect;
    private SimpleDoubleProperty opacity;

    public KiAction() {
        title = "123";
        imageView = new ImageView();
        order = new SimpleDoubleProperty(0);
        height = new SimpleDoubleProperty(70);
        opacity = new SimpleDoubleProperty(0.5);
        margin = height.get() + 8;

        Group root = new Group();
        label = new Text();
        label.setText(title);
        label.setFill(Color.web("#ffffff"));
        label.setTextOrigin(VPos.TOP);
        Font font = Font.loadFont(this.getClass().getResourceAsStream("font.ttf"), 50);
        label.setFont(font);
        label.translateYProperty().bind(height.add(4).multiply(order));
        label.setTranslateX(margin);

        imageView.translateYProperty().bind(height.add(4).multiply(order));
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(0);
        imageView.fitHeightProperty().bind(height);

        label.opacityProperty().bind(opacity);
        imageView.opacityProperty().bind(opacity);

        //margin=4+imageView.get.boundsInLocalProperty()..getBoundsInLocal().getWidth();
        //.setFitHeight(height.get());
        image(new Image(this.getClass().getResourceAsStream("item.png")));
        root.getChildren().add(imageView);
        root.getChildren().add(label);

        root.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (onSelect != null) {
                    opacity.set(0.5);
                    onSelect.start();
                }
            }
        });
        onSelect = new KiJob();
        root.hoverProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                //adjust();
                if (node.isHover()) {
                    opacity.set(1.0);
                } else {
                    opacity.set(0.5);
                }
            }
        });

        node = root;

    }

    public String title() {
        return title;
    }

    public KiAction onSelect(KiJob it) {
        onSelect = it;
        return this;
    }

    public KiAction image(Image it) {
        //order.set(it);


        imageView.setImage(it);
        //glass.content(imageView);
        return this;
    }

    public KiAction title(String it) {
        this.title = it;
        label.setText(title);
        return this;
    }

    public KiAction order(int it) {
        this.order.set(it);
        return this;
    }

    public Node node() {
        return node;
    }
}

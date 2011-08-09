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

public class KiBackground {

    private DoubleProperty height;
    private DoubleProperty width;
    private ImageView imageView;

    public KiBackground() {
        width = new DoubleProperty(300);
        height = new DoubleProperty(200);
        imageView = new ImageView();
        imageView.setPreserveRatio(true);
        addWatchers();
    }

    private void addWatchers() {
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
    }

    private void adjust() {
        if (width.get() / imageView.getBoundsInLocal().getWidth() > height.get() / imageView.getBoundsInLocal().getHeight()) {
            imageView.setFitHeight(0);
            imageView.setFitWidth(width.get());
        } else {
            imageView.setFitWidth(0);
            imageView.setFitHeight(height.get());
        }
    }

    public KiBackground width(DoubleProperty nn) {
        width.bind(nn);
        return this;
    }

    public KiBackground height(DoubleProperty nn) {
        height.bind(nn);
        return this;
    }

    public KiBackground image(Image it) {
        imageView.setImage(it);
        return this;
    }

    public Node node() {
        return imageView;
    }
}

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

    private SimpleDoubleProperty height;
    private SimpleDoubleProperty width;
    private ImageView imageView;

    public KiBackground() {
        width = new SimpleDoubleProperty(300);
        height = new SimpleDoubleProperty(200);
        imageView = new ImageView();
        imageView.setPreserveRatio(true);
        addWatchers();
    }

    private void addWatchers() {
        width.addListener(new ChangeListener<Number>() {

   

            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                adjust();
            }
        });
        height.addListener(new ChangeListener<Number>() {

           public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
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

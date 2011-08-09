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

public class KiSection {

    private String title;
    private KiGlass glass;
    private DoubleProperty order;
    private DoubleProperty width;
    private DoubleProperty height;
    //private Image image;
    ImageView imageView;

    public KiSection() {
        title = "";
        imageView = new ImageView();
        //Image it=new Image(this.getClass().getResourceAsStream("section.png"));
        //System.out.println(it.getHeight());
        //imageView.setImage(it);
        //image = null;
        order = new DoubleProperty(0);
        width = new DoubleProperty(100);
        height = new DoubleProperty(60);

        glass = new KiGlass().width(width).height(height);
        glass.node().translateXProperty().bind(width.add(8).multiply(order));
        
        image(new Image(this.getClass().getResourceAsStream("section.png")));

    }

    public KiSection title(String it) {
        this.title = it;
        return this;
    }

    public KiSection width(DoubleProperty it) {
        width.bind(it);
        return this;
    }

    public KiSection height(DoubleProperty it) {
        height.bind(it);
        return this;
    }

    public KiSection onSelect(KiJob it) {
        glass.onSelect(it);
        return this;
    }

    public KiSection order(int it) {
        order.set(it);
        return this;
    }

    public KiSection image(Image it) {
        //order.set(it);


        imageView.setImage(it);
        glass.content(imageView);
        return this;
    }

    public Node node() {
        return glass.node();
    }
}

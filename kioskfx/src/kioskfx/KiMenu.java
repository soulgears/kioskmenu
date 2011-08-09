package kioskfx;

//~--- non-JDK imports --------------------------------------------------------
import javafx.animation.*;

import javafx.application.*;

import javafx.beans.property.*;
import javafx.beans.value.*;
import javafx.beans.value.*;

import javafx.event.*;

import javafx.geometry.*;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.*;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.transform.*;

import javafx.stage.*;

import javafx.util.*;

//~--- JDK imports ------------------------------------------------------------

import java.util.*;

public class KiMenu {

    private IntegerProperty currentSection;
    private ObjectProperty<Color> fogColor;
    private DoubleProperty height;
    private DoubleProperty iconHeight;
    private DoubleProperty iconWidth;
    // private ImageView imageView;
    private Text label;
    private DoubleProperty leftMargin;
    private Node node;
    private Vector<KiSection> sections;
    private Group sectionsGroup;
    // private DoubleProperty currentMargin;
    private DoubleProperty topMargin;
    private DoubleProperty width;

    public KiMenu() {
        width = new DoubleProperty(900);
        height = new DoubleProperty(600);
        fogColor = new ObjectProperty<Color>(Color.web("#000000"));
        iconWidth = new DoubleProperty(150);
        iconHeight = new DoubleProperty(100);
        leftMargin = new DoubleProperty(100);
        topMargin = new DoubleProperty(100);
        currentSection = new IntegerProperty(-1);

        Group root = new Group();

        /*
         * Rectangle t = new Rectangle();
         * t.setFill(Color.web("#330000"));
         * t.widthProperty().bind(width);
         * t.heightProperty().bind(height);
         * root.getChildren().add(t);
         */
        sections = new Vector<KiSection>();

        // Image backgroundImage = new Image(this.getClass().getResourceAsStream("background.jpg"));
        // KiBackground ff=new KiBackground().height(height).width(width).image(backgroundImage);
        // imageView = new ImageView();
        // imageView.setImage(backgroundImage);
        // defaultImageView.fitWidthProperty().bind(width);
        // imageView.setPreserveRatio(true);
        root.getChildren().add(
                new KiBackground().height(height).width(width).image(
                new Image(this.getClass().getResourceAsStream("background.jpg"))).node());

        Rectangle fog = new Rectangle();

        fog.widthProperty().bind(width);
        fog.heightProperty().bind(height.multiply(2));
        fog.translateYProperty().bind(height.divide(-2.0));
        fog.setFill(getFogFill());
        root.getChildren().add(fog);
        label = new Text();
        label.setFont(new Font("Verdana", 90));

        // label.setTranslateX(300);
        label.setTranslateY(0);
        label.setTextOrigin(VPos.TOP);

        // label.setText("Text label");
        label.setFill(Color.web("#ffffff66"));
        label.translateXProperty().bind(leftMargin);
        root.getChildren().add(label);
        sectionsGroup = new Group();
        sectionsGroup.translateXProperty().bind(iconWidth.add(16).multiply(currentSection).negate().add(leftMargin));

        // currentSection.multiply(sectionWidth).
        // leftMargin);
        sectionsGroup.translateYProperty().bind(topMargin);
        root.getChildren().add(sectionsGroup);
        addWatchers();

//      currentSection.set(0);

        Rectangle clip = new Rectangle();

        clip.widthProperty().bind(width);
        clip.heightProperty().bind(height);
        root.setClip(clip);
        node = root;
    }

    public KiMenu currentSection(IntegerProperty it) {
        this.currentSection.bindBidirectional(it);

        return this;
    }

    private Paint getFogFill() {
        Color dark = new Color(fogColor.get().getRed(), fogColor.get().getGreen(), fogColor.get().getBlue(),
                1.0);
        Color light = new Color(fogColor.get().getRed(), fogColor.get().getGreen(), fogColor.get().getBlue(),
                0.5);
        Stop[] stops = new Stop[]{new Stop(0, light), new Stop(1, dark)};
        RadialGradient gr = new RadialGradient(0.0, 0.0, 0.5, 0.5, 0.5, true, CycleMethod.NO_CYCLE, stops);

        return gr;
    }

    private void setFar() {
        System.out.println("far");
        double rtsz = 1.0 / ((0.0 + width.get() - leftMargin.get()) / iconWidth.get());
        double ltsz = 1.0 / ((0.0 + leftMargin.get() + iconWidth.get()) / iconWidth.get());
        for (int i = 0; i < sections.size(); i++) {
            int diff = currentSection.get() - i;
            if (diff < 0) {        // right
                double opcty = 1.0 + diff * rtsz;
                if (opcty < 0) {
                    opcty = 0;
                }
                if (opcty > 1) {
                    opcty = 1;
                }
                sections.get(i).opacity(opcty);
            } else {
                if (diff > 0) {    // left
                    double o = 1.0 - diff * ltsz;
                    if (o < 0) {
                        o = 0;
                    }
                    if (o > 1) {
                        o = 1;
                    }
                    sections.get(i).opacity(o);
                } else {
                    sections.get(i).opacity(1.0);
                }
            }
        }
    }

    void addWatchers() {

        /*
         * width.addListener(new InvalidationListener<Number>() {
         *
         * @Override
         * public void invalidated(ObservableValue<? extends Number> observable) {
         * adjust();
         * }
         * });
         * height.addListener(new InvalidationListener<Number>() {
         *
         * @Override
         * public void invalidated(ObservableValue<? extends Number> observable) {
         * adjust();
         * }
         * });
         */
        currentSection.addListener(new InvalidationListener<Number>() {

            @Override
            public void invalidated(ObservableValue<? extends Number> observable) {
                showCurrent();
            }
        });
    }

    public Node node() {
        adjust();

        return node;
    }

    void adjust() {
        // double imageWidth = imageView.getBoundsInLocal().getWidth();
        // double imageHeight = imageView.getBoundsInLocal().getHeight();
        // double scaleWidth = width.get() / imageView.getBoundsInLocal().getWidth();
        // double scaleHeight = height.get() / imageView.getBoundsInLocal().getHeight();

        /*
         * if (width.get() / imageView.getBoundsInLocal().getWidth() > height.get() / imageView.getBoundsInLocal().getHeight()) {
         * imageView.setFitHeight(0);
         * imageView.setFitWidth(width.get());
         * } else {
         * imageView.setFitWidth(0);
         * imageView.setFitHeight(height.get());
         * }
         */
        // System.out.println(scaleWidth + "/" + scaleHeight);
    }

    public KiMenu width(DoubleProperty nn) {
        this.width.bind(nn);
        adjust();

        return this;
    }

    public KiMenu iconWidth(double nn) {
        this.iconWidth.set(nn);

        // adjust();
        return this;
    }

    public KiMenu leftMargin(double nn) {
        this.leftMargin.set(nn);

        // adjust();
        return this;
    }

    public KiMenu topMargin(double nn) {
        this.topMargin.set(nn);

        // adjust();
        return this;
    }

    public KiMenu iconHeight(double nn) {
        this.iconHeight.set(nn);

        // adjust();
        return this;
    }

    public KiMenu height(DoubleProperty nn) {
        this.height.bind(nn);
        adjust();

        return this;
    }

    private void showCurrent() {

        // System.out.println(nn);
        if (sections.size() > currentSection.get()) {
            label.setText(sections.get(currentSection.get()).title());
            this.setFar();
        }
    }

    public KiMenu section(KiSection it) {

        // this.width.bind(nn);
        // adjust();
        final int n = sections.size();
        KiJob job = new KiJob() {

            @Override
            public void start() {
                currentSection.set(n);
            }
        };

        it.order(sections.size()).width(iconWidth).height(iconHeight).onSelect(job);

        // it.image(new Image(this.getClass().getResourceAsStream("section.png")));
        sections.add(it);
        sectionsGroup.getChildren().add(it.node());

        // move(0);
        currentSection.set(0);

        return this;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com

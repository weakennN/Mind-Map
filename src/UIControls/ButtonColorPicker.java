package UIControls;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ButtonColorPicker extends Region {

    private Button button;
    private ColorPicker colorPicker;
    private Circle circle;

    public ButtonColorPicker() {

        this.init();
    }

    private void init() {

        this.button = new Button();
        this.circle = new Circle(12);
        this.circle.setStroke(Color.valueOf("dbd3d3"));
        this.circle.setFill(Color.TRANSPARENT);
        this.button.setMinSize(35, 40);
        this.button.setGraphic(this.circle);
        this.colorPicker = new ColorPicker();
        this.colorPicker.setTranslateX(this.button.getLayoutX() - 85);
        this.colorPicker.setVisible(false);
        this.setActions();

        super.getStylesheets().add("Style/ButtonColorPicker.css");

        super.getChildren().add(new VBox(this.button, this.colorPicker));
    }

    private void setActions() {

        this.colorPicker.setOnHiding(e -> {

            this.circle.setFill(this.colorPicker.getValue());
            this.button.setGraphic(this.circle);
        });

        this.button.setOnAction(e -> {

            this.colorPicker.show();
        });
    }

    public ColorPicker getColorPicker() {
        return this.colorPicker;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 40;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 45;
    }

    @Override
    public Orientation getContentBias() {
        return Orientation.HORIZONTAL;
    }
}

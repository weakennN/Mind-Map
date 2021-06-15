package Nodes;

import Common.GlobalVariables;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

import java.util.List;

public class TopicNode extends Node {

    private String title;
    private TextArea textArea;

    public TopicNode(Node parent, double posX, double posY) {

        super(parent, GlobalVariables.DEFAULT_TOPIC_NODE_WIDTH + 50, GlobalVariables.DEFAULT_TOPIC_NODE_HEIGHT + 50, posX, posY);
        this.title = GlobalVariables.DEFAULT_TOPIC_TEXT;
        this.textArea = new TextArea(this.title);
        this.textArea.setWrapText(true);
        this.textArea.setPrefHeight(GlobalVariables.DEFAULT_TOPIC_NODE_HEIGHT);
        this.textArea.setPrefWidth(GlobalVariables.DEFAULT_TOPIC_NODE_WIDTH);
        this.textArea.setPadding(new Insets(10, 10, 10, 10));
        this.textArea.setLayoutX(posX + 25);
        this.textArea.setLayoutY(posY + 25);
        getChildren().addAll(this.textArea);
        super.setViewOrder(0);

        StrokeType strokeType = StrokeType.INSIDE;
        StrokeLineJoin strokeLineJoin = StrokeLineJoin.MITER;
        StrokeLineCap strokeLineCap = StrokeLineCap.BUTT;
        double miterLimit = 10;
        double dashOffset = 0;
        List<Double> dashArray = null;

        BorderStrokeStyle style = new BorderStrokeStyle(strokeType, strokeLineJoin, strokeLineCap, miterLimit, dashOffset, dashArray);
        BorderStroke stroke = new BorderStroke(Color.valueOf("08f040"), style, new CornerRadii(20), new BorderWidths(5));
        super.setBorder(new Border(stroke));

        BackgroundFill myBF = new BackgroundFill(Color.valueOf("08ff80"), new CornerRadii(20),
                new Insets(10));
        super.setBackground(new Background(myBF));

    }

    public TopicNode(Node parent) {

        this(parent, 0, 0);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    @Override
    protected double computePrefHeight(double width) {
        return this.textArea.getPrefHeight() + 10;
    }

    @Override
    protected double computePrefWidth(double height) {
        return this.textArea.getPrefWidth() + 10;
    }

    @Override
    public Orientation getContentBias() {
        return Orientation.HORIZONTAL;
    }

    public TextArea getTextArea() {
        return this.textArea;
    }
}

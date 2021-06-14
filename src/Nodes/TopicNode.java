package Nodes;

import Common.GlobalVariables;
import javafx.geometry.Orientation;
import javafx.scene.control.TextArea;

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
        getChildren().addAll(this.textArea);
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

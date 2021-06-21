package Nodes;

import Common.GlobalVariables;
import javafx.geometry.Orientation;
import javafx.scene.control.TextArea;

public class TopicNode extends Node {

    private String title;
    private TextArea textArea;

    public TopicNode(Node parent, double posX, double posY) {

        super(parent, GlobalVariables.DEFAULT_TOPIC_NODE_WIDTH, GlobalVariables.DEFAULT_TOPIC_NODE_HEIGHT, posX, posY);
        this.title = GlobalVariables.DEFAULT_TOPIC_TEXT;
        this.textArea = new TextArea();
        this.textArea.setPromptText(this.title);
        /*this.textArea.setOnMouseClicked(e -> {

            this.textArea.setPrefWidth(this.textArea.getPrefWidth() + 1);
            super.setMinWidth(super.getWidth() + 1);
        });

         */
        this.textArea.setWrapText(true);
        this.textArea.setPrefHeight(25);
        this.textArea.setPrefWidth(125);
        this.textArea.setStyle("-fx-background-color: transparent");
        this.textArea.setLayoutX(posX + 25);
        this.textArea.setLayoutY(posY + 25);
        getChildren().addAll(this.textArea);
        super.setViewOrder(0);
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
        return super.getSize().y;
    }

    @Override
    protected double computePrefWidth(double height) {
        return super.getSize().x;
    }

    @Override
    public Orientation getContentBias() {
        return Orientation.HORIZONTAL;
    }

    public TextArea getTextArea() {
        return this.textArea;
    }
}

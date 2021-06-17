package Nodes;

import Common.GlobalVariables;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BranchNode extends Node {

    private TextArea textArea;

    public BranchNode(Node parent, double posX, double posY) {
        super(parent, GlobalVariables.BRANCH_NODE_WIDTH, GlobalVariables.BRANCH_NODE_HEIGHT, posX, posY);

        this.textArea = new TextArea();
        this.textArea.setPromptText("Branch");
        this.textArea.setWrapText(true);
        this.textArea.setPrefHeight(50);
        this.textArea.setPrefWidth(80);
        this.textArea.setLayoutX(posX + 25);
        this.textArea.setLayoutY(posY + 25);
        this.textArea.setStyle("-fx-background-color: transparent");
        getChildren().addAll(this.textArea);
        super.setViewOrder(1);
        BackgroundFill myBF = new BackgroundFill(Color.valueOf("f7fafa"), new CornerRadii(20),
                new Insets(5));
        super.setBackground(new Background(myBF));
    }

    public BranchNode(Node parent) {

        this(parent, 0, 0);
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

}

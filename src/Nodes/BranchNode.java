package Nodes;

import Common.GlobalVariables;
import javafx.geometry.Orientation;
import javafx.scene.control.TextArea;

public class BranchNode extends Node {

    private TextArea textArea;

    public BranchNode(Node parent, double posX, double posY) {
        super(parent, GlobalVariables.BRANCH_NODE_WIDTH, GlobalVariables.BRANCH_NODE_HEIGHT, posX, posY);

        this.textArea = new TextArea("Branch");
        this.textArea.setWrapText(true);
        this.textArea.setPrefHeight(GlobalVariables.BRANCH_NODE_WIDTH);
        this.textArea.setPrefWidth(GlobalVariables.BRANCH_NODE_WIDTH);
        getChildren().addAll(this.textArea);
        super.setViewOrder(1);
    }

    public BranchNode(Node parent) {

        this(parent, 0, 0);
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

}

package Nodes;

import Common.GlobalVariables;
import javafx.geometry.Orientation;
import javafx.scene.control.TextArea;

public class BranchNode extends Node {

    public BranchNode(Node parent, double posX, double posY) {
        super(parent, GlobalVariables.BRANCH_NODE_WIDTH, GlobalVariables.BRANCH_NODE_HEIGHT, posX, posY);

        super.setViewOrder(1);
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

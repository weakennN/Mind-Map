package Nodes;

import Common.GlobalVariables;
import javafx.geometry.Orientation;

public class BranchNode extends Node {

    public BranchNode() {

    }

    public BranchNode(Node parent) {
        super(parent, GlobalVariables.BRANCH_NODE_WIDTH, GlobalVariables.BRANCH_NODE_HEIGHT);

        super.setViewOrder(1);
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

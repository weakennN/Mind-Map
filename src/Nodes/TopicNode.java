package Nodes;

import Common.GlobalVariables;
import javafx.geometry.Orientation;

public class TopicNode extends Node {

    public TopicNode(){

    }

    public TopicNode(Node parent) {

        super(parent, GlobalVariables.DEFAULT_TOPIC_NODE_WIDTH, GlobalVariables.DEFAULT_TOPIC_NODE_HEIGHT);

        super.setViewOrder(0);
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

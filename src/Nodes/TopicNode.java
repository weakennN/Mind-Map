package Nodes;

import Common.GlobalVariables;

public class TopicNode extends Node {

    private String title;

    public TopicNode(Node parent, double posX, double posY) {

        super(parent, GlobalVariables.DEFAULT_TOPIC_NODE_WIDTH, GlobalVariables.DEFAULT_TOPIC_NODE_HEIGHT, posX, posY);
        this.title = GlobalVariables.DEFAULT_TOPIC_TEXT;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }
}

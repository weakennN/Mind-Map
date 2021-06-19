package Nodes.Skin.SkinProperty;

import Nodes.Node;

public abstract class SkinProperty {

    private Node node;

    public SkinProperty(Node node) {

        this.node = node;
        this.init();
    }

    public abstract void init();

    public Node getNode() {
        return this.node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
}

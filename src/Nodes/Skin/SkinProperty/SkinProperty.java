package Nodes.Skin.SkinProperty;

import Nodes.Node;

public abstract class SkinProperty {

    public SkinProperty(Node node) {

        this.init(node);
    }

    public abstract void init(Node node);
}

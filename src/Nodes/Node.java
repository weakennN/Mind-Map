package Nodes;

import mikera.vectorz.Vector2;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {

    private Node parent;
    private List<Node> children;
    private Vector2 size;
    private Vector2 pos;

    public Node(Node parent, double width, double height, double posX, double posY) {

        this.parent = parent;
        this.children = new ArrayList<>();
        this.size = new Vector2(width, height);
        this.pos = new Vector2(posX, posY);
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public Vector2 getSize() {
        return this.size;
    }

    public Vector2 getPos() {
        return this.pos;
    }

    public void setSize(double width, double height) {
        this.size = new Vector2(width, height);
    }

    public void setPos(double posX, double posY) {
        this.pos = new Vector2(posX, posY);
    }
}

package Nodes;

import javafx.scene.shape.Line;

public class Connection extends Line {

    private Node parent;
    private Node connected;

    public Connection(Node parent, Node connected) {

        this.parent = parent;
        this.connected = connected;
        super.setViewOrder(2);
    }

    public Node parent() {
        return this.parent;
    }

    public Node getConnected() {
        return this.connected;
    }
}

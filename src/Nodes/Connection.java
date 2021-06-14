package Nodes;

import javafx.scene.shape.Line;

public class Connection extends Line {

    private Node parent;
    private Node connected;

    public Connection(Node parent, Node connected) {

        this.parent = parent;
        this.connected = connected;

        super.setStartX(this.parent.getLayoutX());
        super.setEndX(this.connected.getLayoutX());
        super.setStartY(this.parent.getLayoutY());
        super.setEndY(this.connected.getLayoutY());
    }

    public Node parent() {
        return this.parent;
    }

    public Node getConnected() {
        return this.connected;
    }
}

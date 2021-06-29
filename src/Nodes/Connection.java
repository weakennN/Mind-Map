package Nodes;

import javafx.scene.shape.Line;

public class Connection extends Line {

    private Node parent;
    private Node connected;

    private static double currentScale = 1;

    public Connection(Node parent, Node connected) {

        this.parent = parent;
        this.connected = connected;
        this.setScale(currentScale);
        super.setViewOrder(2);
    }

    public Node parent() {
        return this.parent;
    }

    public Node getConnected() {
        return this.connected;
    }

    public void setScale(double scale) {
        super.setStrokeWidth(scale);
        currentScale = scale;
    }
}

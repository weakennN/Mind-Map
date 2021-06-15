package Nodes;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import mikera.vectorz.Vector2;

import java.util.ArrayList;
import java.util.List;

public abstract class Node extends Region {

    private Node parent;

    private List<Connection> connections;
    private Vector2 size;
    private Vector2 pos;

    public Node(Node parent, double width, double height, double posX, double posY) {

        super();
        this.parent = parent;
        this.connections = new ArrayList<>();
        this.size = new Vector2(width, height);
        this.pos = new Vector2(posX, posY);
        super.setLayoutX(posX);
        super.setLayoutY(posY);
        super.setMinSize(this.size.x, this.size.y);
    /*    BackgroundFill myBF = new BackgroundFill(Color.BLUEVIOLET, new CornerRadii(1),
                new Insets(0.0,0.0,0.0,0.0));
        super.setBackground(new Background(myBF));


     */

    }

    public void addConnection(Connection connection) {
        this.connections.add(connection);
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

    public List<Connection> getConnections() {
        return this.connections;
    }

    public void removeConnection(Connection connection) {
        this.connections.remove(connection);
    }

}

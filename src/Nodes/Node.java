package Nodes;

import Nodes.Skin.Skin;
import javafx.scene.layout.Region;
import mikera.vectorz.Vector2;

import java.util.ArrayList;
import java.util.List;

public abstract class Node extends Region {

    private Node parent;

    private transient List<Connection> connections;
    private Skin skin;
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

    public void setSkin(Skin skin) {
        this.skin = skin;
    }

    public Skin getSkin() {
        return this.skin;
    }
}

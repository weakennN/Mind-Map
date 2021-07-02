package Nodes;

import NodeSkin.Skin.Skin;
import SaveSystem.Annotaions.PrimitiveSerialize;
import SaveSystem.Annotaions.SkinSerialize;
import SaveSystem.Annotaions.Vector2Serialize;
import javafx.scene.layout.Region;
import mikera.vectorz.Vector2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Node extends Region implements Serializable {

    private Node parent;
    private List<Connection> connections;
    @SkinSerialize
    private Skin skin;
    @Vector2Serialize
    private Vector2 size;
    @Vector2Serialize
    private Vector2 pos;
    @PrimitiveSerialize
    private double defaultWidth;
    private NodeManager manager;

    @PrimitiveSerialize
    public static double currentScale = 1;

    public Node() {

    }

    public Node(Node parent, double width, double height) {

        super();
        this.parent = parent;
        this.connections = new ArrayList<>();
        this.size = new Vector2(width, height);
        this.defaultWidth = width;
        this.pos = new Vector2();
        this.manager = new NodeManager(this);
        super.setMinSize(this.size.x, this.size.y);
        this.setScale(currentScale);
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

    public void add(Region region) {
        super.getChildren().add(region);
    }

    public double getDefaultWidth() {
        return this.defaultWidth;
    }

    public NodeManager getManager() {
        return this.manager;
    }

    public void setScale(double scale) {
        super.setScaleX(scale);
        super.setScaleY(scale);
        currentScale = scale;
    }
}

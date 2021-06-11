import java.util.ArrayList;
import java.util.List;

public abstract class Node {

    private String id;
    private Node parent;
    private List<Node> children;
    private double width, height;

    public Node(String id, Node parent, double width, double height) {

        this.id = id;
        this.parent = parent;
        this.children = new ArrayList<>();
        this.width = width;
        this.height = height;
    }

    public abstract void show(); // Maybe this will the the reference to the UI

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public List<Node> getChildren() {
        return this.children;
    }
}

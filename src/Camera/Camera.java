package Camera;

import Common.NodeClicked;
import Core.MindMap;
import Nodes.Connection;
import Nodes.Node;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import mikera.vectorz.Vector2;

import java.util.HashSet;
import java.util.List;

public class Camera extends PerspectiveCamera {

    private MindMap mindMap;
    private Vector2 pos;
    private Scene scene;
    private double scale;
    private HashSet<KeyCode> pressedKeys;

    public Camera(MindMap mindMap, Scene scene) {
        super();

        this.mindMap = mindMap;
        this.pos = new Vector2(0, 0);
        this.scale = 1;
        this.scene = scene;
        this.pressedKeys = new HashSet<>();
        super.setLayoutX(0);
        super.setLayoutY(0);
    }

    public void init() {

        this.scene.setOnMouseDragged(e -> {

            if (NodeClicked.node == null) {
                this.translate(e.getSceneX(), e.getSceneY());
            }
        });

        this.scene.setOnMouseReleased(e -> {

            this.reset();
        });

        this.scene.setOnKeyPressed(e -> {
            this.pressedKeys.add(e.getCode());
        });

        this.scene.setOnKeyReleased(e -> {
            this.pressedKeys.remove(e.getCode());
        });

        this.scene.setOnScroll(e -> {

            if (this.pressedKeys.contains(KeyCode.CONTROL)) {
                this.zoom(e.getDeltaX(), e.getDeltaY());
            }
        });
    }

    public void translate(double mouseX, double mouseY) {

        double velX = 0;
        double velY = 0;

        if (this.pos.x != 0 && this.pos.y != 0) {

            velX = this.pos.x - mouseX;
            velY = this.pos.y - mouseY;
        }

        List<Node> nodes = this.mindMap.getNodes();

        for (int i = 0; i < nodes.size(); i++) {

            Node node = nodes.get(i);

            node.setLayoutX(node.getLayoutX() - velX);
            node.setLayoutY(node.getLayoutY() - velY);

            node.getManager().moveConnections();

            node.setPos(node.getLayoutX(), node.getLayoutY());
        }

        this.pos.x = mouseX;
        this.pos.y = mouseY;
    }

    public void zoom(double deltaX, double deltaY) {

        if (deltaY > 0 && this.scale < 3) {
            this.scale += 0.1;
        } else if (deltaY < 0 && this.scale > 0.3) {
            this.scale -= 0.1;
        }

        List<Node> nodes = this.mindMap.getNodes();

        for (Node node : nodes) {

            node.setScale(this.scale);

            List<Connection> connections = node.getConnections();

            for (Connection connection : connections) {

                connection.setScale(this.scale);
            }
        }
    }

    public void reset() {
        this.pos.x = 0;
        this.pos.y = 0;
    }
}

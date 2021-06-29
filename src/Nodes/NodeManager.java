package Nodes;

import Common.NodeClicked;
import mikera.vectorz.Vector2;

import java.util.List;

public class NodeManager {

    private Node node;
    private Vector2 oldPos;

    public NodeManager(Node node) {

        this.node = node;
        this.oldPos = new Vector2();
        this.nodeOnDrag();
        this.nodeOnRelease();
    }

    private void nodeOnDrag() {

        this.node.setOnMouseDragged(e -> {

            if (e.isPrimaryButtonDown()) {

                double velX = 0;
                double velY = 0;

                if (this.oldPos.x != 0 && this.oldPos.y != 0) {

                    velX = this.oldPos.x - e.getSceneX();
                    velY = this.oldPos.y - e.getSceneY();
                }

                node.setLayoutX(node.getLayoutX() - velX);
                node.setLayoutY(node.getLayoutY() - velY);

                this.moveConnections();

                this.oldPos.x = e.getSceneX();
                this.oldPos.y = e.getSceneY();

                node.setPos(node.getLayoutX(), node.getLayoutY());
            }

            NodeClicked.node = node;
        });
    }

    private void nodeOnRelease() {

        this.node.setOnMouseReleased(e -> {

            this.oldPos.x = 0;
            this.oldPos.y = 0;
        });

    }

    public void moveConnections() {

        List<Connection> connections = this.node.getConnections();

        for (int i = 0; i < connections.size(); i++) {

            Connection connection = connections.get(i);

            if (connection.parent() == node) {

                connection.setStartX(node.getLayoutX() + node.getSize().x / 2);
                connection.setStartY(node.getLayoutY() + node.getSize().y / 2);
            } else {

                connection.setEndX(node.getLayoutX() + node.getSize().x / 2);
                connection.setEndY(node.getLayoutY() + node.getSize().y / 2);
            }
        }
    }
}

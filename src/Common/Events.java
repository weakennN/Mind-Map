package Common;

import Nodes.Connection;
import Nodes.Node;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class Events {

    public static void move(Node node) {

        EventHandler<MouseEvent> event = mouseEvent -> {

            node.setLayoutX(mouseEvent.getSceneX());
            node.setLayoutY(mouseEvent.getSceneY());

            List<Connection> connections = node.getConnections();

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

            node.setPos(mouseEvent.getSceneX(), mouseEvent.getSceneY());
        };

        node.setOnMouseDragged(event);
    }

}

package Common;

import Nodes.Connection;
import Nodes.Node;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class Events {

    public static void move(Node node) {

        EventHandler<MouseEvent> event = mouseEvent -> {

            if (mouseEvent.isPrimaryButtonDown()) {
                node.setLayoutX(mouseEvent.getSceneX());
                node.setLayoutY(mouseEvent.getSceneY());

                List<Connection> connections = node.getConnections();

                GlobalMethods.moveConnections(connections, node);

                node.setPos(mouseEvent.getSceneX(), mouseEvent.getSceneY());

            }
            NodeClicked.node = node;
        };


        node.setOnMouseDragged(event);
    }

}

package Common;

import Nodes.Connection;
import Nodes.Node;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.robot.Robot;

import java.util.List;

public class Events {

    public static void move(Node node) {

        EventHandler<MouseEvent> event = mouseEvent -> {

            Robot mouse = new Robot();
            node.setLayoutX(mouseEvent.getSceneX());
            node.setLayoutY(mouseEvent.getSceneY());

            List<Connection> connections = node.getConnections();

            for (int i = 0;i < connections.size();i++){

                Connection connection = connections.get(i);

                if (connection.parent() == node){
                    connection.setStartX(node.getLayoutX());
                    connection.setStartY(node.getLayoutY());
                }else {

                    connection.setEndX(node.getLayoutX());
                    connection.setEndY(node.getLayoutY());
                }
            }

            node.setPos(mouse.getMouseX(), mouse.getMouseY());
        };

        node.setOnMouseDragged(event);
    }

    public static void clicked(Node node) {

        node.setOnMouseClicked(e -> {

            NodeClicked.node = node;
        });
    }
}

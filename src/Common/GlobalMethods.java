package Common;

import Nodes.Connection;
import Nodes.Node;

import java.util.List;

public class GlobalMethods {

    public static void moveConnections(List<Connection> connections, Node node) {

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

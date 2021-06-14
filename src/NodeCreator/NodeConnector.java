package NodeCreator;

import Nodes.Connection;
import Nodes.Node;
import mikera.vectorz.Vector2;

import java.util.List;

public class NodeConnector {

    public NodeConnector() {

    }

    // TODO: add to check if connection with this positions exist and add logic for setting the end y of the connection
    public Connection connectNodes(Node parent, Node child) {

        Connection connection = new Connection(parent, child);
        parent.addConnection(connection);
        child.addConnection(connection);

        List<Vector2> startingPositions = this.getStatingPositions(parent);

        int random = (int) Math.floor(Math.random() * (startingPositions.size() - 1 + 1) + 0);

        connection.setStartX(startingPositions.get(random).x);
        connection.setEndX(parent.getLayoutX() + 100);
        connection.setStartY(startingPositions.get(random).y);
        connection.setEndY(child.getLayoutY() + 100);

        child.setLayoutX(connection.getEndX());
        child.setLayoutY(connection.getEndY());

        return connection;
    }

    private List<Vector2> getStatingPositions(Node parent) {

        return List.of(new Vector2(parent.getLayoutX() + parent.getSize().x, parent.getLayoutY() + (parent.getSize().y / 2)),
                new Vector2(parent.getLayoutX(), parent.getLayoutY() + (parent.getSize().y / 2)), new Vector2(parent.getLayoutX() + (parent.getSize().x / 2),
                        parent.getLayoutY()), new Vector2(parent.getLayoutX() + (parent.getSize().x / 2), parent.getLayoutY() + parent.getSize().y));
    }
}

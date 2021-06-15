package NodeCreator;

import Nodes.Connection;
import Nodes.Node;
import mikera.vectorz.Vector2;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NodeConnector {

    private ThreadLocalRandom random;

    public NodeConnector() {

        this.random = ThreadLocalRandom.current();
    }

    // TODO: try to create the child position then connect them with the parent

    public Connection connectNodes(Node parent, Node child) {

        Connection connection = new Connection(parent, child);

        parent.addConnection(connection);
        child.addConnection(connection);

        Vector2 startingPositions = new Vector2(parent.getLayoutX() + (parent.getSize().x / 2), parent.getLayoutY() + (parent.getSize().y / 2));

        double randomX = random.nextDouble(150, 300);
        double randomY = random.nextDouble(150, 300);

        int[] randomScales = this.getRandomScale();

        randomX *= randomScales[0];
        randomY *= randomScales[1];

        connection.setStartX(startingPositions.x);
        connection.setEndX(parent.getLayoutX() + randomX);
        connection.setStartY(startingPositions.y);
        connection.setEndY(parent.getLayoutY() + randomY);

        child.setLayoutX(connection.getEndX());
        child.setLayoutY(connection.getEndY());

        return connection;
    }

    private int[] getRandomScale() {

        int[] randomScale = new int[2];
        List<Integer> randomScales = List.of(1, -1, 0);

        randomScale[0] = randomScales.get(random.nextInt(0, randomScales.size()));
        randomScale[1] = randomScales.get(random.nextInt(0, randomScales.size()));

        while (randomScale[0] == 0 && randomScale[1] == 0) {

            randomScale[0] = random.nextInt(0, randomScales.size());
            randomScale[1] = random.nextInt(0, randomScales.size());
        }

        return randomScale;
    }
}

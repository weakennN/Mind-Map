package SaveSystem;

import Common.NodeClicked;
import Core.App;
import Nodes.Connection;
import Nodes.Node;
import Nodes.NodeManager;
import javafx.scene.input.MouseButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveSystem {

    private App app;
    private AlertBox alertBox;
    private Map<String, Node> serializedNodes;

    public SaveSystem(App app) {
        this.app = app;
        this.alertBox = new AlertBox(this.app.getUi(), this);
        this.serializedNodes = new HashMap<>();
    }

    public void save() {

        List<Node> nodes = this.app.getMindMaps().get(0).getNodes();

        Saver.createNewFile();

        for (Node node : nodes) {
            Saver.save(node);
        }
    }

    public void load() {

        while (true) {

            Node node = (Node) Saver.load();

            if (node == null) {
                break;
            }

            node.setMinSize(node.getSize().x, node.getSize().y);
            node.getSkin().setNode(node);
            node.setLayoutX(node.getPos().x);
            node.setLayoutY(node.getPos().y);
            node.setNodeManager(new NodeManager(node));
            node.setScale(Node.currentScale);
            this.serializedNodes.put(node.getUniqueId(), node);

            node.setOnMouseClicked(e -> {
                if (e.getButton() == MouseButton.SECONDARY) {
                    NodeClicked.node = node;
                    this.app.getMindMaps().get(0).getMenu(node.getMenu()).show(node, e.getSceneX() - (this.app.getMindMaps().get(0).getMenu(node.getMenu()).getWidth() / 2)
                            , e.getSceneY() + (this.app.getMindMaps().get(0).getMenu(node.getMenu()).getHeight() / 2));
                }
            });

            this.app.getMindMaps().get(0).addNode(node);
        }

        this.deserializeConnections();
    }

    private void deserializeConnections() {

        List<String[]> connectedNodes = new ArrayList<>();

        List<Node> nodes = this.app.getMindMaps().get(0).getNodes();

        for (Node node : nodes) {

            List<String[]> connectionsIds = node.getConnectionIds();

            for (int i = 0; i < connectionsIds.size(); i++) {
                String[] connectionId = connectionsIds.get(i);

                if (!this.isConnected(connectedNodes, connectionId)) {
                    Connection connection = new Connection(this.serializedNodes.get(connectionId[0]), this.serializedNodes.get(connectionId[1]));
                    connection.setScale(Node.currentScale);
                    Node first = this.serializedNodes.get(connectionId[0]);
                    Node second = this.serializedNodes.get(connectionId[1]);
                    connectedNodes.add(new String[]{connectionId[0], connectionId[1]});
                    first.addConnection(connection);
                    second.addConnection(connection);

                    connection.setStartX(first.getLayoutX() + first.getSize().x / 2);
                    connection.setStartY(first.getLayoutY() + first.getSize().y / 2);
                    connection.setEndX(second.getLayoutX() + second.getSize().x / 2);
                    connection.setEndY(second.getLayoutY() + second.getSize().y / 2);

                    this.app.getMindMaps().get(0).getChildren().add(connection);
                }
            }
        }
    }

    private boolean isConnected(List<String[]> connectedNodes, String[] newConnection) {
        for (String[] connected : connectedNodes) {
            if (connected[0].equals(newConnection[0]) && connected[1].equals(newConnection[1])) {
                return true;
            }
        }
        return false;
    }
}

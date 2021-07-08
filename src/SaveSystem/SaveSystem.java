package SaveSystem;

import Common.IdGenerator;
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
    private Map<Integer, Node> serializedNodes;

    public SaveSystem(App app) {
        this.app = app;
        this.alertBox = new AlertBox(this.app.getUi(), this);
        this.serializedNodes = new HashMap<>();
    }

    public void save() {

        Saver.initOut();

        List<Node> nodes = this.app.getMindMap().getNodes();

        Saver.createNewFile();

        for (Node node : nodes) {
            Saver.save(node);
        }

        Saver.closeOut();
    }

    public void load() {

        Saver.initIn();

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
                    this.app.getMindMap().getMenu(node.getMenu()).show(node, e.getSceneX() - (this.app.getMindMap().getMenu(node.getMenu()).getWidth() / 2)
                            , e.getSceneY() + (this.app.getMindMap().getMenu(node.getMenu()).getHeight() / 2));
                }
            });

            this.app.getMindMap().addNode(node);
        }

        if (this.app.getMindMap().getNodes().size() >= 1) {
            IdGenerator.setCurrentId(this.app.getMindMap().getNodes().get(this.app.getMindMap().getNodes().size() - 1).getUniqueId());
        }

        Saver.closeIn();

        this.deserializeConnections();
    }

    private void deserializeConnections() {

        List<Tuple<Integer, Integer>> connectedNodes = new ArrayList<>();

        List<Node> nodes = this.app.getMindMap().getNodes();

        for (Node node : nodes) {

            List<Tuple<Integer, Integer>> connectionsIds = node.getConnectionIds();

            for (int i = 0; i < connectionsIds.size(); i++) {
                Tuple<Integer, Integer> connectionId = connectionsIds.get(i);

                if (!this.isConnected(connectedNodes, connectionId)) {
                    Connection connection = new Connection(this.serializedNodes.get(connectionId.item1), this.serializedNodes.get(connectionId.item2));
                    connection.setScale(Node.currentScale);
                    Node first = this.serializedNodes.get(connectionId.item1);
                    Node second = this.serializedNodes.get(connectionId.item2);
                    connectedNodes.add(new Tuple<>(connectionId.item1, connectionId.item2));
                    first.addConnection(connection);
                    second.addConnection(connection);

                    connection.setStartX(first.getLayoutX() + first.getSize().x / 2);
                    connection.setStartY(first.getLayoutY() + first.getSize().y / 2);
                    connection.setEndX(second.getLayoutX() + second.getSize().x / 2);
                    connection.setEndY(second.getLayoutY() + second.getSize().y / 2);

                    this.app.getMindMap().getChildren().add(connection);
                }
            }
        }
    }

    private boolean isConnected(List<Tuple<Integer, Integer>> connectedNodes, Tuple<Integer, Integer> newConnection) {
        for (Tuple<Integer, Integer> connected : connectedNodes) {
            if (connected.item1.equals(newConnection.item1) && connected.item2.equals(newConnection.item2)) {
                return true;
            }
        }
        return false;
    }
}

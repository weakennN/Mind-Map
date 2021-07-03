package SaveSystem;

import Core.App;
import Nodes.Node;
import Nodes.NodeManager;

import java.util.ArrayList;
import java.util.List;

public class SaveSystem {

    private App app;
    private AlertBox alertBox;

    public SaveSystem(App app) {
        this.app = app;
        this.alertBox = new AlertBox(this.app.getUi(), this);
    }

    public void save() {
        List<Node> nodes = this.app.getMindMaps().get(0).getNodes();

        for (Node node : nodes) {
            Saver.save(node);
        }

        //   Saver.close();
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
            node.setConnections(new ArrayList<>());

            this.app.getMindMaps().get(0).addNode(node);
        }

        // Saver.close();
    }
}

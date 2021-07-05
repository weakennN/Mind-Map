package SaveSystem;

import Common.GlobalVariables;
import Common.NodeClicked;
import Core.App;
import Nodes.Node;
import Nodes.NodeManager;
import javafx.scene.input.MouseButton;

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
            node.setConnections(new ArrayList<>());

            node.setOnMouseClicked(e -> {
                if (e.getButton() == MouseButton.SECONDARY) {
                    NodeClicked.node = node;
                    this.app.getMindMaps().get(0).getMenu(GlobalVariables.NODE_MENU).show(node, e.getSceneX() - (this.app.getMindMaps().get(0).getMenu(GlobalVariables.NODE_MENU).getWidth() / 2)
                            , e.getSceneY() + (this.app.getMindMaps().get(0).getMenu(GlobalVariables.NODE_MENU).getHeight() / 2));
                }
            });

            this.app.getMindMaps().get(0).addNode(node);
        }
    }
}

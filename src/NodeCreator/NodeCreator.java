package NodeCreator;

import Common.NodeClicked;
import Core.MindMap;
import Nodes.Node;
import UI.UI;
import javafx.scene.input.MouseButton;

public abstract class NodeCreator {

    private UI ui;
    private NodeConnector connector;

    public NodeCreator(UI ui) {

        this.ui = ui;
        this.connector = new NodeConnector();
    }

    public abstract Node createNode(Node parent, MindMap mindMap);

    public UI getUi() {
        return this.ui;
    }

    protected NodeConnector getConnector() {
        return this.connector;
    }

    public void initDefaultActions(Node node, MindMap mindMap) {

        node.setOnMouseClicked(e -> {

            if (e.getButton() == MouseButton.SECONDARY) {
                NodeClicked.node = node;
                mindMap.getMenu(node.getMenu()).show(node, e.getSceneX() - (mindMap.getMenu(node.getMenu()).getWidth() / 2)
                        , e.getSceneY() + (mindMap.getMenu(node.getMenu()).getHeight() / 2));
            }

        });
    }
}

package NodeCreator;

import Common.Events;
import Common.NodeClicked;
import Core.MindMap;
import Nodes.BranchNode;
import Nodes.Connection;
import Nodes.Node;
import UI.UI;
import javafx.scene.input.MouseButton;

public class BranchNodeCreator extends NodeCreator {

    public BranchNodeCreator(UI ui) {
        super(ui);
    }

    @Override
    public Node createNode(Node parent, MindMap mindMap) {

        BranchNode branchNode = new BranchNode(parent);

        Events.move(branchNode);

        Connection connection = null;

        if (parent != null) {
            connection = super.getConnector().connectNodes(parent, branchNode);
            mindMap.getChildren().add(connection);
        }

        branchNode.setOnMouseClicked(e -> {

            if (e.getButton() == MouseButton.SECONDARY) {
                NodeClicked.node = branchNode;
                mindMap.getMenu("NodeMenu").show(branchNode, e.getSceneX(), e.getSceneY());
            }
        });

        NodeClicked.node = null;
        return branchNode;
    }
}
package NodeCreator;

import Common.Events;
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
        Events.clicked(branchNode);

        Connection connection = super.getConnector().connectNodes(parent, branchNode);

        branchNode.setOnMouseClicked(e -> {

            if (e.getButton() == MouseButton.SECONDARY) {
                mindMap.getMenu("NodeMenu").show(branchNode, e.getSceneX(), e.getSceneY());
            }
        });

        super.getUi().getRoot().getChildren().addAll(branchNode, connection);

        return branchNode;
    }
}
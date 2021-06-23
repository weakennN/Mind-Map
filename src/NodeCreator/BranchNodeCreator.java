package NodeCreator;

import Common.GlobalVariables;
import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Preview.BoundaryPreview;
import NodeCreator.NodePreviewManager.NodePreviewManager;
import Nodes.BranchNode;
import Nodes.Connection;
import Nodes.Node;
import Nodes.Skin.BranchNodeSkin;
import Nodes.Skin.TopicNodeSkin;
import UI.UI;

public class BranchNodeCreator extends NodeCreator {

    public BranchNodeCreator(UI ui) {
        super(ui);
    }

    @Override
    public Node createNode(Node parent, MindMap mindMap) {

        BranchNode branchNode = new BranchNode(parent);
        branchNode.setSkin(new BranchNodeSkin(branchNode));
        NodePreviewManager.addPreview(branchNode, new BoundaryPreview());
        Connection connection = null;

        if (parent != null) {
            connection = super.getConnector().connectNodes(parent, branchNode);
            mindMap.getChildren().add(connection);
        }

        super.initDefaultActions(branchNode, mindMap, GlobalVariables.NODE_MENU);

        NodeClicked.node = null;
        return branchNode;
    }
}
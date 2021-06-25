package NodeCreator;

import Common.GlobalVariables;
import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.ContentPreview;
import NodeSkin.Skin.BranchNodeSkin;
import Nodes.BranchNode;
import Nodes.Connection;
import Nodes.Node;
import UI.UI;

public class BranchNodeCreator extends NodeCreator {

    public BranchNodeCreator(UI ui) {
        super(ui);
    }

    @Override
    public Node createNode(Node parent, MindMap mindMap) {

        BranchNode branchNode = new BranchNode(parent);
        branchNode.setSkin(new BranchNodeSkin(branchNode));
        branchNode.getSkin().addPreview(new BoundaryPreview());
        branchNode.getSkin().addPreview(new ContentPreview());

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
package NodeCreator;

import Common.GlobalVariables;
import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Preview.BoundaryPreview;
import NodeCreator.NodePreviewManager.NodePreviewManager;
import Nodes.Node;
import NodeSkin.Skin.TopicNodeSkin;
import Nodes.TopicNode;
import UI.UI;

public class TopicNodeCreator extends NodeCreator {

    public TopicNodeCreator(UI ui) {
        super(ui);
    }

    @Override
    public Node createNode(Node parent, MindMap mindMap) {

        TopicNode topicNode = new TopicNode(parent);
        topicNode.setSkin(new TopicNodeSkin(topicNode));
        NodePreviewManager.addPreview(topicNode, new BoundaryPreview());

        super.initDefaultActions(topicNode, mindMap, GlobalVariables.NODE_MENU);

        NodeClicked.node = null;
        return topicNode;
    }
}

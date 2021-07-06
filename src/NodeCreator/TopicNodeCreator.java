package NodeCreator;

import Common.GlobalVariables;
import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.ContentPreview;
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
        topicNode.getSkin().addPreview(GlobalVariables.BOUNDARY_PREVIEW_TAG, new BoundaryPreview());
        topicNode.getSkin().addPreview(GlobalVariables.FORMAT_PREVIEW_TAG, new ContentPreview());
        topicNode.setMenu(GlobalVariables.NODE_MENU);

        super.initDefaultActions(topicNode, mindMap);

        NodeClicked.node = null;
        return topicNode;
    }
}
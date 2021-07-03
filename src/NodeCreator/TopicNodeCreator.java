package NodeCreator;

import Common.GlobalVariables;
import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.ContentPreview;
import NodeSkin.Skin.Skin;
import NodeSkin.SkinProperty.BackgroundProperty;
import NodeSkin.SkinProperty.BorderProperty;
import NodeSkin.SkinProperty.SkinProperty;
import NodeSkin.SkinProperty.TopicNodeContentProperty;
import Nodes.Node;
import NodeSkin.Skin.TopicNodeSkin;
import Nodes.NodeManager;
import Nodes.TopicNode;
import SaveSystem.Saver;
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

        //Saver.save(topicNode);

       /* TopicNode topicNode = (TopicNode) Saver.load();
        topicNode.setMinSize(topicNode.getSize().x,topicNode.getSize().y);
        topicNode.getSkin().setNode(topicNode);
        topicNode.setNodeManager(new NodeManager(topicNode));
        topicNode.setConnections(new ArrayList<>());

        */

        super.initDefaultActions(topicNode, mindMap, GlobalVariables.NODE_MENU);

        NodeClicked.node = null;
        return topicNode;
    }
}
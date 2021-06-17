package NodeCreator;

import Common.GlobalVariables;
import Common.NodeClicked;
import Core.MindMap;
import Nodes.Node;
import Nodes.TopicNode;
import UI.UI;

public class TopicNodeCreator extends NodeCreator {

    public TopicNodeCreator(UI ui) {
        super(ui);
    }

    @Override
    public Node createNode(Node parent, MindMap mindMap) {

        TopicNode topicNode = new TopicNode(parent);

        super.initDefaultActions(topicNode, mindMap, GlobalVariables.NODE_MENU);

        NodeClicked.node = null;
        return topicNode;
    }
}

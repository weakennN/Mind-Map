package NodeCreator;

import Common.Events;
import Common.NodeClicked;
import Core.MindMap;
import Nodes.Node;
import Nodes.TopicNode;
import UI.UI;
import javafx.scene.input.MouseButton;

public class TopicNodeCreator extends NodeCreator {

    public TopicNodeCreator(UI ui) {
        super(ui);
    }

    @Override
    public Node createNode(Node parent, MindMap mindMap) {

        TopicNode topicNode = new TopicNode(parent);

        Events.move(topicNode);

        topicNode.setOnMouseClicked(e -> {

            if (e.getButton() == MouseButton.SECONDARY) {
                NodeClicked.node = topicNode;
                mindMap.getMenu("NodeMenu").show(topicNode, e.getSceneX(), e.getSceneY());
            }
        });


        NodeClicked.node = null;
        return topicNode;
    }
}

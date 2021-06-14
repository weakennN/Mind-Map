package NodeCreator;

import Common.Events;
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
        Events.clicked(topicNode);

        super.getUi().getRoot().getChildren().add(topicNode);

        topicNode.setOnMouseClicked(e -> {

            if (e.getButton() == MouseButton.SECONDARY) {
                mindMap.getMenu("NodeMenu").show(topicNode, e.getSceneX(), e.getSceneY());
            }
        });

        return topicNode;
    }
}

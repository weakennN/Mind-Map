package NodeCreator;

import Common.Events;
import Nodes.TopicNode;
import UI.UI;
import javafx.scene.control.TextField;

public class TopicNodeCreator extends NodeCreator {

    public TopicNodeCreator(UI ui) {
        super(ui);
    }

    @Override
    public void createNode(double posX, double posY) {

        // TODO: add the topic node to the mind map list

        TopicNode topicNode = new TopicNode(null, posX, posY);
        TextField textField = new TextField(topicNode.getTitle());
        textField.setLayoutX(topicNode.getSize().x);
        textField.setLayoutY(topicNode.getSize().y);
        textField.setMinSize(topicNode.getSize().x, topicNode.getSize().y);
        Events.move(textField);
        super.getUi().getRoot().getChildren().add(textField);
    }
}

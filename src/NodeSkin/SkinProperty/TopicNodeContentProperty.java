package NodeSkin.SkinProperty;

import Nodes.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class TopicNodeContentProperty extends DefaultNodeContentProperty {

    public TopicNodeContentProperty(){

    }

    public TopicNodeContentProperty(Node node) {
        super(node);
    }

    @Override
    public void init() {
        super.init();

        TextField textField = super.getTextField();

        textField.setPrefHeight(45);
        textField.setPrefWidth(30);
        textField.setMinWidth(30);
        textField.setMinHeight(45);
        textField.setLayoutX(super.getNode().getSize().x / 2  - textField.getPrefWidth() / 2);
        textField.setLayoutY(super.getNode().getSize().y / 2  - textField.getPrefHeight() / 2);
        textField.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
    }
}

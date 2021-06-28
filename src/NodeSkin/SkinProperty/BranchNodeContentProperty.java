package NodeSkin.SkinProperty;

import Nodes.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class BranchNodeContentProperty extends DefaultNodeContentProperty {

    public BranchNodeContentProperty(Node node) {
        super(node);
    }

    @Override
    public void init() {
        super.init();

        TextField textField = super.getTextField();

        textField.setPrefHeight(40);
        textField.setPrefWidth(25);
        textField.setMinWidth(25);
        textField.setMinHeight(40);
        textField.setLayoutX(super.getNode().getSize().x / 2 - textField.getPrefWidth() / 2);
        textField.setLayoutY(super.getNode().getSize().y / 2 - textField.getPrefHeight() / 2);
        textField.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
    }
}

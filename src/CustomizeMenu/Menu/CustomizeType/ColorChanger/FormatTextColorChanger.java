package CustomizeMenu.Menu.CustomizeType.ColorChanger;

import CustomizeMenu.Preview.ContentPreview;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;
import javafx.scene.control.TextField;

public class FormatTextColorChanger extends ColorChanger {

    public FormatTextColorChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void initActions() {

        super.getColorPicker().setOnAction(e -> {

            ContentPreview preview = (ContentPreview) super.getPreview();
            TextField textField = preview.getTextField();
            super.setChanged(true);
        });
    }

    @Override
    public void customizeNode(Node node) {
        String color = super.getColorPicker().getValue().toString();
        color = "#" + color.substring(2);
        node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).getTextFiled().setStyle("-fx-text-inner-color: " + color);
    }
}

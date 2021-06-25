package CustomizeMenu.Menu.CustomizeType.ColorChanger;

import CustomizeMenu.Preview.ContentPreview;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;

public class FormatBorderColorChanger extends ColorChanger {

    public FormatBorderColorChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void initActions() {

        super.getColorPicker().setOnAction(e -> {

            ContentPreview contentPreview = (ContentPreview) super.getPreview();
            TextField textField = contentPreview.getTextField();
            textField.setBorder(new Border(new BorderStroke(super.getColorPicker().getValue(), textField.getBorder().getStrokes().get(0).getLeftStyle(),
                    textField.getBorder().getStrokes().get(0).getRadii(), textField.getBorder().getStrokes().get(0).getWidths())));
            super.setChanged(true);
        });
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).changeBorder(super.getColorPicker().getValue());
    }
}

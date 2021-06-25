package CustomizeMenu.Menu.CustomizeType.ColorChanger;

import CustomizeMenu.Preview.ContentPreview;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;

public class FormatContentColorChanger extends ColorChanger {

    public FormatContentColorChanger(Preview preview) {
        super(preview);

        this.initActions();
    }

    @Override
    protected void initActions() {

        super.getColorPicker().setOnAction(e -> {

            ContentPreview contentPreview = (ContentPreview) super.getPreview();
            TextField textField = contentPreview.getTextField();
            textField.setBackground(new Background(new BackgroundFill(super.getColorPicker().getValue(), textField.getBackground().getFills().get(0).getRadii(),
                    textField.getBackground().getFills().get(0).getInsets())));
            super.setChanged(true);
        });
    }

    @Override
    public void customizeNode(Node node) {

        node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).changeBackground(super.getColorPicker().getValue());
    }
}

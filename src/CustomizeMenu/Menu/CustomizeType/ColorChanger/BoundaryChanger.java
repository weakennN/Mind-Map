package CustomizeMenu.Menu.CustomizeType.ColorChanger;

import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import NodeSkin.SkinProperty.BackgroundProperty;

public class BoundaryChanger extends ColorChanger {

    public BoundaryChanger(Preview preview) {

        super(preview);
    }

    @Override
    protected void initActions() {

        super.getColorPicker().setOnAction(e -> {

            BoundaryPreview preview = (BoundaryPreview) super.getPreview();
            preview.getPreview().setFill(super.getColorPicker().getValue());
            super.setChanged(true);
        });
    }

    @Override
    public void customizeNode(Node node) {

        node.getSkin().getSkinProperty(BackgroundProperty.class).changeColor(super.getColorPicker().getValue());
    }
}

package CustomizeMenu.Menu.CustomizeType.ColorChanger;

import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import NodeSkin.SkinProperty.BorderProperty;

public class BoundaryBorderChanger extends ColorChanger {

    public BoundaryBorderChanger(Preview preview) {

        super(preview);
    }

    @Override
    protected void initActions() {

        super.getColorPicker().setOnAction(e -> {

            BoundaryPreview preview = (BoundaryPreview) super.getPreview();
            preview.getPreview().setStroke(super.getColorPicker().getValue());
            super.setChanged(true);
        });
    }

    @Override
    public void customizeNode(Node node) {

        node.getSkin().getSkinProperty(BorderProperty.class).changeBorderStyle(super.getColorPicker().getValue());
    }
}

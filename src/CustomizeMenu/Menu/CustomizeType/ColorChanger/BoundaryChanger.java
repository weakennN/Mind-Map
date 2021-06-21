package CustomizeMenu.Menu.CustomizeType.ColorChanger;

import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import Nodes.Skin.SkinProperty.BackgroundProperty;

public class BoundaryChanger extends ColorChanger {

    public BoundaryChanger(Preview preview) {

        super(preview);
        this.initActions();
    }

    @Override
    public void customizeNode(Node node) {

        node.getSkin().getSkinProperty(BackgroundProperty.class).changeColor(super.getColorPicker().getValue());
    }

    @Override
    protected void initActions() {

        super.getColorPicker().setOnAction(e -> {

            BoundaryPreview preview = (BoundaryPreview) super.getPreview();
            preview.getPreview().setFill(super.getColorPicker().getValue());
            super.setChanged(true);
        });
    }
}

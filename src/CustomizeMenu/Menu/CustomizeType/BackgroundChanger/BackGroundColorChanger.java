package CustomizeMenu.Menu.CustomizeType.BackgroundChanger;

import CustomizeMenu.Menu.CustomizeType.CustomizeType;
import CustomizeMenu.Preview;
import Nodes.Node;
import Nodes.Skin.SkinProperty.BackgroundProperty;
import UIControls.ButtonColorPicker;
import javafx.scene.control.ColorPicker;

public class BackGroundColorChanger extends CustomizeType {

    private ButtonColorPicker buttonColorPicker;

    public BackGroundColorChanger(Preview preview) {

        super(preview);

    }

    @Override
    protected void init() {

        this.buttonColorPicker = new ButtonColorPicker();

        super.getChildren().add(this.buttonColorPicker);
    }

    @Override
    public void customizeNode(Node node) {

        node.getSkin().getSkinProperty(BackgroundProperty.class).changeColor(this.buttonColorPicker.getColorPicker().getValue());
    }

    protected ColorPicker getColorPicker() {
        return this.buttonColorPicker.getColorPicker();
    }
}

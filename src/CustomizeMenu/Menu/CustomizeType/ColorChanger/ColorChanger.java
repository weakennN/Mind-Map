package CustomizeMenu.Menu.CustomizeType.ColorChanger;

import CustomizeMenu.Menu.CustomizeType.CustomizeType;
import CustomizeMenu.Preview.Preview;
import UIControls.ButtonColorPicker;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public abstract class ColorChanger extends CustomizeType {

    private ButtonColorPicker buttonColorPicker;

    public ColorChanger(Preview preview) {

        super(preview);
        this.init();
        this.initActions();
    }

    protected abstract void initActions();

    @Override
    protected void init() {

        this.buttonColorPicker = new ButtonColorPicker();

        super.getChildren().add(this.buttonColorPicker);
    }

    protected ColorPicker getColorPicker() {
        return this.buttonColorPicker.getColorPicker();
    }

    @Override
    public void setPreview(Preview preview) {

        super.setPreview(preview);
        this.buttonColorPicker.getCircle().setFill(Color.TRANSPARENT);
    }
}

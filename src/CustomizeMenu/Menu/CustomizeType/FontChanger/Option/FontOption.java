package CustomizeMenu.Menu.CustomizeType.FontChanger.Option;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Menu.Action.SliderAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Preview.Preview;
import javafx.scene.text.Font;

public abstract class FontOption extends Option {

    private Font font;

    public FontOption(Preview preview, Action action) {
        super(preview, action);

        ((SliderAction) super.getAction()).setOption(this);
        super.getAction().initAction();
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return this.font;
    }
}

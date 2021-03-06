package CustomizeMenu.Menu.CustomizeType.FontChanger.Option;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Menu.Action.SliderAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Preview.Preview;

public abstract class FontOption extends Option {

    private String font;

    public FontOption(Preview preview, Action action) {
        super(preview, action);

        ((SliderAction) super.getAction()).setOption(this);
        super.getAction().initAction();
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getFont() {
        return this.font;
    }
}

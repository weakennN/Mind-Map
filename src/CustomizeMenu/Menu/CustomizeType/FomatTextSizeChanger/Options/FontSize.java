package CustomizeMenu.Menu.CustomizeType.FomatTextSizeChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Menu.Action.SliderAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Preview.Preview;

public abstract class FontSize extends Option {

    private double fontSize;

    public FontSize(Preview preview, Action action) {
        super(preview, action);

        ((SliderAction) super.getAction()).setOption(this);
        super.getAction().initAction();
    }

    public double getFontSize() {
        return this.fontSize;
    }

    public void setFontSize(double fontSize) {
        this.fontSize = fontSize;
    }
}

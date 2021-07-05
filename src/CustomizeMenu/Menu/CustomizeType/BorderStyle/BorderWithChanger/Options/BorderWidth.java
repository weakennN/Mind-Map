package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Menu.Action.SliderAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderWidths;

public abstract class BorderWidth extends Option {

    private BorderWidths borderWidths;

    public BorderWidth(Preview preview, Action action) {
        super(preview, action);

        ((SliderAction) super.getAction()).setOption(this);
        super.getAction().initAction();
    }

    protected void setBorderWidths(BorderWidths borderWidths) {
        this.borderWidths = borderWidths;
    }

    public BorderWidths getBorderWidths() {
        return this.borderWidths;
    }

    public void setBorderWidths(double width) {
        this.borderWidths = new BorderWidths(width);
    }
}

package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Menu.Action.BorderAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderWidths;

public abstract class BorderWidth extends Option {

    private BorderWidths borderWidths;
    private Action action;

    public BorderWidth(Preview preview, Action action) {
        super(preview);

        this.action = action;
        ((BorderAction) this.action).setOption(this);
        this.action.initAction();
    }

    protected void setBorderWidths(BorderWidths borderWidths) {
        this.borderWidths = borderWidths;
    }

    public BorderWidths getBorderWidths() {
        return this.borderWidths;
    }
}

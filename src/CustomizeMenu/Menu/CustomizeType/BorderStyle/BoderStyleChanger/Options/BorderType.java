package CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Menu.Action.BorderTypeAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.CornerRadii;

public abstract class BorderType extends Option {

    private CornerRadii cornerRadii;
    private Action action;

    public BorderType(Preview preview, Action action) {
        super(preview);
        this.action = action;
        ((BorderTypeAction) this.action).setBorderType(this);
        this.action.initAction();
    }

    public CornerRadii getCornerRadii() {
        return cornerRadii;
    }

    public void setCornerRadii(CornerRadii cornerRadii) {
        this.cornerRadii = cornerRadii;
    }
}

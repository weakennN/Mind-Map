package CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Menu.Action.BorderTypeAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.BorderStyleChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderStyleOption;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.CornerRadii;

public abstract class BorderType extends BorderStyleOption {

    private CornerRadii cornerRadii;
    private Action action;

    public BorderType(Preview preview, BorderStyleChanger borderChanger, Action action) {
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

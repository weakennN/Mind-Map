package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.BorderStyleChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.BorderType;

public abstract class BorderTypeAction extends BorderAction {

    private BorderType borderType;

    public BorderTypeAction(BorderStyleChanger borderStyleChanger) {
        super(borderStyleChanger);

    }

    protected BorderType getBorderType() {
        return this.borderType;
    }

    public void setBorderType(BorderType borderType) {
        this.borderType = borderType;
    }
}

package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.BorderType;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;

public abstract class  BorderTypeAction extends BorderAction {

    private BorderType borderType;

    public BorderTypeAction(SliderChanger borderStyleChanger) {
        super(borderStyleChanger);

    }

    protected BorderType getBorderType() {
        return this.borderType;
    }

    public void setBorderType(BorderType borderType) {
        this.borderType = borderType;
    }
}

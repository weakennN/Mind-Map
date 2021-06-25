package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.BorderStyleChanger;

public abstract class BorderAction extends Action {

    private BorderStyleChanger borderStyleChanger;

    public BorderAction(BorderStyleChanger borderStyleChanger) {
        this.borderStyleChanger = borderStyleChanger;
    }

    protected BorderStyleChanger getBorderStyleChanger() {
        return this.borderStyleChanger;
    }
}

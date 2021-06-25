package RightClickMenu.MenuItems;

import Core.MindMap;
import CustomizeMenu.Window.CustomizeMenuWindow;

public abstract class BaseFormatMenu extends BaseMenuItem {

    private CustomizeMenuWindow window;

    public BaseFormatMenu(MindMap mindMap, CustomizeMenuWindow window) {
        super(mindMap);
        this.window = window;
    }

    protected CustomizeMenuWindow getWindow() {
        return this.window;
    }
}

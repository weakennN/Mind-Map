package RightClickMenu.MenuItems;

import Core.MindMap;
import javafx.scene.control.MenuItem;

public abstract class BaseMenuItem extends MenuItem {

    private MindMap mindMap;

    public BaseMenuItem(MindMap mindMap) {

        this.mindMap = mindMap;
        super.setId("base-menu-item");
        this.setAction();
    }

    public abstract void setAction();

    protected MindMap getMindMap() {
        return this.mindMap;
    }
}

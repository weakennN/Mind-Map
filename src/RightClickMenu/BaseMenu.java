package RightClickMenu;

import Core.MindMap;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class BaseMenu extends ContextMenu {

    private MindMap mindMap;

    public BaseMenu(MindMap mindMap) {

        this.mindMap = mindMap;
    }

    public void addItem(MenuItem menuItem) {

        super.getItems().add(menuItem);
    }

    protected MindMap getMindMap() {
        return this.mindMap;
    }
}

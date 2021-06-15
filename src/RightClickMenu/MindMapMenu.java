package RightClickMenu;

import Core.MindMap;
import RightClickMenu.MenuItems.AddTopic;

public class MindMapMenu extends BaseMenu {

    public MindMapMenu(MindMap mindMap) {
        super(mindMap);

        super.addItem(new AddTopic(super.getMindMap()));
    }
}

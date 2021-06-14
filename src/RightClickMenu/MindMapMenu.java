package RightClickMenu;

import Core.MindMap;
import RightClickMenu.MenuItems.AddNode;

public class MindMapMenu extends BaseMenu{

    public MindMapMenu(MindMap mindMap) {
        super(mindMap);

        super.addItem(new AddNode(super.getMindMap()));
    }
}

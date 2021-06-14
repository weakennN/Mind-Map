package RightClickMenu;

import Core.MindMap;
import RightClickMenu.MenuItems.AddBranch;

public class NodeMenu extends BaseMenu {

    public NodeMenu(MindMap mindMap) {
        super(mindMap);

        super.addItem(new AddBranch(super.getMindMap()));
    }
}

package RightClickMenu;

import Core.MindMap;
import RightClickMenu.MenuItems.AddBranch;
import RightClickMenu.MenuItems.FormatBoundaryMenu;
import RightClickMenu.MenuItems.RemoveNode;

public class NodeMenu extends BaseMenu {

    public NodeMenu(MindMap mindMap) {
        super(mindMap);

        super.addItem(new AddBranch(super.getMindMap()));
        super.addItem(new RemoveNode(super.getMindMap()));
        super.addItem(new FormatBoundaryMenu(super.getMindMap()));
    }
}

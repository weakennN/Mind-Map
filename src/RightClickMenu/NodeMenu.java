package RightClickMenu;

import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Menu.NodeBoundaryMenu;
import CustomizeMenu.Window.CustomizeMenuWindow;
import RightClickMenu.MenuItems.AddBranch;
import RightClickMenu.MenuItems.Customize;
import RightClickMenu.MenuItems.RemoveNode;

public class NodeMenu extends BaseMenu {

    public NodeMenu(MindMap mindMap) {
        super(mindMap);

        super.addItem(new AddBranch(super.getMindMap()));
        super.addItem(new RemoveNode(super.getMindMap()));
        super.addItem(new Customize(super.getMindMap()));
    }
}

package RightClickMenu;

import Core.MindMap;
import CustomizeMenu.Menu.NodeBoundaryMenu;
import CustomizeMenu.Menu.NodeContentMenu;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.ContentPreview;
import CustomizeMenu.Window.CustomizeMenuWindow;
import RightClickMenu.MenuItems.AddBranch;
import RightClickMenu.MenuItems.FormatBoundaryMenu;
import RightClickMenu.MenuItems.FormatContentMenu;
import RightClickMenu.MenuItems.RemoveNode;

public class NodeMenu extends BaseMenu {

    public NodeMenu(MindMap mindMap) {
        super(mindMap);

        super.addItem(new AddBranch(super.getMindMap()));
        super.addItem(new RemoveNode(super.getMindMap()));
        super.addItem(new FormatBoundaryMenu(super.getMindMap(), new CustomizeMenuWindow(new NodeBoundaryMenu(new BoundaryPreview(), null, null))));
        super.addItem(new FormatContentMenu(super.getMindMap(), new CustomizeMenuWindow(new NodeContentMenu(new ContentPreview(), null, null))));
    }
}

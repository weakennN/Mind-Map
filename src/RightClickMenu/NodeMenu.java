package RightClickMenu;

import Common.GlobalVariables;
import Core.MindMap;
import CustomizeMenu.Menu.NodeBoundaryMenu;
import CustomizeMenu.Menu.NodeContentMenu;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.ContentPreview;
import CustomizeMenu.Window.CustomizeMenuWindow;
import RightClickMenu.MenuItems.AddBranch;
import RightClickMenu.MenuItems.BoundaryMenu;
import RightClickMenu.MenuItems.FormatMenu;
import RightClickMenu.MenuItems.RemoveNode;

public class NodeMenu extends BaseMenu {

    public NodeMenu(MindMap mindMap) {
        super(mindMap);

        super.addItem(new AddBranch(super.getMindMap()));
        super.addItem(new RemoveNode(super.getMindMap()));
        super.addItem(new BoundaryMenu(super.getMindMap(), new CustomizeMenuWindow(new NodeBoundaryMenu(new BoundaryPreview()
                , null, null), GlobalVariables.BOUNDARY_MENU_WIDTH, GlobalVariables.BOUNDARY_MENU_HEIGHT)));
        super.addItem(new FormatMenu(super.getMindMap(), new CustomizeMenuWindow(new NodeContentMenu(new ContentPreview()
                , null, null), GlobalVariables.FORMAT_MENU_WIDTH, GlobalVariables.FORMAT_MENU_HEIGHT)));
    }
}

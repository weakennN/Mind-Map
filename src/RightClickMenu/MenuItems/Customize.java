package RightClickMenu.MenuItems;

import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Menu.NodeBoundaryMenu;
import CustomizeMenu.Window.CustomizeMenuWindow;
import NodeCreator.NodePreviewManager.NodePreviewManager;
import Nodes.Node;

public class Customize extends BaseMenuItem {

    public Customize(MindMap mindMap) {

        super(mindMap);
        super.setText("Customize");

    }

    @Override
    public void setAction() {

        super.setOnAction(e -> {

            Node node = NodeClicked.node;
            CustomizeMenuWindow window = new CustomizeMenuWindow(new NodeBoundaryMenu((NodePreviewManager.previews.get(node)),node));
            window.show();
        });
    }
}

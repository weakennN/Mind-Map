package RightClickMenu.MenuItems;

import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Menu.NodeBoundaryMenu;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Window.CustomizeMenuWindow;
import NodeCreator.NodePreviewManager.NodePreviewManager;
import Nodes.Node;

public class Customize extends BaseMenuItem {

    private CustomizeMenuWindow window;

    public Customize(MindMap mindMap) {

        super(mindMap);
        super.setText("Customize");
        this.window = new CustomizeMenuWindow(new NodeBoundaryMenu(new BoundaryPreview(), null, null));
    }

    @Override
    public void setAction() {

        super.setOnAction(e -> {

            Node node = NodeClicked.node;
            this.window.getMenu().setCopy(NodePreviewManager.previews.get(node).copy());
            this.window.getMenu().setNode(node);
            this.window.getMenu().setOriginal(NodePreviewManager.previews.get(node));
            this.window.show();
        });
    }
}

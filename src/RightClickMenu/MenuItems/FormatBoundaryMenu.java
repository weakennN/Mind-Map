package RightClickMenu.MenuItems;

import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Window.CustomizeMenuWindow;
import Nodes.Node;

public class FormatBoundaryMenu extends BaseFormatMenu {

    public FormatBoundaryMenu(MindMap mindMap, CustomizeMenuWindow window) {

        super(mindMap, window);
        super.setText("Boundary menu");
    }


    @Override
    public void setAction() {

        super.setOnAction(e -> {

            Node node = NodeClicked.node;
            super.getWindow().getMenu().setCopy(node.getSkin().getPreview(BoundaryPreview.class).copy());
            super.getWindow().getMenu().setNode(node);
            super.getWindow().getMenu().setOriginal(node.getSkin().getPreview(BoundaryPreview.class));
            super.getWindow().show();
        });
    }
}

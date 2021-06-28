package RightClickMenu.MenuItems;

import Common.GlobalVariables;
import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Window.CustomizeMenuWindow;
import Nodes.Node;

public class BoundaryMenu extends BaseFormatMenu {

    public BoundaryMenu(MindMap mindMap, CustomizeMenuWindow window) {

        super(mindMap, window);
        super.setText("Boundary menu");
    }


    @Override
    public void setAction() {

        super.setOnAction(e -> {

            Node node = NodeClicked.node;
            super.getWindow().getMenu().setCopy(node.getSkin().getPreview(GlobalVariables.BOUNDARY_PREVIEW_TAG).copy());
            super.getWindow().getMenu().setNode(node);
            super.getWindow().getMenu().setOriginal(node.getSkin().getPreview(GlobalVariables.BOUNDARY_PREVIEW_TAG));
            super.getWindow().show();
        });
    }
}

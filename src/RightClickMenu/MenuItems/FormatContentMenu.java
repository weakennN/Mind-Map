package RightClickMenu.MenuItems;

import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Preview.ContentPreview;
import CustomizeMenu.Window.CustomizeMenuWindow;
import Nodes.Node;

public class FormatContentMenu extends BaseFormatMenu {

    public FormatContentMenu(MindMap mindMap, CustomizeMenuWindow window) {
        super(mindMap, window);
        super.setText("Format menu");
    }

    @Override
    public void setAction() {

        super.setOnAction(e -> {

            Node node = NodeClicked.node;
            super.getWindow().getMenu().setCopy(node.getSkin().getPreview(ContentPreview.class).copy());
            super.getWindow().getMenu().setNode(node);
            super.getWindow().getMenu().setOriginal(node.getSkin().getPreview(ContentPreview.class));
            super.getWindow().show();
        });
    }
}

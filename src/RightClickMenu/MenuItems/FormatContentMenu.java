package RightClickMenu.MenuItems;

import Common.GlobalVariables;
import Common.NodeClicked;
import Core.MindMap;
import CustomizeMenu.Window.CustomizeMenuWindow;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;
import javafx.scene.text.Font;

public class FormatContentMenu extends BaseFormatMenu {

    public FormatContentMenu(MindMap mindMap, CustomizeMenuWindow window) {
        super(mindMap, window);
        super.setText("Format menu");
    }

    @Override
    public void setAction() {

        super.setOnAction(e -> {

            Node node = NodeClicked.node;
            super.getWindow().getMenu().setCopy(node.getSkin().getPreview(GlobalVariables.FORMAT_PREVIEW_TAG).copy());
            super.getWindow().getMenu().setNode(node);
            super.getWindow().getMenu().setOriginal(node.getSkin().getPreview(GlobalVariables.FORMAT_PREVIEW_TAG));
            super.getWindow().show();
        });
    }
}

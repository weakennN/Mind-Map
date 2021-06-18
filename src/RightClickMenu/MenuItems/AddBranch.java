package RightClickMenu.MenuItems;

import Common.GlobalVariables;
import Common.NodeClicked;
import Core.MindMap;
import NodeCreator.NodeFactory;

public class AddBranch extends BaseMenuItem {

    public AddBranch(MindMap mindMap) {

        super(mindMap);
        super.setText("Add Branch");
    }

    @Override
    public void setAction() {

        super.setOnAction(e -> {
            super.getMindMap().addNode(NodeFactory.createNode(GlobalVariables.BRANCH_CREATOR, NodeClicked.node, super.getMindMap()));
        });

    }
}

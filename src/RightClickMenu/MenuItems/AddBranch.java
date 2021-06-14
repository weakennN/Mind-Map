package RightClickMenu.MenuItems;

import Common.NodeClicked;
import Core.MindMap;
import NodeCreator.NodeFactory;

public class AddBranch extends BaseMenuItem {

    public AddBranch(MindMap mindMap) {

        super(mindMap);
        super.setText("Add Branch");
        this.setAction();
    }

    @Override
    public void setAction() {

        super.setOnAction(e -> {

            super.getMindMap().addNode(NodeFactory.createNode("Branch Node", NodeClicked.node, super.getMindMap()));
        });

    }
}

package RightClickMenu.MenuItems;

import Core.MindMap;
import NodeCreator.NodeFactory;

public class AddNode extends BaseMenuItem {

    public AddNode(MindMap mindMap) {

        super(mindMap);
        super.setText("Add node");
        this.setAction();
    }

    @Override
    public void setAction() {

        super.setOnAction(e -> {

            super.getMindMap().addNode(NodeFactory.createNode("Topic Node", null, super.getMindMap()));
        });

    }

}

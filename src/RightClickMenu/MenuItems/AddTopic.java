package RightClickMenu.MenuItems;

import Core.MindMap;
import NodeCreator.NodeFactory;

public class AddTopic extends BaseMenuItem {

    public AddTopic(MindMap mindMap) {

        super(mindMap);
        super.setText("Add topic");
        this.setAction();
    }

    @Override
    public void setAction() {

        super.setOnAction(e -> {

            super.getMindMap().addNode(NodeFactory.createNode("Topic Node", null, super.getMindMap()));
        });

    }

}

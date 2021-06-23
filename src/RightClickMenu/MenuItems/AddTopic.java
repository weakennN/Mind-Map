package RightClickMenu.MenuItems;

import Common.GlobalVariables;
import Core.MindMap;
import NodeCreator.NodeFactory;

public class AddTopic extends BaseMenuItem {

    public AddTopic(MindMap mindMap) {

        super(mindMap);
        super.setText("Add topic");
    }

    @Override
    public void setAction() {

        super.setOnAction(e -> {
            super.getMindMap().addNode(NodeFactory.createNode(GlobalVariables.TOPIC_CREATOR, null, super.getMindMap()));
        });
    }
}

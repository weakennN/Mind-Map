package RightClickMenu.MenuItems;

import Common.NodeClicked;
import Core.MindMap;
import Nodes.Connection;

import java.util.List;

public class RemoveNode extends BaseMenuItem {

    public RemoveNode(MindMap mindMap) {

        super(mindMap);
        super.setText("Delete");
    }

    @Override
    public void setAction() {

        super.setOnAction(e -> {

            List<Connection> connections = NodeClicked.node.getConnections();

            while (!connections.isEmpty()) {

                Connection connection = connections.get(0);
                connection.parent().removeConnection(connection);
                connection.getConnected().removeConnection(connection);
                super.getMindMap().getChildren().remove(connection);
                connections.remove(connection);
            }

            super.getMindMap().removeNode(NodeClicked.node);
            NodeClicked.node = null;
        });
    }
}

package NodeCreator;

import Core.MindMap;
import Nodes.Node;
import UI.UI;

import java.util.HashMap;
import java.util.Map;

public class NodeFactory {

    // TODO: remove the pos var form createNode method and add the class in NodeCreator for creating connection

    private static UI ui;
    private static Map<String, NodeCreator> nodeCreators = new HashMap<>();

    public static void init(UI ui_) {

        ui = ui_;
        nodeCreators.put("Topic Node", new TopicNodeCreator(ui));
        nodeCreators.put("Branch Node", new BranchNodeCreator(ui));
    }

    public static Node createNode(String nodeCreator, Node parent, MindMap mindMap) {
        return nodeCreators.get(nodeCreator).createNode(parent, mindMap);
    }
}

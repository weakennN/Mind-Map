package NodeCreator.NodePreviewManager;

import CustomizeMenu.Preview.Preview;
import Nodes.Node;

import java.util.HashMap;
import java.util.Map;

public class NodePreviewManager {

    public static Map<Node, Preview> previews = new HashMap<>();

    public static void addPreview(Node node, Preview preview) {
        previews.put(node, preview);
    }
}

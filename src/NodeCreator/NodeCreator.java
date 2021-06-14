package NodeCreator;

import Core.MindMap;
import Nodes.Node;
import UI.UI;

public abstract class NodeCreator {

    private UI ui;
    private NodeConnector connector;

    public NodeCreator(UI ui) {

        this.ui = ui;
        this.connector = new NodeConnector();
    }

    public abstract Node createNode(Node parent, MindMap mindMap);

    public UI getUi() {
        return this.ui;
    }

    protected NodeConnector getConnector() {
        return this.connector;
    }
}

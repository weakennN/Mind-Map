import Common.GlobalVariables;

public class TopicNode extends Node {

    private String title;

    public TopicNode(String id, Node parent) {

        super(id, parent, GlobalVariables.DEFAULT_TOPIC_NODE_WIDTH, GlobalVariables.DEFAULT_TOPIC_NODE_HEIGHT);
        this.title = GlobalVariables.DEFAULT_TOPIC_TEXT;
    }

    @Override
    public void show() {

    }

    public void setTitle(String title) {
        this.title = title;
    }
}

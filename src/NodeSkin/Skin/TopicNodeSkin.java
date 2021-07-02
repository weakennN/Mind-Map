package NodeSkin.Skin;

import Nodes.Node;
import NodeSkin.SkinProperty.BackgroundProperty;
import NodeSkin.SkinProperty.BorderProperty;
import NodeSkin.SkinProperty.TopicNodeContentProperty;

public class TopicNodeSkin extends Skin {

    public TopicNodeSkin() {

    }

    public TopicNodeSkin(Node node) {
        super(node);
        super.addSkinProperty(new BackgroundProperty(node));
        super.addSkinProperty(new BorderProperty(node));
        super.addSkinProperty(new TopicNodeContentProperty(node));
    }
}

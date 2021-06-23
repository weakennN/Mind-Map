package Nodes.Skin;

import Nodes.Node;
import Nodes.Skin.SkinProperty.BackgroundProperty;
import Nodes.Skin.SkinProperty.BorderProperty;
import Nodes.Skin.SkinProperty.TopicNodeContentProperty;

public class TopicNodeSkin extends Skin {

    public TopicNodeSkin(Node node) {
        super(node);
        super.addSkinProperty(new BackgroundProperty(node));
        super.addSkinProperty(new BorderProperty(node));
        super.addSkinProperty(new TopicNodeContentProperty(node));
    }
}

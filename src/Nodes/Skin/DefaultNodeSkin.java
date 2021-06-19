package Nodes.Skin;

import Nodes.Node;
import Nodes.Skin.SkinProperty.BackgroundProperty;
import Nodes.Skin.SkinProperty.BorderProperty;

public class DefaultNodeSkin extends Skin {

    public DefaultNodeSkin(Node node) {
        super(node);
        super.addSkinProperty(new BackgroundProperty(node));
        super.addSkinProperty(new BorderProperty(node));
    }
}

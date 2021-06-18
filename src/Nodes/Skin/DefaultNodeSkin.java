package Nodes.Skin;

import Nodes.Node;
import Nodes.Skin.SkinProperty.BackgroundProperty;

public class DefaultNodeSkin extends Skin {

    public DefaultNodeSkin(Node node) {
        super(node);
        super.addSkinProperty(new BackgroundProperty(node));
    }

}

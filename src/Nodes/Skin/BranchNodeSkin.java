package Nodes.Skin;

import Nodes.Node;
import Nodes.Skin.SkinProperty.BackgroundProperty;
import Nodes.Skin.SkinProperty.BorderProperty;
import Nodes.Skin.SkinProperty.BranchNodeContentProperty;

public class BranchNodeSkin extends Skin {

    public BranchNodeSkin(Node node) {
        super(node);
        super.addSkinProperty(new BackgroundProperty(node));
        super.addSkinProperty(new BorderProperty(node));
        super.addSkinProperty(new BranchNodeContentProperty(node));
    }
}

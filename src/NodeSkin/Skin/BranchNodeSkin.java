package NodeSkin.Skin;

import Nodes.Node;
import NodeSkin.SkinProperty.BackgroundProperty;
import NodeSkin.SkinProperty.BorderProperty;
import NodeSkin.SkinProperty.BranchNodeContentProperty;

public class BranchNodeSkin extends Skin {

    public BranchNodeSkin(){

    }

    public BranchNodeSkin(Node node) {
        super(node);
        super.addSkinProperty(new BackgroundProperty(node));
        super.addSkinProperty(new BorderProperty(node));
        super.addSkinProperty(new BranchNodeContentProperty(node));
    }
}

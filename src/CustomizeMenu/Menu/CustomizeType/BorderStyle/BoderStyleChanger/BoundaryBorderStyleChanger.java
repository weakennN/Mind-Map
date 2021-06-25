package CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger;

import CustomizeMenu.Menu.Action.BoundaryBorderTypeAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.BorderType;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.DefaultBorder;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.RoundBorder;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.BorderProperty;
import Nodes.Node;

public class BoundaryBorderStyleChanger extends BorderStyleChanger {

    public BoundaryBorderStyleChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        DefaultBorder defaultBorder = new DefaultBorder(super.getPreview(), this, new BoundaryBorderTypeAction(this));
        RoundBorder roundBorder = new RoundBorder(super.getPreview(), this, new BoundaryBorderTypeAction(this));
        super.getSlider().addItem(defaultBorder);
        super.getSlider().addItem(roundBorder);

        super.addStyleOptions(defaultBorder, roundBorder);
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(BorderProperty.class).changeBorderStyle(((BorderType) super.getClicked()).getCornerRadii());
    }
}

package CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger;

import CustomizeMenu.Menu.Action.FormatBorderTypeAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.BorderType;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.DefaultBorder;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.RoundBorder;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;

public class FormatBorderStyleChanger extends BorderStyleChanger {

    public FormatBorderStyleChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        DefaultBorder defaultBorder = new DefaultBorder(super.getPreview(), this, new FormatBorderTypeAction(this));
        RoundBorder roundBorder = new RoundBorder(super.getPreview(), this, new FormatBorderTypeAction(this));
        super.getSlider().addItem(defaultBorder);
        super.getSlider().addItem(roundBorder);

        super.addStyleOptions(defaultBorder, roundBorder);
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).changeBorder(((BorderType) super.getClicked()).getCornerRadii());
    }
}

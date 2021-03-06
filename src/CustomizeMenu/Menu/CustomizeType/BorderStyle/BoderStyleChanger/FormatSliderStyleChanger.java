package CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger;

import CustomizeMenu.Menu.Action.FormatSliderTypeAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.BorderType;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.DefaultBorder;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.RoundBorder;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;

public class FormatSliderStyleChanger extends SliderChanger {

    public FormatSliderStyleChanger(Preview preview) {
        super(preview);
        this.init();
    }

    @Override
    protected void init() {
        super.init();

        DefaultBorder defaultBorder = new DefaultBorder(super.getPreview(), new FormatSliderTypeAction(this));
        RoundBorder roundBorder = new RoundBorder(super.getPreview(), new FormatSliderTypeAction(this));
        super.getSlider().addItem(defaultBorder);
        super.getSlider().addItem(roundBorder);

        super.addStyleOptions(defaultBorder, roundBorder);
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).changeBorder(((BorderType) super.getClicked()).getCornerRadii());
    }
}

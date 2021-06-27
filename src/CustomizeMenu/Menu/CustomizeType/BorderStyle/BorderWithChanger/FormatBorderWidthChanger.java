package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger;

import CustomizeMenu.Menu.Action.FormatBorderWidthAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options.*;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;

public class FormatBorderWidthChanger extends SliderChanger {

    public FormatBorderWidthChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        None none = new None(super.getPreview(), new FormatBorderWidthAction(this));
        Small small = new Small(super.getPreview(), new FormatBorderWidthAction(this));
        Medium medium = new Medium(super.getPreview(), new FormatBorderWidthAction(this));
        Large large = new Large(super.getPreview(), new FormatBorderWidthAction(this));

        super.getSlider().addItem(none);
        super.getSlider().addItem(small);
        super.getSlider().addItem(medium);
        super.getSlider().addItem(large);

        super.addStyleOptions(none, small, medium, large);
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).changeBorder(((BorderWidth) super.getClicked()).getBorderWidths());
    }
}

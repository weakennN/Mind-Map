package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger;

import CustomizeMenu.Menu.Action.BorderWidthAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options.*;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.BorderProperty;
import Nodes.Node;

public class BoundarySliderWidthChanger extends SliderChanger {

    public BoundarySliderWidthChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        None none = new None(super.getPreview(), new BorderWidthAction(this));
        Small small = new Small(super.getPreview(), new BorderWidthAction(this));
        Medium medium = new Medium(super.getPreview(), new BorderWidthAction(this));
        Large large = new Large(super.getPreview(), new BorderWidthAction(this));

        super.getSlider().addItem(none);
        super.getSlider().addItem(small);
        super.getSlider().addItem(medium);
        super.getSlider().addItem(large);

        super.addStyleOptions(none, small, medium, large);
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(BorderProperty.class).changeBorderStyle(((BorderWidth) super.getClicked()).getBorderWidths());
    }
}

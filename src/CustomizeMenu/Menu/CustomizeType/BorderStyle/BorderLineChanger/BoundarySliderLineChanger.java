package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger;

import CustomizeMenu.Menu.Action.BoundaryBorderLineAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.BorderLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.DottedLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.SolidLine;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.BorderProperty;
import Nodes.Node;

public class BoundarySliderLineChanger extends SliderChanger {

    public BoundarySliderLineChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        SolidLine solidLine = new SolidLine(super.getPreview(), new BoundaryBorderLineAction(this));
        DottedLine dottedLine = new DottedLine(super.getPreview(), new BoundaryBorderLineAction(this));
        super.getSlider().addItem(solidLine);
        super.getSlider().addItem(dottedLine);

        super.addStyleOptions(solidLine, dottedLine);
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(BorderProperty.class).changeBorderStyle(((BorderLine) super.getClicked()).getStrokeStyle());
    }
}

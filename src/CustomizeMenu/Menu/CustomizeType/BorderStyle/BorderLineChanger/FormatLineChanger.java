package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger;

import CustomizeMenu.Menu.Action.FormatLineAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.BorderLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.DottedLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.SolidLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;

public class FormatLineChanger extends SliderChanger {

    public FormatLineChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        SolidLine solidLine = new SolidLine(super.getPreview(), new FormatLineAction(this));
        DottedLine dottedLine = new DottedLine(super.getPreview(), new FormatLineAction(this));

        super.getSlider().addItem(solidLine);
        super.getSlider().addItem(dottedLine);

        super.addStyleOptions(solidLine, dottedLine);
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).changeBorder(((BorderLine) super.getClicked()).getStrokeStyle());
    }
}

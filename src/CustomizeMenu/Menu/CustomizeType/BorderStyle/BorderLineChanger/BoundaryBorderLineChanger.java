package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.BorderLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.DottedLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.SolidLine;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.BorderProperty;
import Nodes.Node;

public class BoundaryBorderLineChanger extends BorderLineChanger {

    public BoundaryBorderLineChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        SolidLine solidLine = new SolidLine(super.getPreview(), this);
        DottedLine dottedLine = new DottedLine(super.getPreview(), this);
        super.getSlider().addItem(solidLine);
        super.getSlider().addItem(dottedLine);

        super.addStyleOptions(solidLine, dottedLine);
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(BorderProperty.class).changeBorderStyle(((BorderLine) super.getClicked()).getStrokeStyle());
    }
}

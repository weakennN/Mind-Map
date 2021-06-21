package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.BorderLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.DottedLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.SolidLine;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import Nodes.Skin.SkinProperty.BorderProperty;

public class BorderLineChanger extends BorderChanger {

    public BorderLineChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {

        super.init();
        super.getSlider().addItem(new SolidLine(super.getPreview(), this));
        super.getSlider().addItem(new DottedLine(super.getPreview(), this));
    }

    @Override
    public void customizeNode(Node node) {

        node.getSkin().getSkinProperty(BorderProperty.class).changeBorderStyle(((BorderLine) super.getClicked()).getStrokeStyle());
    }
}

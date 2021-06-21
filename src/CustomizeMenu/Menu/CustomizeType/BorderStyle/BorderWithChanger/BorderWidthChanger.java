package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options.*;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import Nodes.Skin.SkinProperty.BorderProperty;

public class BorderWidthChanger extends BorderChanger {

    public BorderWidthChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        super.getSlider().addItem(new None(super.getPreview(), this));
        super.getSlider().addItem(new Small(super.getPreview(), this));
        super.getSlider().addItem(new Medium(super.getPreview(), this));
        super.getSlider().addItem(new Large(super.getPreview(), this));
    }

    @Override
    public void customizeNode(Node node) {

        node.getSkin().getSkinProperty(BorderProperty.class).changeBorderStyle(((BorderWidth) super.getClicked()).getBorderWidths());
    }
}

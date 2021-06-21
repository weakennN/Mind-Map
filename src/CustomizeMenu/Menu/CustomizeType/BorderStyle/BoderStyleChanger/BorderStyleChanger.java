package CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.BorderType;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.DefaultBorder;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.RoundBorder;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import Nodes.Skin.SkinProperty.BorderProperty;

public class BorderStyleChanger extends BorderChanger {

    public BorderStyleChanger(Preview preview) {

        super(preview);
    }

    @Override
    protected void init() {

        super.init();
        super.getSlider().addItem(new DefaultBorder(super.getPreview(), this));
        super.getSlider().addItem(new RoundBorder(super.getPreview(), this));
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(BorderProperty.class).changeBorderStyle(((BorderType) super.getClicked()).getCornerRadii());
    }
}

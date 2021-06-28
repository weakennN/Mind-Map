package CustomizeMenu.Menu.CustomizeType.FontChanger;

import CustomizeMenu.Menu.Action.FormatFontAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Menu.CustomizeType.FontChanger.Option.DefaultFont;
import CustomizeMenu.Menu.CustomizeType.FontChanger.Option.FontOption;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;

public class FormatFontChanger extends SliderChanger {

    public FormatFontChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        DefaultFont defaultFont = new DefaultFont(super.getPreview(), new FormatFontAction(this));
        super.getSlider().addItem(defaultFont);
        super.addStyleOptions(defaultFont);
    }

    @Override
    public void customizeNode(Node node) {
        node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).getTextFiled().setFont(((FontOption) super.getClicked()).getFont());
    }
}

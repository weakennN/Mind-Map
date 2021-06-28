package CustomizeMenu.Menu.CustomizeType.FontChanger;

import CustomizeMenu.Menu.Action.FormatFontAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Menu.CustomizeType.FontChanger.Option.DefaultFont;
import CustomizeMenu.Menu.CustomizeType.FontChanger.Option.FontOption;
import CustomizeMenu.Menu.CustomizeType.FontChanger.Option.HelveticaFont;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class FormatFontChanger extends SliderChanger {

    public FormatFontChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        DefaultFont defaultFont = new DefaultFont(super.getPreview(), new FormatFontAction(this));
        HelveticaFont helveticaFont = new HelveticaFont(super.getPreview(), new FormatFontAction(this));

        super.getSlider().addItem(defaultFont);
        super.getSlider().addItem(helveticaFont);

        super.addStyleOptions(defaultFont, helveticaFont);
    }

    @Override
    public void customizeNode(Node node) {
        TextField textField = node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).getTextFiled();
        node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).getTextFiled().setFont(Font.font(((FontOption) super.getClicked()).getFont()
                , FontPosture.REGULAR, textField.getFont().getSize()));
    }
}

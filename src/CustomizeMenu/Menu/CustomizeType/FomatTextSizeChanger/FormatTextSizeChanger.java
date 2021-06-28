package CustomizeMenu.Menu.CustomizeType.FomatTextSizeChanger;

import CustomizeMenu.Menu.Action.FormatFontSizeAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Menu.CustomizeType.FomatTextSizeChanger.Options.DefaultFontSize;
import CustomizeMenu.Menu.CustomizeType.FomatTextSizeChanger.Options.FontSize;
import CustomizeMenu.Menu.CustomizeType.FomatTextSizeChanger.Options.LargeFontSize;
import CustomizeMenu.Menu.CustomizeType.FomatTextSizeChanger.Options.MediumFontSize;
import CustomizeMenu.Preview.Preview;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import Nodes.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class FormatTextSizeChanger extends SliderChanger {

    public FormatTextSizeChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {
        super.init();

        DefaultFontSize defaultFontSize = new DefaultFontSize(super.getPreview(), new FormatFontSizeAction(this));
        MediumFontSize mediumFontSize = new MediumFontSize(super.getPreview(), new FormatFontSizeAction(this));
        LargeFontSize largeFontSize = new LargeFontSize(super.getPreview(), new FormatFontSizeAction(this));

        super.getSlider().addItem(defaultFontSize);
        super.getSlider().addItem(mediumFontSize);
        super.getSlider().addItem(largeFontSize);

        super.addStyleOptions(defaultFontSize, mediumFontSize, largeFontSize);
    }

    @Override
    public void customizeNode(Node node) {
        TextField textField = node.getSkin().getSkinProperty(DefaultNodeContentProperty.class).getTextFiled();
        textField.setFont(Font.font(textField.getFont().getName(), FontPosture.REGULAR, ((FontSize) super.getClicked()).getFontSize()));
    }
}

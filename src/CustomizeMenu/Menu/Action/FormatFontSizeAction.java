package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Menu.CustomizeType.FomatTextSizeChanger.Options.FontSize;
import CustomizeMenu.Preview.ContentPreview;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class FormatFontSizeAction extends SliderAction {

    public FormatFontSizeAction(SliderChanger sliderChanger) {
        super(sliderChanger);
    }

    @Override
    public void initAction() {

        super.getOption().setOnAction(e -> {

            ContentPreview contentPreview = (ContentPreview) super.getOption().getPreview();
            TextField textField = contentPreview.getTextField();
            textField.setFont(Font.font(textField.getFont().getName(), FontPosture.REGULAR, ((FontSize) super.getOption()).getFontSize()));
            super.getSliderChanger().setChanged(true);
            super.getSliderChanger().setClicked(super.getOption());
        });
    }
}

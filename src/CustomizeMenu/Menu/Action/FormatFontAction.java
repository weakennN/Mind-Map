package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Menu.CustomizeType.FontChanger.Option.FontOption;
import CustomizeMenu.Preview.ContentPreview;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class FormatFontAction extends SliderAction {

    public FormatFontAction(SliderChanger sliderChanger) {
        super(sliderChanger);
    }

    @Override
    public void initAction() {

        super.getOption().setOnAction(e -> {

            ContentPreview contentPreview = (ContentPreview) super.getOption().getPreview();
            TextField textField = contentPreview.getTextField();
            textField.setFont(Font.font(((FontOption) super.getOption()).getFont(), FontPosture.REGULAR, textField.getFont().getSize()));

            super.getSliderChanger().setClicked(super.getOption());
            super.getSliderChanger().setChanged(true);
        });
    }
}

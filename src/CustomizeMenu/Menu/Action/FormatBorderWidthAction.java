package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options.BorderWidth;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Preview.ContentPreview;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;

public class FormatBorderWidthAction extends BorderAction {

    public FormatBorderWidthAction(SliderChanger sliderChanger) {
        super(sliderChanger);
    }

    @Override
    public void initAction() {

        super.getOption().setOnAction(e -> {

            ContentPreview preview = (ContentPreview) super.getOption().getPreview();
            TextField textField = preview.getTextField();
            BorderStroke borderStroke = textField.getBorder().getStrokes().get(0);
            textField.setBorder(new Border(new BorderStroke(borderStroke.getBottomStroke(), borderStroke.getLeftStyle(),
                    borderStroke.getRadii(), ((BorderWidth) super.getOption()).getBorderWidths())));
            super.getSliderChanger().setClicked(super.getOption());
            super.getSliderChanger().setChanged(true);
        });
    }
}

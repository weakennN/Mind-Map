package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.BorderLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Preview.ContentPreview;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;

public class FormatLineAction extends SliderAction {

    public FormatLineAction(SliderChanger sliderChanger) {
        super(sliderChanger);
    }

    @Override
    public void initAction() {

        super.getOption().setOnAction(e -> {

            ContentPreview preview = (ContentPreview) super.getOption().getPreview();
            TextField textField = preview.getTextField();
            BorderStroke borderStroke = textField.getBorder().getStrokes().get(0);
            textField.setBorder(new Border(new BorderStroke(borderStroke.getBottomStroke(), ((BorderLine) super.getOption()).getStrokeStyle()
                    , borderStroke.getRadii(), borderStroke.getWidths())));
            super.getSliderChanger().setChanged(true);
            super.getSliderChanger().setClicked(super.getOption());
        });
    }
}

package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.BorderType;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Preview.ContentPreview;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;

public class FormatSliderTypeAction extends SliderAction {

    public FormatSliderTypeAction(SliderChanger borderStyleChanger) {
        super(borderStyleChanger);
    }

    @Override
    public void initAction() {

        super.getOption().setOnAction(e -> {

            ContentPreview preview = (ContentPreview) super.getOption().getPreview();
            TextField textField = preview.getTextField();
            BorderStroke borderStroke = textField.getBorder().getStrokes().get(0);
            BackgroundFill backgroundFill = textField.getBackground().getFills().get(0);
            textField.setBorder(new Border(new BorderStroke(borderStroke.getBottomStroke(), borderStroke.getLeftStyle(),
                    ((BorderType) super.getOption()).getCornerRadii(), borderStroke.getWidths())));
            textField.setBackground(new Background(new BackgroundFill(backgroundFill.getFill(), ((BorderType) super.getOption()).getCornerRadii(), backgroundFill.getInsets())));
            super.getSliderChanger().setClicked(super.getOption());
            super.getSliderChanger().setChanged(true);
        });
    }
}

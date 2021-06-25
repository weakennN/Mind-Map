package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.BorderStyleChanger;
import CustomizeMenu.Preview.ContentPreview;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;

public class FormatBorderTypeAction extends BorderTypeAction {

    public FormatBorderTypeAction(BorderStyleChanger borderStyleChanger) {
        super(borderStyleChanger);
    }

    @Override
    public void initAction() {

        super.getBorderType().setOnAction(e -> {

            ContentPreview preview = (ContentPreview) super.getBorderType().getPreview();
            TextField textField = preview.getTextField();
            BorderStroke borderStroke = textField.getBorder().getStrokes().get(0);
            BackgroundFill backgroundFill = textField.getBackground().getFills().get(0);
            textField.setBorder(new Border(new BorderStroke(borderStroke.getBottomStroke(), borderStroke.getLeftStyle(), super.getBorderType().getCornerRadii(), borderStroke.getWidths())));
            textField.setBackground(new Background(new BackgroundFill(backgroundFill.getFill(), super.getBorderType().getCornerRadii(), backgroundFill.getInsets())));
            super.getBorderStyleChanger().setClicked(super.getBorderType());
            super.getBorderStyleChanger().setChanged(true);
        });
    }
}

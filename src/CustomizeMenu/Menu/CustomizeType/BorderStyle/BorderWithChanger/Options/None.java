package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.BorderWidthChanger;
import CustomizeMenu.Preview.Preview;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderWidths;
import javafx.scene.text.TextAlignment;

public class None extends BorderWidth{

    public None(Preview preview, BorderWidthChanger borderWidthChanger) {
        super(preview, borderWidthChanger);
    }

    @Override
    protected void init() {

        super.setBorderWidths(new BorderWidths(0));

        Label label = new Label("None");
        label.setTextAlignment(TextAlignment.CENTER);

        super.setGraphic(label);
    }
}

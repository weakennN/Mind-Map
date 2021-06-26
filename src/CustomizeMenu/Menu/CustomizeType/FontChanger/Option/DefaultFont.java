package CustomizeMenu.Menu.CustomizeType.FontChanger.Option;

import CustomizeMenu.Menu.CustomizeType.FontChanger.FormatFontChanger;
import CustomizeMenu.Preview.Preview;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class DefaultFont extends FontOption {

    public DefaultFont(Preview preview, FormatFontChanger formatFontChanger) {
        super(preview, formatFontChanger);
    }

    @Override
    protected void init() {

        super.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));

        Text text = new Text("Default");
        text.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
        super.setGraphic(text);
    }
}

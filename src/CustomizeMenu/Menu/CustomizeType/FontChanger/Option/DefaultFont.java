package CustomizeMenu.Menu.CustomizeType.FontChanger.Option;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class DefaultFont extends FontOption {

    public DefaultFont(Preview preview, Action action) {
        super(preview, action);
    }

    @Override
    protected void init() {

        super.setFont("Verdana");

        Text text = new Text("Default");
        text.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
        super.setGraphic(text);
    }
}

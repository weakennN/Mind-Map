package CustomizeMenu.Menu.CustomizeType.FontChanger.Option;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class HelveticaFont extends FontOption {

    public HelveticaFont(Preview preview, Action action) {
        super(preview, action);
    }

    @Override
    protected void init() {

        super.setFont("Helvetica");

        Text text = new Text("Helvetica");
        text.setFont(Font.font("Helvetica", FontPosture.REGULAR, 16));

        super.setGraphic(text);
    }
}

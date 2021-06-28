package CustomizeMenu.Menu.CustomizeType.FomatTextSizeChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MediumFontSize extends FontSize {

    public MediumFontSize(Preview preview, Action action) {
        super(preview, action);
    }

    @Override
    protected void init() {

        super.setFontSize(19);

        Text text = new Text("Medium");
        text.setFont(Font.font("Arial", 16));

        super.setGraphic(text);
    }
}

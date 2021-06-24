package CustomizeMenu.Preview;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

public class ContentPreview extends Preview {

    @Override
    public void init() {

        Text text = new Text("Example text");
        text.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));


    }

    @Override
    public Preview copy() {
        return null;
    }
}

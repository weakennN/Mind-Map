package UIControls;

import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class MenuButton extends Button {

    public MenuButton() {

        super.setTextAlignment(TextAlignment.CENTER);
        super.setBorder(new Border(new BorderStroke(Color.valueOf("19a4fa"), BorderStrokeStyle.SOLID, new CornerRadii(10), BorderWidths.DEFAULT)));
        super.setBackground(new Background(new BackgroundFill(null, new CornerRadii(10), null)));
        super.setMinHeight(40);
    }

    public void setFill(Color color) {

        super.setBackground(new Background(new BackgroundFill(color, new CornerRadii(10), null)));
    }
}

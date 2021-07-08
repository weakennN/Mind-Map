package UIControls;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
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

    public void setEffect() {
        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(10);
        dropShadow.setOffsetY(3.5);
        dropShadow.setColor(Color.valueOf("54aaf0"));

        super.setOnMouseEntered(e -> {
            super.setEffect(dropShadow);
        });

        super.setOnMouseExited(e -> {
            super.setEffect(null);
        });
    }
}

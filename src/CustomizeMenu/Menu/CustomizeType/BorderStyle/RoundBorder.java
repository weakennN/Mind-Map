package CustomizeMenu.Menu.CustomizeType.BorderStyle;

import CustomizeMenu.Preview;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class RoundBorder extends BorderType {

    public RoundBorder(Preview preview, BorderChanger borderChanger) {

        super(preview, borderChanger);
    }

    @Override
    protected void init() {
        super.setCornerRadii(new CornerRadii(20));

        Rectangle rectangle = new Rectangle(0, 0, 68, 30);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        rectangle.setArcWidth(10);
        rectangle.setArcHeight(10);

        super.setGraphic(rectangle);
    }
}

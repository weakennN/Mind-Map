package CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DefaultBorder extends BorderType {

    public DefaultBorder(Preview preview, Action action) {
        super(preview,action);
    }

    @Override
    protected void init() {

        super.setCornerRadii(new CornerRadii(0));

        Rectangle rectangle = new Rectangle(0, 0, 68, 30);
        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);

        super.setGraphic(rectangle);
    }
}

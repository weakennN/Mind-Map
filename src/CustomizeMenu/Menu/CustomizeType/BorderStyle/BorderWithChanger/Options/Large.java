package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Large extends BorderWidth {

    public Large(Preview preview, Action action) {
        super(preview, action);
    }

    @Override
    protected void init() {

        super.setBorderWidths(new BorderWidths(3));

        Line line = new Line(0, 0, 64, 0);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(3);

        super.setGraphic(line);
    }
}

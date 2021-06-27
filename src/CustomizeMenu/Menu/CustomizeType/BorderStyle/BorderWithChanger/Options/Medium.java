package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Medium extends BorderWidth{

    public Medium(Preview preview, Action action) {
        super(preview, action);
    }

    @Override
    protected void init() {

        super.setBorderWidths(new BorderWidths(2.3));

        Line line = new Line(0, 0, 64, 0);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(2.3);

        super.setGraphic(line);
    }
}

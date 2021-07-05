package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.List;

public class DottedLine extends BorderLine {

    public DottedLine(Preview preview, Action action) {
        super(preview, action);
    }

    @Override
    protected void init() {

        super.setStrokeStyle(BorderStrokeStyle.DOTTED);
        super.setDashLine(List.of(2.0));

        Line line = new Line(0, 0, 64, 0);
        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        line.getStrokeDashArray().addAll(4.0);

        super.setGraphic(line);
    }
}

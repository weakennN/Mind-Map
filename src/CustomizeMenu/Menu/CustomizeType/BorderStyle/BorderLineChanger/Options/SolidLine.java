package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.List;

public class SolidLine extends BorderLine {

    public SolidLine(Preview preview, Action action) {

        super(preview, action);
    }

    @Override
    protected void init() {

        super.setStrokeStyle(BorderStrokeStyle.SOLID);
        super.setDashLine(List.of(0.0));

        Line line = new Line(0, 0, 65, 0);
        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        line.getStrokeDashArray().addAll(super.getStrokeStyle().getDashArray());

        super.setGraphic(line);
    }
}

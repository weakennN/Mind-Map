package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.BorderLineChanger;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class SolidLine extends BorderLine {

    public SolidLine(Preview preview, BorderLineChanger borderLineChanger) {

        super(preview, borderLineChanger);
    }

    @Override
    protected void init() {

        super.setStrokeStyle(BorderStrokeStyle.SOLID);
        super.setDashLine(super.getStrokeStyle().getDashArray());

        Line line = new Line(0, 0, 65, 0);
        line.setStroke(Color.BLACK);
        line.getStrokeDashArray().addAll(super.getStrokeStyle().getDashArray());

        super.setGraphic(line);
    }
}

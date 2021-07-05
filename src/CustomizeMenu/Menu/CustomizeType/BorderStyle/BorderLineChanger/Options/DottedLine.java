package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

import java.util.List;

public class DottedLine extends BorderLine {

    public DottedLine(Preview preview, Action action) {
        super(preview, action);
    }

    @Override
    protected void init() {

         super.setStrokeStyle(BorderStrokeStyle.DOTTED);

      //  BorderStrokeStyle borderStrokeStyle = new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.MITER, StrokeLineCap.ROUND, 10.0D, 0.0D, List.of(0.0, 2.0));

        super.setDashLine(List.of(2.0));
       // super.setStrokeStyle(borderStrokeStyle);

        Line line = new Line(0, 0, 64, 0);
        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        line.getStrokeDashArray().addAll(4.0);

        super.setGraphic(line);
    }
}

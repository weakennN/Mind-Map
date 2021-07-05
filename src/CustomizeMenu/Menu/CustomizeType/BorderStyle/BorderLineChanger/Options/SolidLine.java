package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

import java.util.ArrayList;
import java.util.List;

public class SolidLine extends BorderLine {

    public SolidLine(Preview preview, Action action) {

        super(preview, action);
    }

    @Override
    protected void init() {

        super.setStrokeStyle(BorderStrokeStyle.SOLID);
        //  BorderStrokeStyle borderStrokeStyle = new BorderStrokeStyle(StrokeType.INSIDE, StrokeLineJoin.MITER, StrokeLineCap.BUTT, 10.0D, 0.0D, null);

        //  super.setStrokeStyle(borderStrokeStyle);
        super.setDashLine(List.of(0.0));

        Line line = new Line(0, 0, 65, 0);
        line.setStrokeWidth(2);
        line.setStroke(Color.BLACK);
        line.getStrokeDashArray().addAll(super.getStrokeStyle().getDashArray());

        super.setGraphic(line);
    }
}

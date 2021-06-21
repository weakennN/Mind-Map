package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.BorderWidthChanger;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Medium extends BorderWidth{

    public Medium(Preview preview, BorderWidthChanger borderWidthChanger) {
        super(preview, borderWidthChanger);
    }

    @Override
    protected void init() {

        super.setBorderWidths(new BorderWidths(2.3));

        Line line = new Line(0, 0, 64, 0);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(2);

        super.setGraphic(line);
    }
}

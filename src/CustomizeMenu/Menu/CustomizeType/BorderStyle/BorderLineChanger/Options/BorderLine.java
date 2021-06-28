package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Menu.Action.SliderAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderStrokeStyle;

import java.util.List;

public abstract class BorderLine extends Option {

    private BorderStrokeStyle strokeStyle;
    private List<Double> dashLine;

    public BorderLine(Preview preview, Action action) {

        super(preview, action);
        ((SliderAction) super.getAction()).setOption(this);
        super.getAction().initAction();
    }

    public void setStrokeStyle(BorderStrokeStyle strokeStyle) {
        this.strokeStyle = strokeStyle;
    }

    public BorderStrokeStyle getStrokeStyle() {
        return this.strokeStyle;
    }

    public void setDashLine(List<Double> dashLine) {
        this.dashLine = dashLine;
    }

    public List<Double> getDashLine() {
        return this.dashLine;
    }
}

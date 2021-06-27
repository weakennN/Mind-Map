package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Menu.Action.BorderAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderStrokeStyle;

import java.util.List;

public abstract class BorderLine extends Option {

    private BorderStrokeStyle strokeStyle;
    private List<Double> dashLine;
    private Action action;

    public BorderLine(Preview preview, Action action) {

        super(preview);
        this.action = action;
        ((BorderAction)this.action).setOption(this);
        this.action.initAction();
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

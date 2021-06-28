package CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Menu.Action.SliderAction;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.CornerRadii;

public abstract class BorderType extends Option {

    private CornerRadii cornerRadii;

    public BorderType(Preview preview, Action action) {
        super(preview, action);
        ((SliderAction) super.getAction()).setOption(this);
        super.getAction().initAction();
    }

    public CornerRadii getCornerRadii() {
        return cornerRadii;
    }

    public void setCornerRadii(CornerRadii cornerRadii) {
        this.cornerRadii = cornerRadii;
    }
}

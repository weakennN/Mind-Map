package CustomizeMenu.Menu.CustomizeType.BorderStyle;

import CustomizeMenu.Menu.Action.Action;
import CustomizeMenu.Preview.Preview;
import javafx.scene.control.MenuItem;

public abstract class Option extends MenuItem {

    private Preview preview;
    private Action action;

    public Option(Preview preview, Action action) {

        this.preview = preview;
        this.action = action;
        this.init();
    }

    protected abstract void init();

    public Preview getPreview() {
        return this.preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public Action getAction() {
        return this.action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}

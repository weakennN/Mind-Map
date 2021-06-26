package CustomizeMenu.Menu.CustomizeType.BorderStyle;

import CustomizeMenu.Preview.Preview;
import javafx.scene.control.MenuItem;

public abstract class Option extends MenuItem {

    private Preview preview;

    public Option(Preview preview) {

        this.preview = preview;
        this.init();
    }

    protected abstract void init();

    public Preview getPreview() {
        return this.preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }
}

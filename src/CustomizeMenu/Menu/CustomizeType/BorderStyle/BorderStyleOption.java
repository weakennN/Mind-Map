package CustomizeMenu.Menu.CustomizeType.BorderStyle;

import CustomizeMenu.Preview.Preview;
import javafx.scene.control.MenuItem;

public abstract class BorderStyleOption extends MenuItem {

    private Preview preview;

    public BorderStyleOption(Preview preview) {

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

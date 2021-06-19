package CustomizeMenu.Menu.CustomizeType;

import CustomizeMenu.Preview;
import Nodes.Node;
import javafx.scene.layout.Region;

public abstract class CustomizeType extends Region {

    private Preview preview;
    private boolean changed;

    public CustomizeType(Preview preview) {

        this.preview = preview;
        this.init();
    }

    protected abstract void init();

    public abstract void customizeNode(Node node);

    public Preview getPreview() {
        return this.preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public boolean isChanged() {
        return this.changed;
    }

    public void setChanged(boolean b) {
        this.changed = b;
    }
}

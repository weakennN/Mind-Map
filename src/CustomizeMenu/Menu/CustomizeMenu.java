package CustomizeMenu.Menu;

import CustomizeMenu.Menu.CustomizeType.CustomizeType;
import CustomizeMenu.Preview.Preview;
import CustomizeMenu.Window.CustomizeMenuWindow;
import Nodes.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomizeMenu extends Pane {

    private List<CustomizeType> customizeTypes;
    private Preview preview;
    private Node node;
    private CustomizeMenuWindow window;

    public CustomizeMenu(Preview preview, Node node) {

        this.customizeTypes = new ArrayList<>();
        this.preview = preview;
        this.node = node;
    }

    protected void customizeNode() {

        for (CustomizeType customizeType : this.customizeTypes) {

            if (customizeType.isChanged()) {
                customizeType.setChanged(false);
                customizeType.customizeNode(this.node);
            }
        }
    }

    public void addCustomizeType(CustomizeType customizeType) {
        this.customizeTypes.add(customizeType);
    }

    public List<CustomizeType> getCustomizeTypes() {
        return this.customizeTypes;
    }

    public Node getNode() {
        return this.node;
    }

    public void setWindow(CustomizeMenuWindow window) {
        this.window = window;
    }

    public CustomizeMenuWindow getWindow() {
        return this.window;
    }
}

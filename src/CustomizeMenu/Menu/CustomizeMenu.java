package CustomizeMenu.Menu;

import CustomizeMenu.Menu.CustomizeType.CustomizeType;
import CustomizeMenu.Preview.Preview;
import CustomizeMenu.Window.CustomizeMenuWindow;
import NodeCreator.NodePreviewManager.NodePreviewManager;
import Nodes.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomizeMenu extends Pane {

    private List<CustomizeType> customizeTypes;
    private Preview copy;
    private Preview original;
    private Node node;
    private CustomizeMenuWindow window;

    public CustomizeMenu(Preview copy, Preview original, Node node) {

        this.customizeTypes = new ArrayList<>();
        this.copy = copy;
        this.original = original;
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

    public void setCopy(Preview copy) {
        this.copy = copy;

        for (CustomizeType customizeType : customizeTypes) {
            customizeType.setPreview(copy);
        }
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public Preview getCopy() {
        return this.copy;
    }

    public void setOriginal(Preview original) {
        this.original = original;
    }

    public Preview getOriginal() {
        return this.original;
    }
}

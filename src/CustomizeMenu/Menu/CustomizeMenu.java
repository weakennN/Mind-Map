package CustomizeMenu.Menu;

import CustomizeMenu.Menu.CustomizeType.CustomizeType;
import CustomizeMenu.Preview;
import Nodes.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomizeMenu extends Pane {

    private List<CustomizeType> customizeTypes;
    private Preview preview;
    private Node node;

    public CustomizeMenu(Preview preview, Node node) {

        this.customizeTypes = new ArrayList<>();
        this.preview = preview;
        this.node = node;
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
}

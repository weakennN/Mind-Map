package Core;

import Nodes.Node;
import RightClickMenu.BaseMenu;
import RightClickMenu.MindMapMenu;
import RightClickMenu.NodeMenu;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MindMap extends Pane {

    private List<Node> nodes;
    private Map<String, BaseMenu> menus;

    public MindMap() {

        this.nodes = new ArrayList<>();
        this.initMenus();
        super.setMinSize(1920, 1080);
        super.setCursor(Cursor.CROSSHAIR);
    }

    public void addNode(Node node) {

        super.getChildren().add(node);
        this.nodes.add(node);
    }

    private void initMenus() {

        this.menus = new HashMap<>();

        this.menus.put("MindMapMenu", new MindMapMenu(this));
        this.menus.put("NodeMenu", new NodeMenu(this));

        super.setOnMouseClicked(e -> {

            if (e.getButton() == MouseButton.SECONDARY) {
                this.menus.get("MindMapMenu").show(this, e.getSceneX(), e.getSceneY());
            }
        });
    }

    public BaseMenu getMenu(String menu) {
        return this.menus.get(menu);
    }
}

package Core;

import Camera.Camera;
import Common.GlobalVariables;
import Common.NodeClicked;
import Nodes.Node;
import RightClickMenu.BaseMenu;
import RightClickMenu.MindMapMenu;
import RightClickMenu.NodeMenu;
import javafx.scene.Cursor;
import javafx.scene.SubScene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
        super.setCursor(Cursor.CROSSHAIR);
        super.setMinSize(1920, 1080);
        BackgroundFill myBF = new BackgroundFill(Color.valueOf("fffff0"), null,
                null);
        super.setBackground(new Background(myBF));
        super.getStylesheets().add("Style/RightClickMenu.css");
    }

    public void addNode(Node node) {

        super.getChildren().add(node);
        this.nodes.add(node);
    }

    private void initMenus() {

        this.menus = new HashMap<>();

        this.menus.put(GlobalVariables.MIND_MAP_MENU, new MindMapMenu(this));
        this.menus.put(GlobalVariables.NODE_MENU, new NodeMenu(this));

        super.setOnMouseClicked(e -> {

            if (e.getButton() == MouseButton.SECONDARY && NodeClicked.node == null) {
                this.menus.get(GlobalVariables.MIND_MAP_MENU).show(this, e.getSceneX(), e.getSceneY());
            } else if (e.getButton() == MouseButton.PRIMARY) {

                NodeClicked.node = null;
                super.requestFocus();
            }
        });
    }

    public BaseMenu getMenu(String menu) {
        return this.menus.get(menu);
    }

    public void removeNode(Node node) {
        this.nodes.remove(node);
        super.getChildren().remove(node);
    }

    public List<Node> getNodes() {
        return this.nodes;
    }
}

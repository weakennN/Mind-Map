package Core;

import Camera.Camera;
import Common.NodeClicked;
import Nodes.Node;
import RightClickMenu.BaseMenu;
import RightClickMenu.MindMapMenu;
import RightClickMenu.NodeMenu;
import com.sun.glass.ui.Screen;
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
    private Camera camera;

    public MindMap() {

        this.nodes = new ArrayList<>();
        this.initMenus();
        super.setMinSize(Screen.getMainScreen().getWidth(), Screen.getMainScreen().getHeight());
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

            if (e.getButton() == MouseButton.SECONDARY && NodeClicked.node == null) {
                this.menus.get("MindMapMenu").show(this, e.getSceneX(), e.getSceneY());
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

    public void createSubScene() {

        this.camera = new Camera(this);
        SubScene subScene = new SubScene(this, 1600, 900);
        subScene.setViewOrder(5);
        subScene.setFill(Color.AQUA);
        subScene.setCamera(this.camera);
        super.getChildren().add(subScene);

        super.setOnMouseDragged(e -> {

            this.camera.translate(e.getSceneX(), e.getSceneY());
        });

    }
}

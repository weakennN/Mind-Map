package Core;

import Common.GlobalVariables;
import Common.NodeClicked;
import Nodes.Node;
import RightClickMenu.BaseMenu;
import RightClickMenu.MindMapMenu;
import RightClickMenu.NodeMenu;
import com.sun.glass.ui.Screen;
import javafx.scene.Cursor;
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
        super.setMinSize(Screen.getMainScreen().getWidth(), Screen.getMainScreen().getHeight());
        BackgroundFill myBF = new BackgroundFill(Color.valueOf("fffffa"), null,
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
                this.menus.get(GlobalVariables.MIND_MAP_MENU).show(this, e.getSceneX() - (this.menus.get(GlobalVariables.MIND_MAP_MENU).getWidth() / 2)
                        , e.getSceneY() + (this.menus.get(GlobalVariables.MIND_MAP_MENU).getHeight() / 2) + 10);
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

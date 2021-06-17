package Core;

import NodeCreator.NodeFactory;
import UI.UI;
import mikera.vectorz.Vector2;

import java.util.ArrayList;
import java.util.List;

public class App {

    private UI ui;
    private List<MindMap> mindMaps;

    public App(UI ui) {

        this.ui = ui;
        Vector2 vec = new Vector2(100, -100);
        vec.normalise();
        vec.x = Math.round(vec.x);
        vec.y = Math.round(vec.y);
        System.out.println();
        NodeFactory.init(this.ui);
        this.mindMaps = new ArrayList<>();
        this.createMindMap();
    }

    public void createMindMap() {

        this.mindMaps.add(new MindMap());
        this.ui.getRoot().getChildren().add(this.mindMaps.get(this.mindMaps.size() - 1));
    }
}

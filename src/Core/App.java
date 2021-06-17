package Core;

import NodeCreator.NodeFactory;
import UI.UI;

import java.util.ArrayList;
import java.util.List;

public class App {

    private UI ui;
    private List<MindMap> mindMaps;

    public App(UI ui) {

        this.ui = ui;
        NodeFactory.init(this.ui);
        this.mindMaps = new ArrayList<>();
    }

    public void createMindMap() {

        this.mindMaps.add(new MindMap());
        this.ui.getRoot().getChildren().add(this.mindMaps.get(this.mindMaps.size() - 1));
    }
}

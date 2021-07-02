package Core;

import Camera.Camera;
import NodeCreator.NodeFactory;
import SaveSystem.Saver;
import UI.UI;

import java.util.ArrayList;
import java.util.List;

public class App {

    private UI ui;
    private List<MindMap> mindMaps;
    private Camera camera;

    public App(UI ui) {

        this.ui = ui;
    }

    public void start() {

        NodeFactory.init(this.ui);

        this.mindMaps = new ArrayList<>();
        this.mindMaps.add(this.ui.getRoot());

        this.camera = new Camera(this.ui.getRoot(), this.ui.getScene());
        this.camera.init();

        Saver.init();
    }
}

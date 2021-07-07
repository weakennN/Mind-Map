package Core;

import Camera.Camera;
import NodeCreator.NodeFactory;
import SaveSystem.SaveSystem;
import SaveSystem.Saver;
import UI.UI;

public class App {

    private UI ui;
    private MindMap mindMap;
    private Camera camera;
    private SaveSystem saveSystem;

    public App(UI ui) {

        this.ui = ui;
        this.saveSystem = new SaveSystem(this);
    }

    public void start() {

        NodeFactory.init(this.ui);


        this.mindMap = this.ui.getRoot();

        this.camera = new Camera(this.ui.getRoot(), this.ui.getScene());
        this.camera.init();

        Saver.init();
        this.saveSystem.load();
    }

    public MindMap getMindMap() {
        return this.mindMap;
    }

    public UI getUi() {
        return this.ui;
    }
}

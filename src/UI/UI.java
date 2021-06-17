package UI;

import Camera.Camera;
import Common.NodeClicked;
import Core.MindMap;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class UI {

    private Scene scene;
    private Stage stage;
    private Pane root;

    public UI() {

        this.init();
    }

    private void init() {

        this.root = new Pane();
        MindMap mindMap = new MindMap();
        this.scene = new Scene(mindMap, 1920, 1080);
        Camera camera = new Camera(mindMap);
        camera.setNearClip(0.1);
        camera.setFarClip(2000.0);
        scene.setCamera(camera);
        this.scene.setOnMouseDragged(e -> {

            if (NodeClicked.node == null) {
                camera.translate(e.getSceneX(), e.getSceneY());
            }
        });
        this.stage = new Stage();
        this.stage.setScene(this.scene);
    }

    public Scene getScene() {
        return scene;
    }

    public Stage getStage() {
        return stage;
    }

    public Pane getRoot() {
        return root;
    }

    public void setRoot(MindMap mindMap) {
        this.root = mindMap;
    }

    // TODO refactor this class so it can have a method that init a scene and adds the main mind map as the root after it got init or parse it trough constructor put the ui in the mind map and try to put as sub scene root the main root
}

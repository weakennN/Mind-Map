package UI;

import Camera.Camera;
import Common.NodeClicked;
import Core.MindMap;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UI {

    private Scene scene;
    private Stage stage;
    private MindMap root;

    public UI() {

        this.init();
    }

    private void init() {

        this.root = new MindMap();
        this.scene = new Scene(this.root, 1920, 1080);
        Camera camera = new Camera(this.root);
        camera.setNearClip(0.1);
        camera.setFarClip(100);
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

    public MindMap getRoot() {
        return root;
    }

    public void setRoot(MindMap mindMap) {
        this.root = mindMap;
    }

}

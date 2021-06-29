package UI;

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

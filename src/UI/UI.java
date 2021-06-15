package UI;

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

        this.scene = new Scene(root, 1920, 1080);
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
}

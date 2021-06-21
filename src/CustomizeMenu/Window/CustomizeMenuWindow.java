package CustomizeMenu.Window;

import CustomizeMenu.Menu.CustomizeMenu;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomizeMenuWindow {

    private Stage stage;
    private Scene scene;
    private CustomizeMenu menu;

    public CustomizeMenuWindow(CustomizeMenu menu) {

        this.menu = menu;
        this.menu.setWindow(this);
        this.init();
    }

    private void init() {

        this.scene = new Scene(menu, 700, 400);
        this.stage = new Stage();
        this.stage.setMinWidth(600);
        this.stage.setMinHeight(400);
        this.stage.setScene(this.scene);
        this.scene.setFill(Color.RED);
        this.stage.initModality(Modality.APPLICATION_MODAL);
    }

    public void show() {
        this.stage.showAndWait();
    }

    public CustomizeMenu getMenu() {
        return this.menu;
    }

    public Stage getStage() {
        return this.stage;
    }
}

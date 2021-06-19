package CustomizeMenu.Window;

import CustomizeMenu.Menu.CustomizeMenu;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomizeMenuWindow {

    private Stage stage;
    private Scene scene;
    private CustomizeMenu menu;

    public CustomizeMenuWindow(CustomizeMenu menu) {

        this.menu = menu;
        this.init();
    }

    private void init() {

        this.scene = new Scene(menu, 500, 500);
        this.stage = new Stage();
        this.stage.setMinWidth(600);
        this.stage.setMinHeight(600);
        this.stage.setScene(this.scene);
        this.stage.initModality(Modality.APPLICATION_MODAL);
    }

    public void show() {
        this.stage.showAndWait();
    }

    public CustomizeMenu getMenu() {
        return this.menu;
    }
}

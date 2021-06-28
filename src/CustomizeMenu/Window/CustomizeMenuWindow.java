package CustomizeMenu.Window;

import CustomizeMenu.Menu.CustomizeMenu;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CustomizeMenuWindow {

    private Stage stage;
    private Scene scene;
    private CustomizeMenu menu;

    public CustomizeMenuWindow(CustomizeMenu menu, double width, double height) {

        this.menu = menu;
        this.menu.setWindow(this);
        this.init(width, height);
    }

    private void init(double width, double height) {

        this.scene = new Scene(menu, width, height);
        this.stage = new Stage();
        this.stage.setMinWidth(width);
        this.stage.setMinHeight(height);
        this.stage.setScene(this.scene);
        this.scene.setFill(Color.RED);
        this.stage.initModality(Modality.APPLICATION_MODAL);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.setX((Screen.getPrimary().getVisualBounds().getWidth() - this.stage.getMinWidth()) / 2);
        this.stage.setY((Screen.getPrimary().getVisualBounds().getHeight() - this.stage.getMinHeight()) / 2);
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

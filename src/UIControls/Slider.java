package UIControls;

import javafx.geometry.Orientation;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Slider extends Region {

    private MenuButton menuButton;

    public Slider() {
        this.menuButton = new MenuButton();
        this.menuButton.setMinSize(80, 30);
        super.getStylesheets().add("Style/Style.css");
        super.getChildren().add(this.menuButton);

    }


    public void addItem(MenuItem item) {
        this.menuButton.getItems().add(item);
    }

    public MenuButton getMenuButton() {
        return this.menuButton;
    }
}

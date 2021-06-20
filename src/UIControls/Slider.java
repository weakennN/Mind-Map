package UIControls;

import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Region;

public class Slider extends Region {

    private MenuButton menuButton;

    public Slider() {
        this.menuButton = new MenuButton();
        this.menuButton.setMinSize(80, 30);
        super.getStylesheets().add("Style/Slider.css");
        super.getChildren().add(this.menuButton);

    }


    public void addItem(MenuItem item) {
        this.menuButton.getItems().add(item);
    }

    public MenuButton getMenuButton() {
        return this.menuButton;
    }
}

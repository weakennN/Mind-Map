package CustomizeMenu.Menu.CustomizeType.BackgroundChanger;

import CustomizeMenu.Menu.CustomizeType.CustomizeType;
import CustomizeMenu.Preview;
import Nodes.Node;
import Nodes.Skin.SkinProperty.BackgroundProperty;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BackGroundColorChanger extends CustomizeType {

    private Button button;
    private ColorPicker colorPicker;
    private Label label;

    public BackGroundColorChanger(Preview preview) {

        super(preview);
    }

    @Override
    protected void init() {

        this.button = new Button();
        this.colorPicker = new ColorPicker();
        this.label = new Label("Color");
        this.colorPicker.setVisible(false);
        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(this.button, this.colorPicker, this.label);

        super.getChildren().add(vBox);
        this.button.setOnAction(e -> {

            this.colorPicker.show();
        });
    }

    @Override
    public void customizeNode(Node node) {

        node.getSkin().getSkinProperty(BackgroundProperty.class).changeColor(this.colorPicker.getValue());
    }

    protected ColorPicker getColorPicker() {
        return this.colorPicker;
    }
}

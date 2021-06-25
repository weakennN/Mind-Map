package CustomizeMenu.Menu;

import CustomizeMenu.Menu.CustomizeType.ColorChanger.FormatContentColorChanger;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import UIControls.MenuButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class NodeContentMenu extends CustomizeMenu {

    private Pane root;
    private MenuButton confirmButton;

    public NodeContentMenu(Preview copy, Preview original, Node node) {
        super(copy, original, node);

        this.init(copy);
    }

    private void init(Preview preview) {

        super.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        this.initButtons();

        preview.setLayoutY(100);
        preview.setLayoutX(150);
        this.root = new Pane();
        this.root.getChildren().add(preview);

        FormatContentColorChanger formatContentColorChanger = new FormatContentColorChanger(preview);
        super.addCustomizeType(formatContentColorChanger);

        this.root.getChildren().addAll(formatContentColorChanger,this.confirmButton);

        super.getChildren().add(this.root);
    }

    private void initButtons() {

        this.confirmButton = new MenuButton();
        this.confirmButton.setMinWidth(70);
        this.confirmButton.setTextFill(Color.WHITE);
        this.confirmButton.setFill(Color.valueOf("0795ed"));
        this.confirmButton.setText("Confirm");

        this.confirmButton.setLayoutX(200);
        this.confirmButton.setLayoutY(150);

        this.confirmButton.setOnAction(e -> {

            super.customizeNode();
            super.getWindow().getStage().close();
        });
    }

    @Override
    public void setCopy(Preview copy) {

        this.root.getChildren().remove(super.getCopy());
        this.root.getChildren().add(copy);
        copy.setLayoutX(100);
        copy.setLayoutY(150);
        super.setCopy(copy);

    }
}

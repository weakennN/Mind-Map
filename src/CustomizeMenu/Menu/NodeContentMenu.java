package CustomizeMenu.Menu;

import Common.GlobalVariables;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.FormatBorderStyleChanger;
import CustomizeMenu.Menu.CustomizeType.ColorChanger.FormatBorderColorChanger;
import CustomizeMenu.Menu.CustomizeType.ColorChanger.FormatContentColorChanger;
import CustomizeMenu.Menu.CustomizeType.ColorChanger.FormatTextColorChanger;
import CustomizeMenu.Menu.CustomizeType.FontChanger.FormatFontChanger;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import UIControls.MenuButton;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class NodeContentMenu extends CustomizeMenu {

    private Pane root;
    private MenuButton confirmButton;
    private Label backgroundLabel;
    private Label contentColorLabel;

    public NodeContentMenu(Preview copy, Preview original, Node node) {
        super(copy, original, node);

        this.init(copy);
    }

    private void init(Preview preview) {

        super.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        FormatContentColorChanger formatContentColorChanger = new FormatContentColorChanger(preview);
        super.addCustomizeType(formatContentColorChanger);

        FormatBorderColorChanger formatBorderColorChanger = new FormatBorderColorChanger(preview);
        super.addCustomizeType(formatBorderColorChanger);

        FormatBorderStyleChanger formatBorderStyleChanger = new FormatBorderStyleChanger(preview);
        super.addCustomizeType(formatBorderStyleChanger);

        FormatFontChanger formatFontChanger = new FormatFontChanger(preview);
        super.addCustomizeType(formatFontChanger);

        this.initButtons();
        this.initLabels();

        VBox formatContentColorChangerVBox = new VBox(10);
        formatContentColorChangerVBox.getChildren().addAll(formatContentColorChanger, this.contentColorLabel);

        HBox backgroundHBox = new HBox(10);

        backgroundHBox.getChildren().addAll(formatContentColorChangerVBox, formatBorderColorChanger, formatBorderStyleChanger, formatFontChanger);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(this.backgroundLabel, backgroundHBox, this.confirmButton);

        preview.setLayoutY(100);
        preview.setLayoutX(150);
        this.root = new Pane();
        this.root.getChildren().add(preview);

        this.root.getChildren().addAll(vBox);

        super.getChildren().add(this.root);
    }

    private void initLabels() {

        this.backgroundLabel = new Label("Background");
        this.contentColorLabel = new Label("Color");

        List<Label> labels = List.of(this.backgroundLabel, this.contentColorLabel);

        for (Label label : labels) {

            label.setFont(Font.font("Tahoma", 15));
            label.setTextFill(Color.GRAY);
        }
    }

    private void initButtons() {

        this.confirmButton = new MenuButton();
        this.confirmButton.setMinWidth(70);
        this.confirmButton.setTextFill(Color.WHITE);
        this.confirmButton.setFill(Color.valueOf("0795ed"));
        this.confirmButton.setText("Confirm");

        this.confirmButton.setLayoutX(200);
        this.confirmButton.setLayoutY(250);

        this.confirmButton.setOnAction(e -> {

            super.customizeNode();
            super.getWindow().getStage().close();
            super.setOriginal(super.getCopy());
            super.getNode().getSkin().replacePreview(GlobalVariables.FORMAT_PREVIEW_TAG, super.getCopy());
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

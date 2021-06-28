package CustomizeMenu.Menu;

import Common.GlobalVariables;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.FormatSliderStyleChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.FormatLineChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.FormatSliderWidthChanger;
import CustomizeMenu.Menu.CustomizeType.ColorChanger.FormatBorderColorChanger;
import CustomizeMenu.Menu.CustomizeType.ColorChanger.FormatContentColorChanger;
import CustomizeMenu.Menu.CustomizeType.FontChanger.FormatFontChanger;
import CustomizeMenu.Menu.CustomizeType.FomatTextSizeChanger.FormatTextSizeChanger;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import UIControls.MenuButton;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class NodeContentMenu extends CustomizeMenu {

    private Pane root;
    private MenuButton confirmButton;
    private MenuButton cancelButton;
    private Label backgroundLabel;
    private Label contentColorLabel;
    private Label title;
    private Label textLabel;
    private Label fontLabel;
    private Label borderLabel;
    private VBox previewVBox;
    private Label borderColorLabel;
    private Label styleLabel;
    private Label widthLabel;
    private Label lineLabel;
    private Label sizeLabel;

    public NodeContentMenu(Preview copy, Preview original, Node node) {
        super(copy, original, node);

        this.init(copy);
    }

    private void init(Preview preview) {

        super.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        super.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, BorderWidths.DEFAULT)));

        FormatContentColorChanger formatContentColorChanger = new FormatContentColorChanger(preview);
        super.addCustomizeType(formatContentColorChanger);

        FormatBorderColorChanger formatBorderColorChanger = new FormatBorderColorChanger(preview);
        super.addCustomizeType(formatBorderColorChanger);

        FormatSliderStyleChanger formatBorderStyleChanger = new FormatSliderStyleChanger(preview);
        super.addCustomizeType(formatBorderStyleChanger);

        FormatFontChanger formatFontChanger = new FormatFontChanger(preview);
        super.addCustomizeType(formatFontChanger);

        FormatSliderWidthChanger formatBorderWidthChanger = new FormatSliderWidthChanger(preview);
        super.addCustomizeType(formatBorderWidthChanger);

        FormatTextSizeChanger formatTextSizeChanger = new FormatTextSizeChanger(preview);
        super.addCustomizeType(formatTextSizeChanger);

        FormatLineChanger formatLineChanger = new FormatLineChanger(preview);
        super.addCustomizeType(formatLineChanger);

        this.initButtons();
        this.initLabels();

        HBox firstRow = new HBox(30);
        HBox secondRow = new HBox(30);
        HBox thirdRow = new HBox(30);

        firstRow.setPadding(new Insets(0, 0, 0, 25));

        this.previewVBox = new VBox(10);
        this.previewVBox.getChildren().addAll(preview);
        this.previewVBox.setPadding(new Insets(0, 0, 0, 25));

        VBox formatFontChangerVBox = new VBox(10);
        formatFontChangerVBox.getChildren().addAll(formatFontChanger, this.fontLabel);

        VBox formatContentColorChangerVBox = new VBox(10);
        formatContentColorChangerVBox.setPadding(new Insets(0, 0, 0, 25));
        formatContentColorChangerVBox.getChildren().addAll(formatContentColorChanger, this.contentColorLabel);

        VBox formatBorderColorChangerVBox = new VBox(10);
        formatBorderColorChangerVBox.getChildren().addAll(formatBorderColorChanger, this.borderColorLabel);
        formatBorderColorChangerVBox.setPadding(new Insets(0, 0, 0, 25));

        VBox formatBorderStyleChangerVBox = new VBox(10);
        firstRow.setPadding(new Insets(0, 0, 0, 25));
        formatBorderStyleChangerVBox.getChildren().addAll(formatBorderStyleChanger, this.styleLabel);

        VBox formatBorderWidthChangerVBox = new VBox(10);
        formatBorderWidthChangerVBox.getChildren().addAll(formatBorderWidthChanger, this.widthLabel);

        VBox formatTextSizeChangerVBox = new VBox(10);
        formatTextSizeChangerVBox.getChildren().addAll(formatTextSizeChanger, this.sizeLabel);

        VBox formatLineChangerVBox = new VBox(10);
        formatLineChangerVBox.getChildren().addAll(formatLineChanger, this.lineLabel);

        firstRow.getChildren().addAll(formatFontChangerVBox, formatTextSizeChangerVBox);
        secondRow.getChildren().addAll(formatContentColorChangerVBox);
        thirdRow.getChildren().addAll(formatBorderColorChangerVBox, formatBorderStyleChangerVBox, formatBorderWidthChangerVBox, formatLineChangerVBox);

        VBox vBox = new VBox(20);
        vBox.getChildren().addAll(this.title, this.previewVBox, this.textLabel, firstRow, this.backgroundLabel
                , secondRow, this.borderLabel, thirdRow);

        this.root = new Pane();

        this.root.getChildren().addAll(vBox, this.confirmButton, this.cancelButton);

        super.getChildren().add(this.root);
    }

    private void initLabels() {

        this.backgroundLabel = new Label("Background");
        this.contentColorLabel = new Label("Color");
        this.textLabel = new Label("Text");
        this.fontLabel = new Label("Font");
        this.title = new Label("Format Topic");
        this.borderLabel = new Label("Border");
        this.borderColorLabel = new Label("Color");
        this.styleLabel = new Label("Style");
        this.widthLabel = new Label("Width");
        this.lineLabel = new Label("Line");
        this.sizeLabel = new Label("Size");

        List<Label> labels = List.of(this.backgroundLabel, this.textLabel, this.fontLabel, this.borderLabel
                , this.contentColorLabel, this.borderColorLabel, this.styleLabel, this.widthLabel, this.lineLabel, this.sizeLabel);

        for (Label label : labels) {

            label.setFont(Font.font("Tahoma", 16));
            label.setTextFill(Color.GRAY);
            label.setPadding(new Insets(0, 0, 0, 25));
        }

        this.contentColorLabel.setPadding(new Insets(0, 0, 0, 5));
        this.borderColorLabel.setPadding(new Insets(0, 0, 0, 5));

        this.title.setPadding(new Insets(30, 0, 0, 25));
        this.title.setFont(Font.font("Tahoma", 22));

    }

    private void initButtons() {


        this.confirmButton = new MenuButton();
        this.cancelButton = new MenuButton();

        List<Button> buttons = List.of(this.confirmButton, this.cancelButton);

        for (Button button : buttons) {

            button.setFont(Font.font("Arial", 16));
            button.setMinWidth(70);
        }

        this.confirmButton.setTextFill(Color.WHITE);
        this.confirmButton.setFill(Color.valueOf("0795ed"));
        this.confirmButton.setText("Confirm");

        this.confirmButton.setLayoutX(600);
        this.confirmButton.setLayoutY(690);

        this.cancelButton.setLayoutX(510);
        this.cancelButton.setLayoutY(690);
        this.cancelButton.setText("Cancel");
        this.cancelButton.setTextFill(Color.valueOf("0795ed"));

        this.confirmButton.setOnAction(e -> {

            super.customizeNode();
            super.getWindow().getStage().close();
            super.setOriginal(super.getCopy());
            super.getNode().getSkin().replacePreview(GlobalVariables.FORMAT_PREVIEW_TAG, super.getCopy());
        });

        this.cancelButton.setOnAction(e -> {

            super.getWindow().getStage().close();
        });
    }

    @Override
    public void setCopy(Preview copy) {

        this.previewVBox.getChildren().remove(super.getCopy());
        this.previewVBox.getChildren().add(copy);
        super.setCopy(copy);
    }
}

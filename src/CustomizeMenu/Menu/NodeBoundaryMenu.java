package CustomizeMenu.Menu;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.BorderStyleChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.BorderLineChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.BorderWidthChanger;
import CustomizeMenu.Menu.CustomizeType.ColorChanger.BoundaryChanger;
import CustomizeMenu.Menu.CustomizeType.ColorChanger.BoundaryBorderChanger;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class NodeBoundaryMenu extends CustomizeMenu {

    private VBox vBox;
    private Pane root;
    private Button confirmButton;
    private Label titleLabel;
    private Label shapeLabel;
    private Label styleLabel;
    private Label colorLabel;
    private Label label;
    private Label lineLabel;
    private Label borderLabel;
    private Label widthLabel;

    public NodeBoundaryMenu(Preview preview, Node node) {
        super(preview, node);

        this.initStyle(preview);
        this.confirmButton.setOnAction(e -> {

            super.customizeNode();
            super.getWindow().getStage().close();
        });

    }

    private void initStyle(Preview preview) {

        super.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        BoundaryChanger backGroundColorChanger = new BoundaryChanger(preview);
        super.addCustomizeType(backGroundColorChanger);

        BorderStyleChanger borderChanger = new BorderStyleChanger(preview);
        super.addCustomizeType(borderChanger);

        BoundaryBorderChanger boundaryBorderChanger = new BoundaryBorderChanger(preview);
        super.addCustomizeType(boundaryBorderChanger);

        BorderLineChanger borderLineChanger = new BorderLineChanger(preview);
        super.addCustomizeType(borderLineChanger);

        BorderWidthChanger borderWidthChanger = new BorderWidthChanger(preview);
        super.addCustomizeType(borderWidthChanger);

        this.initLabels();

        this.confirmButton = new Button("Confirm");

        VBox borderChangerVBox = new VBox(10);
        borderChangerVBox.setPadding(new Insets(0, 0, 0, 25));
        borderChangerVBox.getChildren().addAll(this.shapeLabel, borderChanger, this.styleLabel);

        VBox backgroundColorChangerVbox = new VBox(10);
        backgroundColorChangerVbox.setPadding(new Insets(20, 0, 0, 0));
        backgroundColorChangerVbox.getChildren().addAll(backGroundColorChanger, this.label);

        VBox borderLineChangerVbox = new VBox(10);
        borderLineChangerVbox.setPadding(new Insets(0, 0, 0, 20));
        borderLineChangerVbox.getChildren().addAll(borderLineChanger, this.lineLabel);

        VBox borderWidthChangerVbox = new VBox(10);
        borderWidthChangerVbox.setPadding(new Insets(28, 0, 0, 0));
        borderWidthChangerVbox.getChildren().addAll(borderWidthChanger, this.widthLabel);

        VBox borderColorChangerVBox = new VBox(10);
        borderColorChangerVBox.getChildren().addAll(boundaryBorderChanger, this.colorLabel);

        HBox firstRowHBox = new HBox(35);
        firstRowHBox.getChildren().addAll(borderChangerVBox, backgroundColorChangerVbox, borderWidthChangerVbox);

        HBox secondRowHBox = new HBox(35);
        secondRowHBox.getChildren().addAll(borderLineChangerVbox, borderColorChangerVBox);

        this.vBox = new VBox(20);
        this.vBox.getChildren().addAll(titleLabel, firstRowHBox, this.borderLabel, secondRowHBox, this.confirmButton);

        this.root = new Pane();
        preview.setLayoutX(400);
        preview.setLayoutY(150);
        this.root.getChildren().addAll(this.vBox,preview);

        super.getChildren().addAll(this.root);
    }

    private void initLabels() {

        this.titleLabel = new Label("Format Boundary");
        this.shapeLabel = new Label("Shape");
        this.styleLabel = new Label("Style");
        this.colorLabel = new Label("Color");
        this.lineLabel = new Label("Line");
        this.borderLabel = new Label("Border");
        this.widthLabel = new Label("Width");
        this.label = new Label("Color");

        List<Label> labels = List.of(this.colorLabel, this.styleLabel, this.shapeLabel, this.lineLabel, this.borderLabel, this.widthLabel, this.label);

        for (Label label : labels) {

            label.setFont(Font.font("Tahoma", 15));
            label.setTextFill(Color.GRAY);
        }

        this.colorLabel.setPadding(new Insets(0, 0, 0, 5));

        this.titleLabel.setPadding(new Insets(30, 0, 0, 25));
        this.titleLabel.setFont(Font.font("Tahoma", 25));

        this.styleLabel.setPadding(new Insets(0, 0, 0, 25));

        this.borderLabel.setPadding(new Insets(0, 0, 0, 25));

        this.widthLabel.setPadding(new Insets(0, 0, 0, 23));

        this.lineLabel.setPadding(new Insets(0, 0, 0, 25));

        this.label.setPadding(new Insets(0, 0, 0, 5));
    }
}

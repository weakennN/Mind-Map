package CustomizeMenu.Menu;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.BorderStyleChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.BorderLineChanger;
import CustomizeMenu.Menu.CustomizeType.ColorChanger.BoundaryChanger;
import CustomizeMenu.Menu.CustomizeType.ColorChanger.BoundaryBorderChanger;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class NodeBoundaryMenu extends CustomizeMenu {

    private VBox vBox;
    private Button confirmButton;
    private Label titleLabel;
    private Label shapeLabel;
    private Label styleLabel;
    private Label colorLabel;

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

        this.initLabels();

        this.confirmButton = new Button("Confirm");

        VBox borderChangerVBox = new VBox(10);
        borderChangerVBox.setPadding(new Insets(0, 0, 0, 25));
        borderChangerVBox.getChildren().addAll(this.shapeLabel, borderChanger, this.styleLabel);

        VBox backgroundColorChangerVbox = new VBox(10);
        backgroundColorChangerVbox.setPadding(new Insets(20, 0, 0, 0));
        backgroundColorChangerVbox.getChildren().addAll(backGroundColorChanger, this.colorLabel);

        HBox hBox = new HBox(35);
        hBox.getChildren().addAll(borderChangerVBox, backgroundColorChangerVbox,borderLineChanger);


        vBox = new VBox(20);
        vBox.getChildren().addAll(titleLabel, hBox, preview, this.confirmButton,boundaryBorderChanger);

        super.getChildren().addAll(vBox);
    }

    private void initLabels() {

        this.titleLabel = new Label("Format Boundary");
        this.shapeLabel = new Label("Shape");
        this.styleLabel = new Label("Style");
        this.colorLabel = new Label("Color");

        List<Label> labels = List.of(this.colorLabel, this.styleLabel, this.shapeLabel);

        for (Label label : labels) {

            label.setFont(Font.font("Tahoma", 15));
            label.setTextFill(Color.GRAY);
        }

        this.colorLabel.setPadding(new Insets(0, 0, 0, 5));

        this.titleLabel.setPadding(new Insets(30, 0, 0, 25));
        this.titleLabel.setFont(Font.font("Tahoma", 25));

        this.styleLabel.setPadding(new Insets(0, 0, 0, 25));
    }
}

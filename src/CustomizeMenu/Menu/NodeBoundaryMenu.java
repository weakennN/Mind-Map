package CustomizeMenu.Menu;

import CustomizeMenu.Menu.CustomizeType.BackgroundChanger.BoundaryBackGroundChanger;
import CustomizeMenu.Menu.CustomizeType.BorderChanger;
import CustomizeMenu.Menu.CustomizeType.CustomizeType;
import CustomizeMenu.Preview;
import Nodes.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.List;

public class NodeBoundaryMenu extends CustomizeMenu {

    private VBox vBox;
    private Button confirmButton;

    public NodeBoundaryMenu(Preview preview, Node node) {
        super(preview, node);

        this.initStyle(preview);
        this.confirmButton.setOnAction(e -> {

            List<CustomizeType> customizeTypes = super.getCustomizeTypes();

            for (CustomizeType customizeType : customizeTypes) {

                if (customizeType.isChanged()) {
                    customizeType.setChanged(false);
                    customizeType.customizeNode(super.getNode());
                }
            }
        });
    }

    private void initStyle(Preview preview) {

        BoundaryBackGroundChanger backGroundColorChanger = new BoundaryBackGroundChanger(preview);
        super.addCustomizeType(backGroundColorChanger);
        BorderChanger borderChanger = new BorderChanger(preview);
        super.addCustomizeType(borderChanger);
        Label titleLabel = new Label("Format Boundary");
        titleLabel.setFont(Font.font("Arial", 32));
        this.confirmButton = new Button("Confirm");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(backGroundColorChanger,borderChanger);
        vBox = new VBox(10);
        vBox.getChildren().addAll(titleLabel, hBox, preview, this.confirmButton);
        super.getChildren().addAll(vBox);
    }
}

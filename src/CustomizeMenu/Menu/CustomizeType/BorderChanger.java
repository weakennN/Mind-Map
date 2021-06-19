package CustomizeMenu.Menu.CustomizeType;

import CustomizeMenu.BoundaryPreview;
import CustomizeMenu.Preview;
import Nodes.Node;
import Nodes.Skin.SkinProperty.BorderProperty;
import javafx.scene.control.ComboBox;

public class BorderChanger extends CustomizeType {

    private ComboBox<BorderType> borderTypes;

    public BorderChanger(Preview preview) {
        super(preview);

    }

    @Override
    protected void init() {

        this.borderTypes = new ComboBox<>();
        this.borderTypes.getItems().add(new RoundBorder());

        this.borderTypes.setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) super.getPreview();
            boundaryPreview.getPolygon().setArcHeight(this.borderTypes.getSelectionModel().getSelectedItem().getCornerRadii().getBottomLeftHorizontalRadius());
            boundaryPreview.getPolygon().setArcWidth(this.borderTypes.getSelectionModel().getSelectedItem().getCornerRadii().getBottomLeftHorizontalRadius());
            super.setChanged(true);
        });

        super.getChildren().add(this.borderTypes);
    }

    @Override
    public void customizeNode(Node node) {

        node.getSkin().getSkinProperty(BorderProperty.class).changeBorderStyle(this.borderTypes.getSelectionModel().getSelectedItem().getCornerRadii());
    }
}

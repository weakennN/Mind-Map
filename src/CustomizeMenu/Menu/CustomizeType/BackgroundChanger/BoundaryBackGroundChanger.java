package CustomizeMenu.Menu.CustomizeType.BackgroundChanger;

import CustomizeMenu.BoundaryPreview;
import CustomizeMenu.Preview;

public class BoundaryBackGroundChanger extends BackGroundColorChanger {

    public BoundaryBackGroundChanger(Preview preview) {

        super(preview);
        this.initActions();
    }

    private void initActions() {

        super.getColorPicker().setOnAction(e -> {

            BoundaryPreview preview = (BoundaryPreview) super.getPreview();
            preview.getPolygon().setFill(super.getColorPicker().getValue());
            super.setChanged(true);
        });
    }
}

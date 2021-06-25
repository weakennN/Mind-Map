package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.BorderStyleChanger;
import CustomizeMenu.Preview.BoundaryPreview;


public class BoundaryBorderTypeAction extends BorderTypeAction {

    public BoundaryBorderTypeAction(BorderStyleChanger borderStyleChanger) {

        super(borderStyleChanger);
    }

    @Override
    public void initAction() {

        super.getBorderType().setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) super.getBorderType().getPreview();
            boundaryPreview.getPreview().setArcWidth(super.getBorderType().getCornerRadii().getBottomLeftHorizontalRadius());
            boundaryPreview.getPreview().setArcHeight(super.getBorderType().getCornerRadii().getBottomLeftHorizontalRadius());
            super.getBorderStyleChanger().setClicked(super.getBorderType());
            super.getBorderStyleChanger().setChanged(true);
        });
    }
}

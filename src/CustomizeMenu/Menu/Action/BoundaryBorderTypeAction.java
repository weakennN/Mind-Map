package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Preview.BoundaryPreview;


public class BoundaryBorderTypeAction extends BorderTypeAction {

    public BoundaryBorderTypeAction(SliderChanger borderStyleChanger) {

        super(borderStyleChanger);
    }

    @Override
    public void initAction() {

        super.getBorderType().setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) super.getBorderType().getPreview();
            boundaryPreview.getPreview().setArcWidth(super.getBorderType().getCornerRadii().getBottomLeftHorizontalRadius());
            boundaryPreview.getPreview().setArcHeight(super.getBorderType().getCornerRadii().getBottomLeftHorizontalRadius());
            super.getSliderChanger().setClicked(super.getBorderType());
            super.getSliderChanger().setChanged(true);
        });
    }
}

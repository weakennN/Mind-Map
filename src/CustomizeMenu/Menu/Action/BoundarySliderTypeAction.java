package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options.BorderType;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Preview.BoundaryPreview;


public class BoundarySliderTypeAction extends SliderAction {

    public BoundarySliderTypeAction(SliderChanger borderStyleChanger) {

        super(borderStyleChanger);
    }

    @Override
    public void initAction() {

        super.getOption().setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) super.getOption().getPreview();
            boundaryPreview.getPreview().setArcWidth(((BorderType) super.getOption()).getCornerRadii().getBottomLeftHorizontalRadius());
            boundaryPreview.getPreview().setArcHeight(((BorderType) super.getOption()).getCornerRadii().getBottomLeftHorizontalRadius());
            super.getSliderChanger().setClicked(super.getOption());
            super.getSliderChanger().setChanged(true);
        });
    }
}

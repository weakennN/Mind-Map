package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options.BorderWidth;
import CustomizeMenu.Preview.BoundaryPreview;

public class SliderWidthAction extends SliderAction {

    public SliderWidthAction(SliderChanger borderStyleChanger) {
        super(borderStyleChanger);
    }

    @Override
    public void initAction() {

        super.getOption().setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) super.getOption().getPreview();
            boundaryPreview.getPreview().setStrokeWidth(((BorderWidth) super.getOption()).getBorderWidths().getBottom());
            super.getSliderChanger().setChanged(true);
            super.getSliderChanger().setClicked(super.getOption());
        });
    }
}

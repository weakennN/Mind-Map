package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.BorderLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;
import CustomizeMenu.Preview.BoundaryPreview;
import javafx.scene.shape.StrokeLineCap;

public class BoundaryBorderLineAction extends BorderLineAction {

    public BoundaryBorderLineAction(SliderChanger borderStyleChanger) {
        super(borderStyleChanger);
    }

    @Override
    public void initAction() {

        super.getOption().setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) super.getOption().getPreview();
            boundaryPreview.getPreview().getStrokeDashArray().addAll(((BorderLine) super.getOption()).getDashLine());
            boundaryPreview.getPreview().setStrokeLineCap(StrokeLineCap.BUTT);

            super.getSliderChanger().setClicked(super.getOption());
            super.getSliderChanger().setChanged(true);
        });
    }
}

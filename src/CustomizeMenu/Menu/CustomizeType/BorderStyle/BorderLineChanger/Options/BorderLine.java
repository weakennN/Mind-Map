package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.BorderLineChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderStyleOption;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.shape.StrokeLineCap;

import java.util.List;

public abstract class BorderLine extends BorderStyleOption {

    private BorderStrokeStyle strokeStyle;
    private List<Double> dashLine;

    public BorderLine(Preview preview, BorderLineChanger borderLineChanger) {

        super(preview);

        this.setOnAction(borderLineChanger);
    }

    public void setOnAction(BorderLineChanger borderLineChanger) {

        super.setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) super.getPreview();

            boundaryPreview.getPreview().getStrokeDashArray().addAll(this.dashLine);
            boundaryPreview.getPreview().setStrokeLineCap(StrokeLineCap.BUTT);
            borderLineChanger.setChanged(true);
            borderLineChanger.setClicked(this);
        });
    }

    public void setStrokeStyle(BorderStrokeStyle strokeStyle) {
        this.strokeStyle = strokeStyle;
    }

    public BorderStrokeStyle getStrokeStyle() {
        return this.strokeStyle;
    }

    protected void setDashLine(List<Double> dashLine) {
        this.dashLine = dashLine;
    }
}

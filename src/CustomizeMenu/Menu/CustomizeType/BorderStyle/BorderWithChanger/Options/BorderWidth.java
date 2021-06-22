package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderStyleOption;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.BorderWidthChanger;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderWidths;

import java.util.List;

public abstract class BorderWidth extends BorderStyleOption {

    private BorderWidths borderWidths;

    public BorderWidth(Preview preview, BorderWidthChanger borderWidthChanger) {
        super(preview);

        this.setOnActions(borderWidthChanger);
    }

    private void setOnActions(BorderWidthChanger borderWidthChanger) {

        super.setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) super.getPreview();
            boundaryPreview.getPreview().setStrokeWidth(this.borderWidths.getBottom());
            List<Double> dashLines = boundaryPreview.getPreview().getStrokeDashArray();

            for (int i = 0; i < dashLines.size(); i++) {

                if (dashLines.get(i) / 2 < this.borderWidths.getBottom()) {
                    dashLines.set(i, dashLines.get(i) * 2);
                }
            }

            borderWidthChanger.setChanged(true);
            borderWidthChanger.setClicked(this);
        });
    }

    protected void setBorderWidths(BorderWidths borderWidths) {
        this.borderWidths = borderWidths;
    }

    public BorderWidths getBorderWidths() {
        return this.borderWidths;
    }
}

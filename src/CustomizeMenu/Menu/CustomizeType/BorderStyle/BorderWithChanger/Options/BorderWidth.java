package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.Options;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderWithChanger.BorderWidthChanger;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.BorderWidths;

public abstract class BorderWidth extends Option {

    private BorderWidths borderWidths;

    public BorderWidth(Preview preview, BorderWidthChanger borderWidthChanger) {
        super(preview);

        this.setOnActions(borderWidthChanger);
    }

    private void setOnActions(BorderWidthChanger borderWidthChanger) {

        super.setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) super.getPreview();
            boundaryPreview.getPreview().setStrokeWidth(this.borderWidths.getBottom());
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

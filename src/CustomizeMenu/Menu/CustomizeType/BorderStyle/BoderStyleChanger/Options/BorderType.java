package CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.Options;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BoderStyleChanger.BorderStyleChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderStyleOption;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.Preview;
import javafx.scene.layout.CornerRadii;

public abstract class BorderType extends BorderStyleOption {

    private CornerRadii cornerRadii;

    public BorderType(Preview preview, BorderStyleChanger borderChanger) {

        this.setAction(preview, borderChanger);
    }

    protected void setAction(Preview preview, BorderStyleChanger borderChanger) {

        super.setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) preview;
            boundaryPreview.getPreview().setArcWidth(this.getCornerRadii().getBottomLeftHorizontalRadius());
            boundaryPreview.getPreview().setArcHeight(this.getCornerRadii().getBottomLeftHorizontalRadius());
            borderChanger.setClicked(this);
            borderChanger.setChanged(true);
        });

    }

    public CornerRadii getCornerRadii() {
        return cornerRadii;
    }

    public void setCornerRadii(CornerRadii cornerRadii) {
        this.cornerRadii = cornerRadii;
    }
}
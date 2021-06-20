package CustomizeMenu.Menu.CustomizeType.BorderStyle;

import CustomizeMenu.BoundaryPreview;
import CustomizeMenu.Preview;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.CornerRadii;

public abstract class BorderType extends MenuItem {

    private CornerRadii cornerRadii;

    public BorderType(Preview preview, BorderChanger borderChanger) {

        this.init();
        this.setAction(preview, borderChanger);
    }

    protected abstract void init();

    protected void setAction(Preview preview, BorderChanger borderChanger) {

        super.setOnAction(e -> {

            BoundaryPreview boundaryPreview = (BoundaryPreview) preview;
            boundaryPreview.getPolygon().setArcWidth(this.getCornerRadii().getBottomLeftHorizontalRadius());
            boundaryPreview.getPolygon().setArcHeight(this.getCornerRadii().getBottomLeftHorizontalRadius());
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

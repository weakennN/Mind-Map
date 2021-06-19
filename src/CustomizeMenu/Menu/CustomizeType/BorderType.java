package CustomizeMenu.Menu.CustomizeType;

import javafx.scene.layout.CornerRadii;

public abstract class BorderType {

    private CornerRadii cornerRadii;

    public BorderType() {

    }

    public CornerRadii getCornerRadii() {
        return cornerRadii;
    }

    public void setCornerRadii(CornerRadii cornerRadii) {
        this.cornerRadii = cornerRadii;
    }
}

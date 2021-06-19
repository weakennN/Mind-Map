package CustomizeMenu;

import javafx.scene.shape.Rectangle;

public class BoundaryPreview extends Preview {

    private Rectangle shape;

    public BoundaryPreview() {

        this.init();
    }

    @Override
    public void init() {

        this.shape = new Rectangle(200,100,200,100);

        super.getChildren().addAll(shape);
    }

    public Rectangle getPolygon() {
        return this.shape;
    }

    @Override
    public BoundaryPreview clone() {
        try {
            return (BoundaryPreview) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}

package CustomizeMenu.Preview;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoundaryPreview extends Preview {

    private Rectangle shape;

    public BoundaryPreview() {

        this.init();
    }

    @Override
    public void init() {

        this.shape = new Rectangle(200, 100, 200, 100);
        this.shape.setFill(Color.TRANSPARENT);
        this.shape.setStroke(Color.BLACK);
        super.getChildren().addAll(shape);
    }

    public Rectangle getPreview() {
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

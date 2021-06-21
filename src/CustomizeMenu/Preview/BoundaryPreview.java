package CustomizeMenu.Preview;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class BoundaryPreview extends Preview {

    private Rectangle shape;

    public BoundaryPreview() {

        this.init();
    }

    @Override
    public void init() {

        this.shape = new Rectangle(0, 0, 200, 100);
        this.shape.setFill(Color.TRANSPARENT);
        this.shape.setStroke(Color.BLACK);

        Rectangle rectangle = new Rectangle();
        rectangle.setLayoutX(this.shape.getLayoutX() - 25);
        rectangle.setLayoutY(this.shape.getLayoutY() - 25);
        rectangle.setWidth(this.shape.getWidth() + 50);
        rectangle.setHeight(this.shape.getHeight() + 50);
        rectangle.setArcWidth(25);
        rectangle.setArcHeight(25);
        rectangle.setStroke(Color.valueOf("dbd3d3"));
        rectangle.setFill(Color.TRANSPARENT);

        super.getChildren().addAll(shape, rectangle);
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

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

    @Override
    public Preview copy() {

        BoundaryPreview preview = new BoundaryPreview();

        preview.getPreview().setFill(this.shape.getFill());
        preview.shape.setArcWidth(this.shape.getArcWidth());
        preview.shape.setArcHeight(this.shape.getArcHeight());
        preview.shape.setStroke(this.shape.getStroke());
        preview.shape.getStrokeDashArray().addAll(this.shape.getStrokeDashArray());
        preview.shape.setStrokeWidth(this.shape.getStrokeWidth());
        preview.shape.setStrokeLineCap(this.shape.getStrokeLineCap());

        return preview;
    }

    public Rectangle getPreview() {
        return this.shape;
    }
}

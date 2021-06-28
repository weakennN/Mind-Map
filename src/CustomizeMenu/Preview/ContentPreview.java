package CustomizeMenu.Preview;

import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class ContentPreview extends Preview {

    private TextField textField;

    public ContentPreview() {

        this.init();
    }

    @Override
    public void init() {

        this.textField = new TextField("Example");
        this.textField.getStylesheets().add("Style/DefaultNodeContentProperty.css");
        this.textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(25), BorderWidths.DEFAULT)));
        this.textField.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(25), null)));
        this.textField.setFont(Font.font("Verdana", FontPosture.REGULAR, 16));
        this.textField.setPrefSize(120, 40);

        Rectangle rectangle = new Rectangle(0, 0, 650, 200);
        rectangle.setArcHeight(25);
        rectangle.setArcWidth(25);
        rectangle.setFill(Color.valueOf("e8ede9"));

        this.textField.setLayoutX(rectangle.getLayoutX() + (rectangle.getWidth() / 2) - this.textField.getPrefWidth() / 2);
        this.textField.setLayoutY(rectangle.getLayoutY() + (rectangle.getHeight() / 2) - this.textField.getPrefHeight() / 2);

        super.getChildren().addAll(rectangle, this.textField);
    }

    @Override
    public Preview copy() {

        ContentPreview contentPreview = new ContentPreview();
        BackgroundFill backgroundFill = this.textField.getBackground().getFills().get(0);
        contentPreview.textField.setBackground(new Background(new BackgroundFill(backgroundFill.getFill(), backgroundFill.getRadii(), backgroundFill.getInsets())));
        BorderStroke borderStroke = this.textField.getBorder().getStrokes().get(0);
        contentPreview.textField.setBorder(new Border(new BorderStroke(borderStroke.getBottomStroke(), borderStroke.getLeftStyle(), borderStroke.getRadii(), borderStroke.getWidths())));
        //contentPreview.textField.setMinSize(this.textField.getMinWidth(),this.textField.getMinHeight());
        //contentPreview.textField.setStyle(this.textField.getStyle());
        contentPreview.textField.setFont(this.textField.getFont());

        return contentPreview;
    }

    @Override
    protected double computePrefHeight(double width) {
        return 200;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 650;
    }

    public TextField getTextField() {
        return this.textField;
    }
}

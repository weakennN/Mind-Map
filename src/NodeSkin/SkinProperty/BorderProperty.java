package NodeSkin.SkinProperty;

import Nodes.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderProperty extends SkinProperty {

    private Border border;
    private BorderStrokeStyle strokeStyle;
    private BorderStroke borderStroke;
    private Color color;
    private CornerRadii cornerRadii;
    private BorderWidths borderWidths;

    public BorderProperty() {

    }

    public BorderProperty(Node node) {

        super(node);
    }

    @Override
    public void init() {

        this.color = Color.BLACK;
        this.cornerRadii = new CornerRadii(0);
        this.borderWidths = BorderWidths.DEFAULT;
        this.strokeStyle = BorderStrokeStyle.SOLID;
        this.setNodeBorder();
    }

    public void changeBorderStyle(CornerRadii cornerRadii) {

        this.cornerRadii = cornerRadii;
        this.setNodeBorder();
        super.getNode().getSkin().getSkinProperty(BackgroundProperty.class).changeBackgroundRadii(cornerRadii);
    }

    public void changeBorderStyle(Color color) {

        this.color = color;
        this.setNodeBorder();
    }

    public BorderStrokeStyle getStrokeStyle() {
        return strokeStyle;
    }

    public void setStrokeStyle(BorderStrokeStyle strokeStyle) {
        this.strokeStyle = strokeStyle;
    }

    public void changeBorderStyle(BorderStrokeStyle strokeStyle) {
        this.strokeStyle = strokeStyle;
        this.setNodeBorder();
    }

    public void setBorder(Border border) {
        this.border = border;
    }

    public void changeBorderStyle(BorderWidths borderWidths) {

        this.borderWidths = borderWidths;
        this.setNodeBorder();
    }

    public void setNodeBorder() {

        this.borderStroke = new BorderStroke(this.color, this.strokeStyle, this.cornerRadii, this.borderWidths);
        this.border = new Border(this.borderStroke);
        super.getNode().setBorder(this.border);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCornerRadii(CornerRadii cornerRadii) {
        this.cornerRadii = cornerRadii;
    }

    public void setBorderWidths(BorderWidths borderWidths) {
        this.borderWidths = borderWidths;
    }

    public Color getColor() {
        return color;
    }

    public CornerRadii getCornerRadii() {
        return cornerRadii;
    }

    public BorderWidths getBorderWidths() {
        return borderWidths;
    }

    public Border getBorder() {
        return this.border;
    }

    public void setBorderStroke(BorderStroke borderStroke) {
        this.borderStroke = borderStroke;
    }
}

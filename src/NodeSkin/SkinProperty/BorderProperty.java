package NodeSkin.SkinProperty;


import Nodes.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BorderProperty extends SkinProperty {

    private Border border;
    private BorderStrokeStyle strokeStyle;
    private Color color;
    private CornerRadii cornerRadii;
    private BorderWidths borderWidths;

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

    public void changeBorderStyle(BorderStrokeStyle strokeStyle) {
        this.strokeStyle = strokeStyle;
        this.setNodeBorder();
    }

    public void changeBorderStyle(BorderWidths borderWidths) {

        this.borderWidths = borderWidths;
        this.setNodeBorder();
    }

    private void setNodeBorder() {
        this.border = new Border(new BorderStroke(this.color, this.strokeStyle, this.cornerRadii, this.borderWidths));
        super.getNode().setBorder(this.border);
    }
}

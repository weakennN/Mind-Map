package Nodes.Skin.SkinProperty;


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
        this.border = new Border(new BorderStroke(this.color, this.strokeStyle, this.cornerRadii, this.borderWidths));
        super.getNode().setBorder(this.border);
    }

    public void changeBorderStyle(CornerRadii cornerRadii) {
        this.cornerRadii = cornerRadii;
        this.border = new Border(new BorderStroke(this.color, this.strokeStyle, this.cornerRadii, this.borderWidths));
        super.getNode().setBorder(this.border);
    }
}

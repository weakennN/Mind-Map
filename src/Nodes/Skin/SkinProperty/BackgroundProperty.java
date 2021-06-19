package Nodes.Skin.SkinProperty;

import Nodes.Node;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class BackgroundProperty extends SkinProperty {

    private BackgroundFill backgroundFill;
    private Background background;
    private Color color;
    private CornerRadii cornerRadii;
    private Insets insets;

    public BackgroundProperty(Node node) {

        super(node);
    }

    @Override
    public void init() {
        this.cornerRadii = new CornerRadii(0);
        this.insets = new Insets(0);
        this.color = Color.AQUA;
        this.backgroundFill = new BackgroundFill(Color.valueOf(this.color.toString()), this.cornerRadii,
                this.insets);
        this.background = new Background(this.backgroundFill);
        super.getNode().setBackground(this.background);
    /*    super.getNode().setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(20), BorderWidths.DEFAULT)));

     */

    }

    public void changeColor(Color color) {
        this.color = color;

        this.backgroundFill = new BackgroundFill(Color.valueOf(this.color.toString()), new CornerRadii(0),
                new Insets(0));
        this.background = new Background(this.backgroundFill);
        super.getNode().setBackground(this.background);

    }

    public CornerRadii getCornerRadii() {
        return cornerRadii;
    }

    public void setCornerRadii(CornerRadii cornerRadii) {
        this.cornerRadii = cornerRadii;
    }

    public Insets getInsets() {
        return insets;
    }

    public void setInsets(Insets insets) {
        this.insets = insets;
    }
}

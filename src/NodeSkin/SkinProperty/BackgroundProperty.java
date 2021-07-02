package NodeSkin.SkinProperty;

import Nodes.Node;
import SaveSystem.Annotaions.BackgroundPropertySerialize;
import SaveSystem.Annotaions.ColorSerialize;
import SaveSystem.Annotaions.CornerRadiiSerialize;
import SaveSystem.Annotaions.PrimitiveSerialize;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

@BackgroundPropertySerialize
public class BackgroundProperty extends SkinProperty {

    private BackgroundFill backgroundFill;
    private Background background;
    @ColorSerialize
    private Color color;
    @CornerRadiiSerialize
    private CornerRadii cornerRadii;
    private Insets insets;

    public BackgroundProperty() {

    }

    public BackgroundProperty(Node node) {

        super(node);
    }

    @Override
    public void init() {
        this.cornerRadii = new CornerRadii(0);
        this.insets = new Insets(0);
        this.color = Color.WHITE;
        this.backgroundFill = new BackgroundFill(Color.valueOf(this.color.toString()), this.cornerRadii,
                this.insets);
        this.background = new Background(this.backgroundFill);

        super.getNode().setBackground(this.background);
    }

    public void changeColor(Color color) {
        this.color = color;

        this.backgroundFill = new BackgroundFill(Color.valueOf(this.color.toString()), this.cornerRadii,
                new Insets(0));
        this.background = new Background(this.backgroundFill);
        super.getNode().setBackground(this.background);

    }

    public void changeBackgroundRadii(CornerRadii cornerRadii) {

        this.cornerRadii = cornerRadii;
        super.getNode().setBackground(new Background(new BackgroundFill(Color.valueOf(this.color.toString()), this.cornerRadii,
                new Insets(0))));
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

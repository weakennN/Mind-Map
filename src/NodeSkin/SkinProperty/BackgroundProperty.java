package NodeSkin.SkinProperty;

import Nodes.Node;
import SaveSystem.Annotaions.ColorSerialize;
import SaveSystem.Annotaions.CornerRadiiSerialize;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

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
        this.changeNodeBackground();
    }

    public void changeBackgroundRadii(CornerRadii cornerRadii) {

        this.cornerRadii = cornerRadii;
        this.changeNodeBackground();
    }

    public void changeNodeBackground() {
        this.background = new Background(new BackgroundFill(Color.valueOf(this.color.toString()), this.cornerRadii,
                new Insets(0)));
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

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Background getBackground() {
        return this.background;
    }

    public void setBackgroundFill(BackgroundFill backgroundFill) {
        this.backgroundFill = backgroundFill;
    }

    public void setBackground(Background background) {
        this.background = background;
    }
}

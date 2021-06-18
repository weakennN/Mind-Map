package Nodes.Skin.SkinProperty;

import Nodes.Node;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class BackgroundProperty extends SkinProperty {

    private BackgroundFill backgroundFill;
    private Background background;

    public BackgroundProperty(Node node) {

        super(node);
    }

    @Override
    public void init(Node node) {

        this.backgroundFill = new BackgroundFill(Color.valueOf("f7fafa"), new CornerRadii(20),
                new Insets(5));

        this.background = new Background(this.backgroundFill);
        node.setBackground(this.background);
    }

}

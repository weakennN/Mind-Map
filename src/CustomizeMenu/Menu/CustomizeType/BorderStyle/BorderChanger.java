package CustomizeMenu.Menu.CustomizeType.BorderStyle;

import CustomizeMenu.Menu.CustomizeType.CustomizeType;
import CustomizeMenu.Preview;
import Nodes.Node;
import Nodes.Skin.SkinProperty.BorderProperty;
import UIControls.Slider;

public class BorderChanger extends CustomizeType {

    private Slider slider;
    private BorderType clicked;

    public BorderChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {

        this.slider = new Slider();
        this.slider.addItem(new DefaultBorder(super.getPreview(),this));
        this.slider.addItem(new RoundBorder(super.getPreview(), this));
        super.getChildren().add(this.slider);
    }

    @Override
    public void customizeNode(Node node) {

        node.getSkin().getSkinProperty(BorderProperty.class).changeBorderStyle(this.clicked.getCornerRadii());
    }

    public void setClicked(BorderType clicked) {
        this.clicked = clicked;
    }
}

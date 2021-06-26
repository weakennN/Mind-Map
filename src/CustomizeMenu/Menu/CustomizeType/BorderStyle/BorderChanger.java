package CustomizeMenu.Menu.CustomizeType.BorderStyle;

import CustomizeMenu.BorderCustomizeType;
import CustomizeMenu.Preview.Preview;
import UIControls.Slider;

public abstract class BorderChanger extends BorderCustomizeType {

    private Slider slider;
    private Option clicked;

    public BorderChanger(Preview preview) {

        super(preview);
    }

    @Override
    protected void init() {

        this.slider = new Slider();
        super.getChildren().add(this.slider);
    }

    protected Slider getSlider() {
        return this.slider;
    }

    public void setClicked(Option clicked) {
        this.clicked = clicked;
    }

    protected Option getClicked() {
        return this.clicked;
    }
}

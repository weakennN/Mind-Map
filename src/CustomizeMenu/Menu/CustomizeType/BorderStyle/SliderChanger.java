package CustomizeMenu.Menu.CustomizeType.BorderStyle;

import CustomizeMenu.SliderCustomizeType;
import CustomizeMenu.Preview.Preview;
import UIControls.Slider;

public abstract class SliderChanger extends SliderCustomizeType {

    private Slider slider;
    private Option clicked;

    public SliderChanger(Preview preview) {

        super(preview);
        this.init();
    }

    @Override
    protected void init() {

        this.slider = new Slider();
        super.setMinSize(slider.getMinWidth(), slider.getMinHeight());
        super.getChildren().add(this.slider);
    }

    public Slider getSlider() {
        return this.slider;
    }

    public void setClicked(Option clicked) {
        this.clicked = clicked;
    }

    protected Option getClicked() {
        return this.clicked;
    }
}

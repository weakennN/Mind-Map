package CustomizeMenu.Menu.Action;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.SliderChanger;

public abstract class SliderAction extends Action {

    private SliderChanger sliderChanger;
    private Option option;

    public SliderAction(SliderChanger sliderChanger) {
        this.sliderChanger = sliderChanger;
    }

    public Option getOption() {
        return this.option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    protected SliderChanger getSliderChanger() {
        return this.sliderChanger;
    }
}

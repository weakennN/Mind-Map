package CustomizeMenu;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Menu.CustomizeType.CustomizeType;
import CustomizeMenu.Preview.Preview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class SliderCustomizeType extends CustomizeType {

    private List<Option> styleOptions;

    public SliderCustomizeType(Preview preview) {
        super(preview);
    }

    protected void setPreviewToOptions(Preview preview) {

        for (Option option : this.styleOptions) {
            option.setPreview(preview);
        }
    }

    protected void addStyleOptions(Option... options) {

        if (this.styleOptions == null) {
            this.styleOptions = new ArrayList<>();
        }

        this.styleOptions.addAll(Arrays.asList(options));
    }

    @Override
    public void setPreview(Preview preview) {

        super.setPreview(preview);
        this.setPreviewToOptions(preview);
    }
}

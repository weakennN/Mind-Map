package CustomizeMenu;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderStyleOption;
import CustomizeMenu.Menu.CustomizeType.CustomizeType;
import CustomizeMenu.Preview.Preview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class BorderCustomizeType extends CustomizeType {

    private List<BorderStyleOption> styleOptions;

    public BorderCustomizeType(Preview preview) {
        super(preview);
    }

    protected void setPreviewToOptions(Preview preview) {

        for (BorderStyleOption borderStyleOption : this.styleOptions) {
            borderStyleOption.setPreview(preview);
        }
    }

    protected void addStyleOptions(BorderStyleOption... borderStyleOptions) {

        if (this.styleOptions == null) {
            this.styleOptions = new ArrayList<>();
        }

        this.styleOptions.addAll(Arrays.asList(borderStyleOptions));
    }

    @Override
    public void setPreview(Preview preview) {

        super.setPreview(preview);
        this.setPreviewToOptions(preview);
    }
}

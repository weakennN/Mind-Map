package CustomizeMenu.Menu.CustomizeType.FontChanger.Option;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.Option;
import CustomizeMenu.Menu.CustomizeType.FontChanger.FormatFontChanger;
import CustomizeMenu.Preview.ContentPreview;
import CustomizeMenu.Preview.Preview;
import javafx.scene.text.Font;

public abstract class FontOption extends Option {

    private Font font;

    public FontOption(Preview preview, FormatFontChanger formatFontChanger) {
        super(preview);

        this.initActions(formatFontChanger);
    }

    private void initActions(FormatFontChanger formatFontChanger) {

        this.setOnAction(e -> {

            ContentPreview contentPreview = (ContentPreview) super.getPreview();
            contentPreview.getTextField().setFont(this.font);
            formatFontChanger.setClicked(this);
            formatFontChanger.setChanged(true);
        });
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Font getFont() {
        return this.font;
    }
}

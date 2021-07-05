package SaveSystem.Serializer.SkinSerializer.PreviewHelpSerializer;

import Common.GlobalVariables;
import CustomizeMenu.Preview.ContentPreview;
import CustomizeMenu.Preview.Preview;
import SaveSystem.Serializer.PropertySerializer.BackgroundSerializer;
import SaveSystem.Serializer.PropertySerializer.BorderSerializer;
import SaveSystem.Serializer.PropertySerializer.DefaultNodeContentSerializer;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;

import java.util.Map;

public class FormatPreviewHelpSerializer extends PreviewHelpSerializer {

    public FormatPreviewHelpSerializer() {
        super();

        super.addPropertySerializer("backgroundSerializer", new BackgroundSerializer());
        super.addPropertySerializer("borderSerializer", new BorderSerializer());
        super.addPropertySerializer("contentSerializer", new DefaultNodeContentSerializer());
    }

    @Override
    public boolean isSuitable(Preview preview) {
        return preview instanceof ContentPreview;
    }

    @Override
    public boolean isSuitable(String key) {
        return key.equals("content");
    }

    @Override
    public void save(Preview preview, Map<String, Map<String, Object>> fields) {

        ContentPreview contentPreview = (ContentPreview) preview;

        super.getPropertySerializer("backgroundSerializer").save(contentPreview.getTextField().getBackground(), fields, "formatBackground");
        super.getPropertySerializer("borderSerializer").save(contentPreview.getTextField().getBorder(), fields, "formatBorder");
        super.getPropertySerializer("contentSerializer").save(contentPreview.getTextField(), fields, "contentTextField");
    }

    @Override
    public Preview load(Map<String, Map<String, Object>> fields) {

        ContentPreview contentPreview = new ContentPreview();

        TextField textField = (TextField) super.getPropertySerializer("contentSerializer").load(fields, "contentTextField");

        Background background = (Background) super.getPropertySerializer("backgroundSerializer").load(fields, "formatBackground");
        Border border = (Border) super.getPropertySerializer("borderSerializer").load(fields, "formatBorder");

        textField.setBackground(background);
        textField.setBorder(border);

        contentPreview.setTextField(textField);

        return contentPreview;
    }

    @Override
    public String getKey() {
        return GlobalVariables.FORMAT_PREVIEW_TAG;
    }
}

package SaveSystem.Serializer.SkinSerializer.SkinPropertyHelpSerializer;

import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import NodeSkin.SkinProperty.SkinProperty;
import Nodes.Node;
import SaveSystem.Serializer.PropertySerializer.BackgroundSerializer;
import SaveSystem.Serializer.PropertySerializer.BorderSerializer;
import SaveSystem.Serializer.PropertySerializer.DefaultNodeContentSerializer;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import java.util.Map;

public class DefaultNodeSkinPropertyHelpSerializer extends SkinPropertiesHelpSerializer {

    public DefaultNodeSkinPropertyHelpSerializer() {
        super();

        super.addPropertySerializer("backgroundProperty", new BackgroundSerializer());
        super.addPropertySerializer("borderProperty", new BorderSerializer());
        super.addPropertySerializer("defaultNodeContentProperty", new DefaultNodeContentSerializer());
    }

    @Override
    public boolean isSuitable(SkinProperty skinProperty) {
        return skinProperty instanceof DefaultNodeContentProperty;
    }

    @Override
    public boolean isSuitable(String property) {
        return property.equals("content");
    }

    @Override
    public void save(SkinProperty skinProperty, Map<String, Map<String, Object>> fields) {
        DefaultNodeContentProperty contentProperty = (DefaultNodeContentProperty) skinProperty;

        super.getPropertySerializer("defaultNodeContentProperty").save(contentProperty.getTextFiled(), fields, "content");
        super.getPropertySerializer("backgroundProperty").save(contentProperty.getTextFiled().getBackground(), fields, "contentBackground");
        super.getPropertySerializer("borderProperty").save(contentProperty.getTextFiled().getBorder(), fields, "contentBorder");
    }

    @Override
    public SkinProperty load(Map<String, Map<String, Object>> fields, Object object) {

        DefaultNodeContentProperty contentProperty = new DefaultNodeContentProperty();

        TextField textField = (TextField) super.getPropertySerializer("defaultNodeContentProperty").load(fields, "content");

        Background background = (Background) super.getPropertySerializer("backgroundProperty").load(fields, "contentBackground");
        textField.setBackground(background);

        Border border = (Border) super.getPropertySerializer("borderProperty").load(fields, "contentBorder");
        textField.setBorder(border);

        contentProperty.setTextField(textField);
        contentProperty.setNode((Node) object);
        ((Node) object).add(textField);
        contentProperty.initActions();

        return contentProperty;
    }
}

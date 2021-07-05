package SaveSystem.Serializer.SkinSerializer.SkinPropertyHelpSerializer;

import NodeSkin.SkinProperty.BackgroundProperty;
import NodeSkin.SkinProperty.SkinProperty;
import Nodes.Node;
import SaveSystem.Serializer.PropertySerializer.BackgroundSerializer;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

import java.util.Map;

public class BackgroundPropertyHelpSerializer extends SkinPropertiesHelpSerializer {

    public BackgroundPropertyHelpSerializer() {
        super();

        super.addPropertySerializer("backgroundSerializer", new BackgroundSerializer());
    }

    @Override
    public boolean isSuitable(SkinProperty skinProperty) {
        return skinProperty instanceof BackgroundProperty;
    }

    @Override
    public boolean isSuitable(String property) {
        return property.equals("background");
    }

    @Override
    public void save(SkinProperty skinProperty, Map<String, Map<String, Object>> fields) {
        super.getPropertySerializer("backgroundSerializer").save(((BackgroundProperty) skinProperty).getBackground(), fields, "background");
    }

    @Override
    public SkinProperty load(Map<String, Map<String, Object>> fields, Object object) {

        Background background = (Background) super.getPropertySerializer("backgroundSerializer").load(fields, "background");

        BackgroundProperty backgroundProperty = new BackgroundProperty();
        backgroundProperty.setColor((Color) background.getFills().get(0).getFill());
        backgroundProperty.setCornerRadii(background.getFills().get(0).getRadii());
        backgroundProperty.setBackgroundFill(background.getFills().get(0));
        backgroundProperty.setBackground(background);

        backgroundProperty.setNode((Node) object);
        backgroundProperty.changeNodeBackground();

        return backgroundProperty;
    }
}

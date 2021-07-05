package SaveSystem.Serializer.SkinSerializer;

import NodeSkin.SkinProperty.BorderProperty;
import NodeSkin.SkinProperty.SkinProperty;
import Nodes.Node;
import SaveSystem.Serializer.PropertySerializer.BorderSerializer;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Map;

public class BorderPropertyHelpSerializer extends SkinPropertiesHelpSerializer {

    public BorderPropertyHelpSerializer() {
        super();

        super.addPropertySerializer("borderProperty", new BorderSerializer());
    }

    @Override
    public boolean isSuitable(SkinProperty skinProperty) {
        return skinProperty instanceof BorderProperty;
    }

    public boolean isSuitable(String property) {
        return property.equals("border");
    }

    @Override
    public void save(SkinProperty skinProperty, Map<String, Map<String, Object>> fields) {
        super.getPropertySerializer("borderProperty").save(((BorderProperty) skinProperty).getBorder(), fields,"border");
    }

    @Override
    public SkinProperty load(Map<String, Map<String, Object>> fields, Object object) {

        BorderProperty borderProperty = new BorderProperty();

        Border border = (Border) super.getPropertySerializer("borderProperty").load(fields,"border");
        BorderStroke borderStroke = border.getStrokes().get(0);

        borderProperty.setColor((Color) borderStroke.getBottomStroke());
        borderProperty.setCornerRadii(borderStroke.getRadii());
        borderProperty.setBorderWidths(borderStroke.getWidths());
        borderProperty.setStrokeStyle(borderStroke.getBottomStyle());
        borderProperty.setBorderStroke(borderStroke);
        borderProperty.setBorder(border);

        borderProperty.setNode((Node) object);
        borderProperty.setNodeBorder();

        return borderProperty;
    }
}

package SaveSystem.Serializer.PropertySerializer;

import Common.BorderStrokeStyleManager;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class BorderSerializer extends PropertySerializer {

    public BorderSerializer() {
        BorderStrokeStyleManager.init();
    }

    @Override
    public void save(Object object, Map<String, Map<String, Object>> fields, String key) {

        Border border = (Border) object;

        BorderStroke borderStroke = border.getStrokes().get(0);

        fields.put(key, new HashMap<>());

        Map<String, Object> properties = fields.get(key);

        String color = borderStroke.getBottomStroke().toString().substring(2);
        properties.put("color", color);

        double radii = borderStroke.getRadii().getBottomLeftHorizontalRadius();
        properties.put("cornerRadii", radii);

        double borderWidths = borderStroke.getWidths().getBottom();
        properties.put("borderWidths", borderWidths);

        String borderStrokeStyle = BorderStrokeStyleManager.getBorderStrokeStyle(borderStroke.getLeftStyle());

        properties.put("borderStrokeStyle", borderStrokeStyle);
    }

    @Override
    public Object load(Map<String, Map<String, Object>> fields, String key) {

        Map<String, Object> borderFields = fields.get(key);

        Color color = Color.valueOf((String) borderFields.get("color"));

        CornerRadii cornerRadii = new CornerRadii((double) borderFields.get("cornerRadii"));

        BorderWidths borderWidths = new BorderWidths((double) borderFields.get("borderWidths"));

        BorderStrokeStyle borderStrokeStyle = BorderStrokeStyleManager.getBorderStrokeStyle((String) borderFields.get("borderStrokeStyle"));

        return new Border(new BorderStroke(color, borderStrokeStyle, cornerRadii, borderWidths));
    }
}

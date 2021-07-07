package SaveSystem.Serializer.PropertySerializer;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BorderSerializer extends PropertySerializer {

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

        Map<String, Object> strokeProperties = new HashMap<>();

        strokeProperties.put("dashArray", borderStroke.getBottomStyle().getDashArray());
        strokeProperties.put("dashOffset", borderStroke.getBottomStyle().getDashOffset());
        strokeProperties.put("lineGap", borderStroke.getBottomStyle().getLineCap());
        strokeProperties.put("lineJoin", borderStroke.getBottomStyle().getLineJoin());
        strokeProperties.put("miterLimit", borderStroke.getBottomStyle().getMiterLimit());
        strokeProperties.put("strokeType", borderStroke.getBottomStyle().getType());

        properties.put("borderStroke", strokeProperties);
    }

    @Override
    public Object load(Map<String, Map<String, Object>> fields, String key) {

        Map<String, Object> borderFields = fields.get(key);

        Color color = Color.valueOf((String) borderFields.get("color"));

        CornerRadii cornerRadii = new CornerRadii((double) borderFields.get("cornerRadii"));

        BorderWidths borderWidths = new BorderWidths((double) borderFields.get("borderWidths"));

        Map<String, Object> strokeProperties = (Map<String, Object>) borderFields.get("borderStroke");

        StrokeType strokeType = (StrokeType) strokeProperties.get("strokeType");
        StrokeLineJoin strokeLineJoin = (StrokeLineJoin) strokeProperties.get("lineJoin");
        StrokeLineCap strokeLineCap = (StrokeLineCap) strokeProperties.get("lineGap");
        double miterLimit = (double) strokeProperties.get("miterLimit");
        double dashOffset = (double) strokeProperties.get("dashOffset");
        List<Double> dashArray = (List<Double>) strokeProperties.get("dashArray");

        BorderStrokeStyle borderStrokeStyle = new BorderStrokeStyle(strokeType, strokeLineJoin,
                strokeLineCap, miterLimit, dashOffset, dashArray);

        return new Border(new BorderStroke(color, borderStrokeStyle, cornerRadii, borderWidths));
    }
}

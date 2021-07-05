package SaveSystem.Serializer.PropertySerializer;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class BackgroundSerializer extends PropertySerializer {

    @Override
    public void save(Object object, Map<String, Map<String, Object>> fields,String key) {

        Background background = (Background) object;

        BackgroundFill backgroundFill = background.getFills().get(0);

        fields.put(key, new HashMap<>());
        Map<String, Object> properties = fields.get(key);

        String color = backgroundFill.getFill().toString().substring(2);
        properties.put("color", color);

        double radii = backgroundFill.getRadii().getBottomLeftHorizontalRadius();
        properties.put("cornerRadii", radii);
    }

    @Override
    public Object load(Map<String, Map<String, Object>> fields,String key) {

        Map<String, Object> backgroundFields = fields.get(key);

        Color color = Color.valueOf((String) backgroundFields.get("color"));

        CornerRadii cornerRadii = new CornerRadii((double) backgroundFields.get("cornerRadii"));

        return new Background(new BackgroundFill(color, cornerRadii, null));
    }
}

package SaveSystem.Serializer;

import SaveSystem.Annotaions.ColorSerialize;
import SaveSystem.Tuple;
import javafx.scene.paint.Color;

import java.lang.reflect.Field;
import java.util.List;

public class ColorSerializer extends Serializer {
    @Override
    public boolean checkCondition(Field field) {
        return field.isAnnotationPresent(ColorSerialize.class);
    }

    @Override
    public void save(List<Tuple<String, Object>> items, Field field, Object object) {

        try {
            Color color = (Color) field.get(object);
            String colorToString = color.toString();
            colorToString = colorToString.substring(2);
            items.add(new Tuple<>(field.getName(), colorToString));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object object) {

        try {
            Color color = Color.valueOf((String) item.item2);
            field.set(object, color);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

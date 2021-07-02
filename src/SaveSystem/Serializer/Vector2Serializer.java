package SaveSystem.Serializer;

import SaveSystem.Tuple;
import SaveSystem.Annotaions.Vector2Serialize;
import mikera.vectorz.Vector2;

import java.lang.reflect.Field;
import java.util.List;

public class Vector2Serializer extends Serializer {
    @Override
    public boolean checkCondition(Field field) {
        return field.isAnnotationPresent(Vector2Serialize.class);
    }

    @Override
    public void save(List<Tuple<String, Object>> items, Field field, Object node) {
        try {
            Vector2 vector = (Vector2) field.get(node);
            items.add(new Tuple<>(
                    field.getName(),
                    new Tuple<Double, Double>(vector.x, vector.y)
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object result) {
        try {
            Tuple<Double, Double> vec = (Tuple<Double, Double>) item.item2;
            field.set(result, new Vector2(vec.item1, vec.item2));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

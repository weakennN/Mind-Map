package SaveSystem.Serializer;

import SaveSystem.Annotaions.PrimitiveSerialize;
import SaveSystem.Tuple;

import java.lang.reflect.Field;
import java.util.List;

public class PrimitiveTypeSerializer extends Serializer {

    @Override
    public boolean checkCondition(Field field) {
        return field.isAnnotationPresent(PrimitiveSerialize.class);
    }

    @Override
    public void save(List<Tuple<String, Object>> items, Field field, Object object) {
        try {
            items.add(new Tuple<>(field.getName(), field.get(object)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object result) {
        try {
            field.set(result, item.item2);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

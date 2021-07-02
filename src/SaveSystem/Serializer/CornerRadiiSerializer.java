package SaveSystem.Serializer;

import SaveSystem.Annotaions.CornerRadiiSerialize;
import SaveSystem.Tuple;
import javafx.scene.layout.CornerRadii;

import java.lang.reflect.Field;
import java.util.List;

public class CornerRadiiSerializer extends Serializer {
    @Override
    public boolean checkCondition(Field field) {
        return field.isAnnotationPresent(CornerRadiiSerialize.class);
    }

    @Override
    public void save(List<Tuple<String, Object>> items, Field field, Object object) {

        try {
            CornerRadii cornerRadii = (CornerRadii) field.get(object);
            items.add(new Tuple<>(field.getName(), cornerRadii.getBottomLeftHorizontalRadius()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object object) {
        try {
            CornerRadii cornerRadii = new CornerRadii((double) item.item2);
            field.set(object, cornerRadii);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

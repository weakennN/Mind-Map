package SaveSystem.Serializer;

import Nodes.Node;
import SaveSystem.*;
import SaveSystem.Annotaions.SkinSerialize;

import java.lang.reflect.Field;
import java.util.List;

public class SkinSerializer extends Serializer {

    @Override
    public boolean checkCondition(Field field) {
        return field.isAnnotationPresent(SkinSerialize.class);
    }

    @Override
    public void save(List<Tuple<String, Object>> items, Field field, Object object) {

        Saver.save(((Node) object).getSkin());
    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object object) {
        try {
            field.set(object, Saver.load());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

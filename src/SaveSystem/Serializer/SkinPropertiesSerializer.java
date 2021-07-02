package SaveSystem.Serializer;

import NodeSkin.SkinProperty.SkinProperty;
import SaveSystem.Annotaions.SkinPropertiesSerialize;
import SaveSystem.Saver;
import SaveSystem.Tuple;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class SkinPropertiesSerializer extends Serializer {

    @Override
    public boolean checkCondition(Field field) {
        return field.isAnnotationPresent(SkinPropertiesSerialize.class);
    }

    @Override
    public void save(List<Tuple<String, Object>> items, Field field, Object object) {

        try {
            List<SkinProperty> skinProperties = (List<SkinProperty>) field.get(object);

            for (SkinProperty skinProperty : skinProperties) {
                Saver.save(skinProperty);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object object) {
        try {
            //  SkinProperty skinProperty = (SkinProperty) Saver.load();
            field.set(object, new ArrayList<SkinProperty>());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

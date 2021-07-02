package SaveSystem.Serializer;

import SaveSystem.Tuple;

import java.lang.reflect.Field;
import java.util.List;

public abstract class Serializer {

    public abstract boolean checkCondition(Field field);

    public abstract void save(List<Tuple<String, Object>> items, Field field, Object object);

    public abstract void load(Tuple<String, Object> item, Field field, Object object);
}

package SaveSystem.Serializer.PropertySerializer;

import java.util.Map;

public abstract class PropertySerializer {

    public abstract void save(Object object, Map<String, Map<String, Object>> fields, String key);

    public abstract Object load(Map<String, Map<String, Object>> fields, String key);
}

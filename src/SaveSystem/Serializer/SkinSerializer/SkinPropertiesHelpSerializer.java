package SaveSystem.Serializer.SkinSerializer;

import NodeSkin.SkinProperty.SkinProperty;
import SaveSystem.Serializer.PropertySerializer.PropertySerializer;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class SkinPropertiesHelpSerializer {

    private Map<String, PropertySerializer> propertySerializers;

    public SkinPropertiesHelpSerializer() {
        this.propertySerializers = new LinkedHashMap<>();
    }

    public void addPropertySerializer(String key, PropertySerializer propertySerializer) {
        this.propertySerializers.put(key, propertySerializer);
    }

    public PropertySerializer getPropertySerializer(String key) {
        return this.propertySerializers.get(key);
    }

    public abstract boolean isSuitable(SkinProperty skinProperty);

    public abstract boolean isSuitable(String property);

    public abstract void save(SkinProperty skinProperty, Map<String, Map<String, Object>> fields);

    public abstract SkinProperty load(Map<String, Map<String, Object>> fields, Object object);
}

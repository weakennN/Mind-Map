package SaveSystem.Serializer.SkinSerializer;

import SaveSystem.Serializer.PropertySerializer.PropertySerializer;

import java.util.HashMap;
import java.util.Map;

public abstract class HelpSerializer {

    private Map<String, PropertySerializer> propertySerializers;

    public HelpSerializer() {
        this.propertySerializers = new HashMap<>();
    }

    public void addPropertySerializer(String key, PropertySerializer propertySerializer) {
        this.propertySerializers.put(key, propertySerializer);
    }

    public PropertySerializer getPropertySerializer(String key) {
        return this.propertySerializers.get(key);
    }
}

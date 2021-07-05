package SaveSystem.Serializer.SkinSerializer.SkinPropertyHelpSerializer;

import NodeSkin.SkinProperty.SkinProperty;
import SaveSystem.Serializer.SkinSerializer.HelpSerializer;

import java.util.Map;

public abstract class SkinPropertiesHelpSerializer extends HelpSerializer {

    public SkinPropertiesHelpSerializer() {
        super();
    }

    public abstract boolean isSuitable(SkinProperty skinProperty);

    public abstract boolean isSuitable(String property);

    public abstract void save(SkinProperty skinProperty, Map<String, Map<String, Object>> fields);

    public abstract SkinProperty load(Map<String, Map<String, Object>> fields, Object object);
}

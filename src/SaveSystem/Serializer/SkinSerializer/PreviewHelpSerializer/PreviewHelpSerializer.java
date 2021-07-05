package SaveSystem.Serializer.SkinSerializer.PreviewHelpSerializer;

import CustomizeMenu.Preview.Preview;
import SaveSystem.Serializer.SkinSerializer.HelpSerializer;

import java.util.Map;

public abstract class PreviewHelpSerializer extends HelpSerializer {

    public abstract boolean isSuitable(Preview preview);

    public abstract boolean isSuitable(String key);

    public abstract void save(Preview preview, Map<String, Map<String, Object>> fields);

    public abstract Preview load(Map<String, Map<String, Object>> fields);

    public abstract String getKey();
}

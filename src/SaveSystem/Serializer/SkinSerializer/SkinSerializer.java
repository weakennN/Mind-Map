package SaveSystem.Serializer.SkinSerializer;

import NodeSkin.Skin.Skin;
import NodeSkin.SkinProperty.SkinProperty;
import Nodes.Node;
import SaveSystem.*;
import SaveSystem.Annotaions.SkinSerialize;
import SaveSystem.Serializer.*;

import java.lang.reflect.Field;
import java.util.*;

public class SkinSerializer extends Serializer {

    private List<SkinPropertiesHelpSerializer> helpSerializers;

    public SkinSerializer() {
        super();

        this.helpSerializers = new ArrayList<>();
        this.helpSerializers.add(new BackgroundPropertyHelpSerializer());
        this.helpSerializers.add(new BorderPropertyHelpSerializer());
        this.helpSerializers.add(new DefaultNodeSkinPropertyHelpSerializer());
    }

    @Override
    public boolean checkCondition(Field field) {
        return field.isAnnotationPresent(SkinSerialize.class);
    }

    @Override
    public void save(List<Tuple<String, Object>> items, Field field, Object object) {

        List<SkinProperty> skinProperties = ((Node) object).getSkin().getSkinProperties();
        Map<String, Map<String, Object>> fields = new LinkedHashMap<>();
        items.add(new Tuple<>(field.getName(), fields));

        for (SkinProperty skinProperty : skinProperties) {

            for (SkinPropertiesHelpSerializer helpSerializer : this.helpSerializers) {

                if (helpSerializer.isSuitable(skinProperty)) {
                    helpSerializer.save(skinProperty, fields);
                }
            }
        }
    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object object) {
        try {

            List<SkinProperty> skinProperties = new ArrayList<>();

            Map<String, Map<String, Object>> fields = (Map<String, Map<String, Object>>) item.item2;

            for (Map.Entry<String, Map<String, Object>> entry : fields.entrySet()) {

                for (SkinPropertiesHelpSerializer serializer : this.helpSerializers) {
                    if (serializer.isSuitable(entry.getKey())) {
                        skinProperties.add(serializer.load(fields, object));
                    }
                }
            }

            Skin result = new Skin();
            result.setSkinProperties(skinProperties);

            field.set(object, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

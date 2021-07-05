package SaveSystem.Serializer.SkinSerializer;

import CustomizeMenu.Preview.Preview;
import NodeSkin.Skin.Skin;
import NodeSkin.SkinProperty.SkinProperty;
import Nodes.Node;
import SaveSystem.*;
import SaveSystem.Annotaions.SkinSerialize;
import SaveSystem.Serializer.*;
import SaveSystem.Serializer.SkinSerializer.PreviewHelpSerializer.BoundaryPreviewHelpSerializer;
import SaveSystem.Serializer.SkinSerializer.PreviewHelpSerializer.FormatPreviewHelpSerializer;
import SaveSystem.Serializer.SkinSerializer.PreviewHelpSerializer.PreviewHelpSerializer;
import SaveSystem.Serializer.SkinSerializer.SkinPropertyHelpSerializer.BackgroundPropertyHelpSerializer;
import SaveSystem.Serializer.SkinSerializer.SkinPropertyHelpSerializer.BorderPropertyHelpSerializer;
import SaveSystem.Serializer.SkinSerializer.SkinPropertyHelpSerializer.DefaultNodeSkinPropertyHelpSerializer;
import SaveSystem.Serializer.SkinSerializer.SkinPropertyHelpSerializer.SkinPropertiesHelpSerializer;

import java.lang.reflect.Field;
import java.util.*;

public class SkinSerializer extends Serializer {

    private List<SkinPropertiesHelpSerializer> skinPropertyHelpSerializers;
    private List<PreviewHelpSerializer> previewHelpSerializers;

    public SkinSerializer() {
        super();

        this.skinPropertyHelpSerializers = new ArrayList<>();
        this.skinPropertyHelpSerializers.add(new BackgroundPropertyHelpSerializer());
        this.skinPropertyHelpSerializers.add(new BorderPropertyHelpSerializer());
        this.skinPropertyHelpSerializers.add(new DefaultNodeSkinPropertyHelpSerializer());

        this.previewHelpSerializers = new ArrayList<>();
        this.previewHelpSerializers.add(new BoundaryPreviewHelpSerializer());
        this.previewHelpSerializers.add(new FormatPreviewHelpSerializer());
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

            for (SkinPropertiesHelpSerializer helpSerializer : this.skinPropertyHelpSerializers) {

                if (helpSerializer.isSuitable(skinProperty)) {
                    helpSerializer.save(skinProperty, fields);
                    break;
                }
            }
        }

        Map<String, Preview> previews = ((Node) object).getSkin().getPreviews();

        for (Map.Entry<String, Preview> entry : previews.entrySet()) {

            for (PreviewHelpSerializer previewHelpSerializer : this.previewHelpSerializers) {
                if (previewHelpSerializer.isSuitable(previews.get(entry.getKey()))) {
                    previewHelpSerializer.save(previews.get(entry.getKey()), fields);
                    break;
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

                for (SkinPropertiesHelpSerializer serializer : this.skinPropertyHelpSerializers) {
                    if (serializer.isSuitable(entry.getKey())) {
                        skinProperties.add(serializer.load(fields, object));
                        break;
                    }
                }
            }

            Map<String, Preview> previews = new HashMap<>();

            for (Map.Entry<String, Map<String, Object>> entry : fields.entrySet()) {

                for (PreviewHelpSerializer previewHelpSerializer : this.previewHelpSerializers) {
                    if (previewHelpSerializer.isSuitable(entry.getKey())) {
                        previews.put(previewHelpSerializer.getKey(), previewHelpSerializer.load(fields));
                        break;
                    }
                }
            }

            Skin result = new Skin();
            result.setSkinProperties(skinProperties);
            result.setPreviews(previews);

            field.set(object, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

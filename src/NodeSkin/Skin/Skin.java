package NodeSkin.Skin;

import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import NodeSkin.SkinProperty.SkinProperty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Skin {

    private Node node;
    private List<SkinProperty> skinProperties;
    private Map<String, Preview> previews;

    public Skin(Node node) {

        this.node = node;
        this.skinProperties = new ArrayList<>();
        this.previews = new HashMap<>();
    }

    public <T extends SkinProperty> T getSkinProperty(Class<T> skinProperty) {

        for (SkinProperty s : this.skinProperties) {

            if (skinProperty.isAssignableFrom(s.getClass())) {

                return skinProperty.cast(s);
            }
        }

        return null;
    }

    public Preview getPreview(String preview) {

        return this.previews.get(preview);
    }

    public void addPreview(String key, Preview preview) {

        this.previews.put(key, preview);
    }

    public void replacePreview(String key, Preview preview) {
        this.addPreview(key, preview);
    }

    public void addSkinProperty(SkinProperty skinProperty) {
        this.skinProperties.add(skinProperty);
    }
}

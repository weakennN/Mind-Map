package NodeSkin.Skin;

import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import NodeSkin.SkinProperty.SkinProperty;

import java.util.ArrayList;
import java.util.List;

public abstract class Skin {

    private Node node;
    private List<SkinProperty> skinProperties;
    private List<Preview> previews;

    public Skin(Node node) {

        this.node = node;
        this.skinProperties = new ArrayList<>();
        this.previews = new ArrayList<>();
    }

    public <T extends SkinProperty> T getSkinProperty(Class<T> skinProperty) {

        for (SkinProperty s : this.skinProperties) {

            if (skinProperty.isAssignableFrom(s.getClass())) {

                return skinProperty.cast(s);
            }
        }

        return null;
    }

    public void addSkinProperty(SkinProperty skinProperty) {
        this.skinProperties.add(skinProperty);
    }

    public void addPreview(Preview preview) {
        this.previews.add(preview);
    }

    public <T extends Preview> T getPreview(Class<T> preview) {

        for (Preview p : this.previews) {

            if (preview.isAssignableFrom(p.getClass())) {
                return preview.cast(p);
            }
        }

        return null;
    }

    public List<Preview> getPreviews() {
        return this.previews;
    }
}

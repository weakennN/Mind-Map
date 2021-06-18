package Nodes.Skin;

import Nodes.Node;
import Nodes.Skin.SkinProperty.SkinProperty;

import java.util.ArrayList;
import java.util.List;

public abstract class Skin {

    private Node node;
    private List<SkinProperty> skinProperties;

    public Skin(Node node) {

        this.node = node;
        this.skinProperties = new ArrayList<>();
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
}

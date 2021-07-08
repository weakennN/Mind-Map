package Common;

import javafx.scene.layout.BorderStrokeStyle;

import java.util.HashMap;
import java.util.Map;

public class BorderStrokeStyleManager {

    private static Map<String, BorderStrokeStyle> borderStrokeStyles;

    public static void init() {
        borderStrokeStyles = new HashMap<>();
        borderStrokeStyles.put("solid", BorderStrokeStyle.SOLID);
        borderStrokeStyles.put("dotted", BorderStrokeStyle.DOTTED);
    }

    public static String getBorderStrokeStyle(BorderStrokeStyle borderStrokeStyle) {

        if (borderStrokeStyle.equals(BorderStrokeStyle.SOLID)) {
            return "solid";
        }

        return "dotted";
    }

    public static BorderStrokeStyle getBorderStrokeStyle(String key) {
        return borderStrokeStyles.get(key);
    }
}

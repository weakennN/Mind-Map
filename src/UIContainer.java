import UI.UI;

import java.util.ArrayList;
import java.util.List;

public class UIContainer {

    public static List<UI> uis = new ArrayList<>();

    public static void add(UI ui) {
        uis.add(ui);
    }

    public static void remove(UI ui) {
        uis.remove(ui);
    }
}

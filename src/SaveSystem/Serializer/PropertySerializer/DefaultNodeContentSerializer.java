package SaveSystem.Serializer.PropertySerializer;

import SaveSystem.Tuple;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

import java.util.HashMap;
import java.util.Map;

public class DefaultNodeContentSerializer extends PropertySerializer {

    @Override
    public void save(Object object, Map<String, Map<String, Object>> fields, String key) {

        TextField textField = (TextField) object;

        fields.put(key, new HashMap<>());

        Map<String, Object> properties = fields.get(key);

        properties.put("minSize", new Tuple<Double, Double>(textField.getMinWidth()
                , textField.getMinHeight()));

        properties.put("prefSize", new Tuple<Double, Double>(textField.getPrefWidth()
                , textField.getPrefHeight()));

        properties.put("layoutPos", new Tuple<Double, Double>(textField.getLayoutX()
                , textField.getLayoutY()));

        properties.put("text", textField.getText());

        Map<String, Object> fontMap = new HashMap<>();

        Font font = textField.getFont();
        fontMap.put("size", font.getSize());
        fontMap.put("name", font.getName());
        fontMap.put("style", font.getStyle());

        properties.put("font", fontMap);

    }

    @Override
    public Object load(Map<String, Map<String, Object>> fields, String key) {

        TextField textField = new TextField();

        Map<String, Object> contentFields = fields.get(key);

        double minWidth = ((Tuple<Double, Double>) contentFields.get("minSize")).item1;
        double minHeight = ((Tuple<Double, Double>) contentFields.get("minSize")).item2;

        textField.setMinSize(minWidth, minHeight);

        double prefWidth = ((Tuple<Double, Double>) contentFields.get("prefSize")).item1;
        double prefHeight = ((Tuple<Double, Double>) contentFields.get("prefSize")).item2;

        textField.setPrefSize(prefWidth, prefHeight);

        double layoutX = ((Tuple<Double, Double>) contentFields.get("layoutPos")).item1;
        double layoutY = ((Tuple<Double, Double>) contentFields.get("layoutPos")).item2;

        textField.setLayoutX(layoutX);
        textField.setLayoutY(layoutY);

        textField.setText((String) contentFields.get("text"));

        Map<String, Object> fontProp = (Map<String, Object>) contentFields.get("font");

        Font font = Font.font(((String) fontProp.get("name")), FontPosture.findByName((String) fontProp.get("style")), (double) fontProp.get("size"));

        textField.setFont(font);

        return textField;
    }
}

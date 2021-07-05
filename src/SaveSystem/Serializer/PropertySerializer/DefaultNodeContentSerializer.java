package SaveSystem.Serializer.PropertySerializer;

import SaveSystem.Tuple;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class DefaultNodeContentSerializer extends PropertySerializer {

    @Override
    public void save(Object object, Map<String, Map<String, Object>> fields,String key) {

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
    }

    @Override
    public Object load(Map<String, Map<String, Object>> fields,String key) {

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

        return textField;
    }
}

package SaveSystem.Serializer;

import NodeSkin.Skin.Skin;
import NodeSkin.SkinProperty.BackgroundProperty;
import NodeSkin.SkinProperty.BorderProperty;
import NodeSkin.SkinProperty.DefaultNodeContentProperty;
import NodeSkin.SkinProperty.SkinProperty;
import Nodes.Node;
import SaveSystem.*;
import SaveSystem.Annotaions.SkinSerialize;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;

import java.lang.reflect.Field;
import java.util.*;

public class SkinSerializer extends Serializer {

    @Override
    public boolean checkCondition(Field field) {
        return field.isAnnotationPresent(SkinSerialize.class);
    }

    @Override
    public void save(List<Tuple<String, Object>> items, Field field, Object object) {

        // Saver.save(((Node) object).getSkin());

        List<SkinProperty> skinProperties = ((Node) object).getSkin().getSkinProperties();
        Map<String, Map<String, Object>> fields = new LinkedHashMap<>();
        items.add(new Tuple<>(field.getName(), fields));

        for (SkinProperty skinProperty : skinProperties) {

            if (skinProperty instanceof BackgroundProperty) {

                BackgroundProperty backgroundProperty = (BackgroundProperty) skinProperty;

                fields.put("backgroundProperty", new HashMap<>());
                Map<String, Object> properties = fields.get("backgroundProperty");

                String color = backgroundProperty.getColor().toString().substring(2);
                properties.put("color", color);

                double radii = backgroundProperty.getCornerRadii().getBottomLeftHorizontalRadius();
                properties.put("cornerRadii", radii);

            } else if (skinProperty instanceof BorderProperty) {

                BorderProperty borderProperty = (BorderProperty) skinProperty;

                fields.put("borderProperty", new HashMap<>());

                Map<String, Object> properties = fields.get("borderProperty");

                String color = borderProperty.getColor().toString().substring(2);
                properties.put("color", color);

                double radii = borderProperty.getCornerRadii().getBottomLeftHorizontalRadius();
                properties.put("cornerRadii", radii);

                double borderWidths = borderProperty.getBorderWidths().getBottom();
                properties.put("borderWidths", borderWidths);

                Map<String, Object> strokeProperties = new HashMap<>();
                strokeProperties.put("dashArray", borderProperty.getStrokeStyle().getDashArray());
                strokeProperties.put("dashOffset", borderProperty.getStrokeStyle().getDashOffset());
                strokeProperties.put("lineCap", borderProperty.getStrokeStyle().getLineCap());
                strokeProperties.put("lineJoin", borderProperty.getStrokeStyle().getLineJoin());
                strokeProperties.put("miterLimit", borderProperty.getStrokeStyle().getMiterLimit());
                strokeProperties.put("strokeType", borderProperty.getStrokeStyle().getType());
                properties.put("borderStroke", strokeProperties);

            } else if (skinProperty instanceof DefaultNodeContentProperty) {

                DefaultNodeContentProperty contentProperty = (DefaultNodeContentProperty) skinProperty;

                fields.put("contentProperty", new HashMap<>());

                Map<String, Object> properties = fields.get("contentProperty");

                properties.put("minSize", new Tuple<Double, Double>(contentProperty.getTextFiled().getMinWidth()
                        , contentProperty.getTextFiled().getMinHeight()));

                properties.put("prefSize", new Tuple<Double, Double>(contentProperty.getTextFiled().getPrefWidth()
                        , contentProperty.getTextFiled().getPrefHeight()));

                properties.put("layoutPos", new Tuple<Double, Double>(contentProperty.getTextFiled().getLayoutX()
                        , contentProperty.getTextFiled().getLayoutY()));

                properties.put("text", contentProperty.getTextFiled().getText());

                Map<String, Object> background = new HashMap<>();

                String color = contentProperty.getTextFiled().getBackground().getFills().get(0).getFill().toString().substring(2);
                background.put("color", color);

                double radii = contentProperty.getTextFiled().getBorder().getStrokes().get(0).getRadii().getBottomLeftHorizontalRadius();
                background.put("radii", radii);

                fields.put("background", background);

                Map<String, Object> border = new HashMap<>();

                String borderColor = contentProperty.getTextFiled().getBorder().getStrokes().get(0).getBottomStroke().toString().substring(2);
                border.put("color", borderColor);

                double borderRadii = contentProperty.getTextFiled().getBorder().getStrokes().get(0).getRadii().getBottomLeftHorizontalRadius();
                border.put("radii", borderRadii);

                double borderWidth = contentProperty.getTextFiled().getBorder().getStrokes().get(0).getWidths().getBottom();
                border.put("borderWidths", borderWidth);

                Map<String, Object> strokeProperties = new HashMap<>();

                strokeProperties.put("dashArray", contentProperty.getTextFiled().getBorder().getStrokes().get(0).getBottomStyle().getDashArray());
                strokeProperties.put("dashOffset", contentProperty.getTextFiled().getBorder().getStrokes().get(0).getBottomStyle().getDashOffset());
                strokeProperties.put("lineCap", contentProperty.getTextFiled().getBorder().getStrokes().get(0).getBottomStyle().getLineCap());
                strokeProperties.put("lineJoin", contentProperty.getTextFiled().getBorder().getStrokes().get(0).getBottomStyle().getLineJoin());
                strokeProperties.put("miterLimit", contentProperty.getTextFiled().getBorder().getStrokes().get(0).getBottomStyle().getMiterLimit());
                strokeProperties.put("strokeType", contentProperty.getTextFiled().getBorder().getStrokes().get(0).getBottomStyle().getType());

                border.put("borderStroke", strokeProperties);

                fields.put("border", border);

            }
        }
    }

    @Override
    public void load(Tuple<String, Object> item, Field field, Object object) {
        try {
            // field.set(object, Saver.load());
            List<SkinProperty> skinProperties = new ArrayList<>();

            Map<String, Map<String, Object>> fields = (Map<String, Map<String, Object>>) item.item2;

            for (Map.Entry<String, Map<String, Object>> entry : fields.entrySet()) {

                if (entry.getKey().equals("backgroundProperty")) {

                    BackgroundProperty backgroundProperty = new BackgroundProperty();

                    Map<String, Object> backgroundFields = fields.get("backgroundProperty");

                    String color = (String) backgroundFields.get("color");
                    backgroundProperty.setColor(Color.valueOf(color));

                    double radii = (double) backgroundFields.get("cornerRadii");
                    backgroundProperty.setCornerRadii(new CornerRadii(radii));

                    backgroundProperty.setNode((Node) object);

                    skinProperties.add(backgroundProperty);
                } else if (entry.getKey().equals("borderProperty")) {

                    BorderProperty borderProperty = new BorderProperty();

                    Map<String, Object> borderFields = fields.get("borderProperty");

                    String color = (String) borderFields.get("color");
                    borderProperty.setColor(Color.valueOf(color));

                    CornerRadii cornerRadii = new CornerRadii((double) borderFields.get("cornerRadii"));
                    borderProperty.setCornerRadii(cornerRadii);

                    BorderWidths borderWidths = new BorderWidths((double) borderFields.get("borderWidths"));
                    borderProperty.setBorderWidths(borderWidths);

                    Map<String, Object> strokeProperties = (Map<String, Object>) borderFields.get("borderStroke");

                    BorderStrokeStyle borderStrokeStyle = new BorderStrokeStyle((StrokeType) strokeProperties.get("strokeType")
                            , (StrokeLineJoin) strokeProperties.get("lineJoin"), (StrokeLineCap) strokeProperties.get("lineGap"), (double) strokeProperties.get("miterLimit"),
                            (double) strokeProperties.get("dashOffset"), (List<Double>) strokeProperties.get("dashArray"));

                    borderProperty.setStrokeStyle(borderStrokeStyle);
                    borderProperty.setNode((Node) object);
                    borderProperty.setNodeBorder();

                    skinProperties.add(borderProperty);
                } else if (entry.getKey().equals("contentProperty")) {

                    DefaultNodeContentProperty contentProperty = new DefaultNodeContentProperty();

                    TextField textField = new TextField();

                    Map<String, Object> contentFields = fields.get("contentProperty");

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

                    Map<String, Object> background = (Map<String, Object>) fields.get("background");

                    Color backgroundColor = Color.valueOf((String) background.get("color"));
                    CornerRadii backgroundRadii = new CornerRadii((double) background.get("radii"));

                    BackgroundFill backgroundFill = new BackgroundFill(backgroundColor, backgroundRadii, null);
                    textField.setBackground(new Background(backgroundFill));

                    Map<String, Object> border = (Map<String, Object>) fields.get("border");

                    Color borderColor = Color.valueOf((String) border.get("color"));
                    CornerRadii borderRadii = new CornerRadii((double) border.get("radii"));
                    BorderWidths borderWidths = new BorderWidths((double) border.get("borderWidths"));

                    Map<String, Object> strokeStyle = (Map<String, Object>) border.get("borderStroke");

                    BorderStrokeStyle borderStrokeStyle = new BorderStrokeStyle((StrokeType) strokeStyle.get("strokeType")
                            , (StrokeLineJoin) strokeStyle.get("lineJoin"), (StrokeLineCap) strokeStyle.get("lineGap"), (double) strokeStyle.get("miterLimit"),
                            (double) strokeStyle.get("dashOffset"), (List<Double>) strokeStyle.get("dashArray"));

                    BorderStroke borderStroke = new BorderStroke(borderColor, borderStrokeStyle, borderRadii, borderWidths);
                    textField.setBorder(new Border(borderStroke));

                    contentProperty.setTextField(textField);
                    contentProperty.setNode((Node) object);
                    ((Node) object).add(textField);
                    contentProperty.initActions();

                    // think of a way to init the actions of the text field

                    skinProperties.add(contentProperty);
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

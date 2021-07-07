package SaveSystem.Serializer.SkinSerializer.PreviewHelpSerializer;

import Common.GlobalVariables;
import CustomizeMenu.Preview.BoundaryPreview;
import CustomizeMenu.Preview.Preview;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BoundaryPreviewHelpSerializer extends PreviewHelpSerializer {

    public BoundaryPreviewHelpSerializer() {
        super();
    }

    @Override
    public boolean isSuitable(Preview preview) {
        return preview instanceof BoundaryPreview;
    }

    @Override
    public boolean isSuitable(String key) {
        return key.equals("boundaryPreview");
    }

    @Override
    public void save(Preview preview, Map<String, Map<String, Object>> fields) {

        fields.put("boundaryPreview", new LinkedHashMap<>());

        Map<String, Object> boundary = fields.get("boundaryPreview");

        BoundaryPreview boundaryPreview = (BoundaryPreview) preview;

        Rectangle previewRectangle = boundaryPreview.getPreview();

        boundary.put("color", previewRectangle.getFill().toString().substring(2));
        boundary.put("radii", List.of(previewRectangle.getArcWidth(), previewRectangle.getArcHeight()));
        boundary.put("borderColor", previewRectangle.getStroke().toString().substring(2));
        boundary.put("borderWidth", previewRectangle.getStrokeWidth());
        List<Double> dash = previewRectangle.getStrokeDashArray();
        List<Double> dashArray = new ArrayList<>(dash);
        boundary.put("dashArray", dashArray);
        boundary.put("strokeLineGap", previewRectangle.getStrokeLineCap().toString());
    }

    @Override
    public Preview load(Map<String, Map<String, Object>> fields) {

        BoundaryPreview boundaryPreview = new BoundaryPreview();

        Map<String, Object> properties = fields.get("boundaryPreview");

        boundaryPreview.getPreview().setFill(Color.valueOf((String) properties.get("color")));
        boundaryPreview.getPreview().setStroke(Color.valueOf((String) properties.get("borderColor")));
        boundaryPreview.getPreview().setArcWidth(((List<Double>) properties.get("radii")).get(0));
        boundaryPreview.getPreview().setArcHeight(((List<Double>) properties.get("radii")).get(1));
        boundaryPreview.getPreview().setStrokeWidth((double) properties.get("borderWidth"));
        boundaryPreview.getPreview().getStrokeDashArray().addAll((List<Double>) properties.get("dashArray"));
        boundaryPreview.getPreview().setStrokeLineCap(StrokeLineCap.valueOf((String) properties.get("strokeLineGap")));

        return boundaryPreview;
    }

    @Override
    public String getKey() {
        return GlobalVariables.BOUNDARY_PREVIEW_TAG;
    }
}

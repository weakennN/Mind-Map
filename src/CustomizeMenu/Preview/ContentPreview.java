package CustomizeMenu.Preview;

import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ContentPreview extends Preview {

    private TextField textField;

    public ContentPreview() {

        this.init();
    }

    @Override
    public void init() {

        this.textField = new TextField("Example Text");
        this.textField.getStylesheets().add("Style/DefaultNodeContentProperty.css");
        this.textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(25), BorderWidths.DEFAULT)));
        this.textField.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(25), null)));
      /*  this.textField.setEditable(false);
        this.textField.setDisable(true);
        
       */

        super.getChildren().addAll(this.textField);
    }

    @Override
    public Preview copy() {

        ContentPreview contentPreview = new ContentPreview();
        BackgroundFill backgroundFill = this.textField.getBackground().getFills().get(0);
        contentPreview.textField.setBackground(new Background(new BackgroundFill(backgroundFill.getFill(), backgroundFill.getRadii(), backgroundFill.getInsets())));
        BorderStroke borderStroke = this.textField.getBorder().getStrokes().get(0);
        contentPreview.textField.setBorder(new Border(new BorderStroke(borderStroke.getBottomStroke(), borderStroke.getLeftStyle(), borderStroke.getRadii(), borderStroke.getWidths())));

        return contentPreview;
    }

    public TextField getTextField() {
        return this.textField;
    }
}

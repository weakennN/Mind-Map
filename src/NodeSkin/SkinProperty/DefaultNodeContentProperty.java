package NodeSkin.SkinProperty;

import Nodes.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public abstract class DefaultNodeContentProperty extends SkinProperty {

    private TextField textField;

    public DefaultNodeContentProperty(Node node) {
        super(node);
    }

    @Override
    public void init() {

        this.textField = new TextField();
        this.textField.getStylesheets().add("Style/DefaultNodeContentProperty.css");
        this.textField.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(25), BorderWidths.DEFAULT)));
        this.textField.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(25), null)));
        this.textField.requestFocus();

        this.initActions();

        super.getNode().add(this.textField);
    }

    private void initActions() {

        this.textField.setOnKeyTyped(e -> {

            double width = 30;

            for (int i = 0; i < this.textField.getText().length(); i++) {

                Text text = new Text(this.textField.getText().charAt(i) + "");
                text.setFont(this.textField.getFont());
                width += text.getBoundsInLocal().getWidth();
            }

            Text text = new Text(e.getCharacter().charAt(0) + "");
            text.setFont(this.textField.getFont());

            this.textField.setPrefWidth(width);
            super.getNode().setMinWidth(super.getNode().getDefaultWidth() + (width - 30));
            super.getNode().setSize(super.getNode().getMinWidth(), super.getNode().getMinHeight());
        });
    }

    public void changeBackground(Color color) {
        BackgroundFill backgroundFill = this.textField.getBackground().getFills().get(0);
        this.textField.setBackground(new Background(new BackgroundFill(color, backgroundFill.getRadii(), backgroundFill.getInsets())));
    }

    public void changeBorder(Color color) {
        BorderStroke borderStroke = this.textField.getBorder().getStrokes().get(0);
        this.textField.setBorder(new Border(new BorderStroke(color, borderStroke.getLeftStyle(), borderStroke.getRadii(), borderStroke.getWidths())));
    }

    public void changeBorder(CornerRadii cornerRadii) {
        BorderStroke borderStroke = this.textField.getBorder().getStrokes().get(0);
        this.textField.setBorder(new Border(new BorderStroke(borderStroke.getBottomStroke(), borderStroke.getLeftStyle(), cornerRadii, borderStroke.getWidths())));
        BackgroundFill backgroundFill = this.textField.getBackground().getFills().get(0);
        this.textField.setBackground(new Background(new BackgroundFill(backgroundFill.getFill(), cornerRadii, backgroundFill.getInsets())));
    }

    public void changeBorder(BorderWidths borderWidths) {
        BorderStroke borderStroke = this.textField.getBorder().getStrokes().get(0);
        this.textField.setBorder(new Border(new BorderStroke(borderStroke.getBottomStroke(), borderStroke.getLeftStyle(), borderStroke.getRadii(), borderWidths)));
    }

    protected TextField getTextField() {
        return this.textField;
    }

    public TextField getTextFiled() {
        return this.textField;
    }

}

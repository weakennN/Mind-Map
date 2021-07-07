package SaveSystem;

import UI.UI;
import UIControls.MenuButton;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class AlertBox extends Region {

    private UI ui;
    private Label label;
    private MenuButton yesButton;
    private MenuButton noButton;
    private Scene scene;
    private Stage stage;
    private HBox buttonHBox;
    private Pane pane;
    private SaveSystem saveSystem;

    public AlertBox(UI ui, SaveSystem saveSystem) {
        this.ui = ui;
        this.saveSystem = saveSystem;
        this.init();
    }

    private void init() {

        this.pane = new Pane();
        this.pane.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));

        this.label = new Label("Would you like to save before exiting ?");
        this.label.setPadding(new Insets(0, 0, 0, 5));
        this.label.setFont(Font.font("Arial", FontPosture.REGULAR, 23));
        this.label.setTextAlignment(TextAlignment.CENTER);

        this.initButtons();

        this.pane.getChildren().addAll(this.buttonHBox, this.label);

        this.scene = new Scene(pane, 400, 200);

        this.stage = new Stage();
        this.stage.setScene(this.scene);
        this.stage.setMinWidth(400);
        this.stage.setMinHeight(200);
        this.stage.setResizable(false);
        this.stage.initModality(Modality.APPLICATION_MODAL);

        this.ui.getStage().setOnCloseRequest(e -> {
            this.stage.show();
            e.consume();
        });
    }

    private void initButtons() {

        this.buttonHBox = new HBox(10);

        this.yesButton = new MenuButton();
        this.noButton = new MenuButton();
        this.yesButton.setText("Yes");
        this.noButton.setText("No");

        List<MenuButton> buttons = List.of(this.yesButton, this.noButton);

        for (MenuButton button : buttons) {

            button.setMinWidth(70);
            button.setFont(Font.font("Arial", FontPosture.REGULAR, 16));
            button.setBorder(null);
            button.setFill(Color.valueOf("0795ed"));
            button.setTextFill(Color.WHITE);
            this.buttonHBox.getChildren().add(button);
        }

        yesButton.setOnAction(e -> {
            this.saveSystem.save();
            this.ui.getStage().close();
            this.stage.close();
        });

        noButton.setOnAction(e -> {
            this.ui.getStage().close();
            this.stage.close();
        });

        this.buttonHBox.setLayoutX(240);
        this.buttonHBox.setLayoutY(150);
    }
}

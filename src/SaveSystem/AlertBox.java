package SaveSystem;

import UI.UI;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox extends Region {

    private UI ui;
    private SaveSystem saveSystem;

    public AlertBox(UI ui, SaveSystem saveSystem) {
        this.ui = ui;
        this.saveSystem = saveSystem;
        this.init();
    }

    private void init() {

        Pane pane = new Pane();

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        HBox buttonHBox = new HBox(10);
        buttonHBox.getChildren().addAll(yesButton, noButton);
        buttonHBox.setLayoutY(350);
        buttonHBox.setLayoutX(220);

        pane.getChildren().addAll(buttonHBox);

        Scene scene = new Scene(pane, 300, 400);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setMinWidth(300);
        stage.setMinHeight(400);
        stage.initModality(Modality.APPLICATION_MODAL);

        yesButton.setOnAction(e -> {
            this.saveSystem.save();
            this.ui.getStage().close();
            stage.close();
        });

        this.ui.getStage().setOnCloseRequest(e -> {
            stage.show();
            e.consume();
        });
    }
}

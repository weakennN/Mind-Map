import Core.App;
import UI.UI;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.UUID;

public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        UI ui = new UI();
        App app = new App(ui);
        app.start();
        stage = ui.getStage();
        stage.setMaximized(true);
        stage.setTitle("Mind Map");
        stage.show();
    }
}

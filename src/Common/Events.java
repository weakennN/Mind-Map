package Common;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.robot.Robot;

public class Events {

    public static void move(TextField textField) {

        EventHandler<MouseEvent> event = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                Robot robot = new Robot();

                textField.setLayoutX(robot.getMouseX() - 20);
                textField.setLayoutY(robot.getMouseY() - 20);
            }
        };


        textField.setOnMouseDragged(event);
    }
}

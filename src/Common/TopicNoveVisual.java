package Common;

import Nodes.TopicNode;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class TopicNoveVisual extends TextField {

    public TopicNoveVisual(){
        super.setOnMouseEntered(e -> {

            System.out.println("11");
        });
    }
}

package Camera;

import Common.GlobalMethods;
import Core.MindMap;
import Nodes.Connection;
import Nodes.Node;
import javafx.scene.PerspectiveCamera;
import mikera.vectorz.Vector2;

import java.util.List;

public class Camera extends PerspectiveCamera {

    private MindMap mindMap;
    private Vector2 pos;

    public Camera(MindMap mindMap) {
        super();

        this.mindMap = mindMap;
        this.pos = new Vector2(0, 0);
        super.setLayoutX(0);
        super.setLayoutY(0);
    }

    public void translate(double mouseX, double mouseY) {

        double velX = 0;
        double velY = 0;

        if (mouseX < this.pos.x) {
            velX = 2;
        } else if (mouseX > this.pos.x) {
            velX = -2;
        } else if (mouseY < this.pos.y) {
            velY = 2;
        } else if (mouseY > this.pos.y) {
            velY = -2;
        }

        this.pos.x = mouseX;
        this.pos.y = mouseY;

       /* super.setLayoutX(super.getLayoutX() + velX);
        super.setLayoutY(super.getLayoutY() + velY);
        this.mindMap.setLayoutX(super.getLayoutX());
        this.mindMap.setLayoutY(super.getLayoutY());
    
        */

        List<Node> nodes = this.mindMap.getNodes();

        for (int i = 0; i < nodes.size(); i++) {

            Node node = nodes.get(i);
            node.setLayoutX(node.getLayoutX() - velX);
            node.setLayoutY(node.getLayoutY() - velY);

            List<Connection> connections = node.getConnections();

            GlobalMethods.moveConnections(connections, node);
        }
    }
}

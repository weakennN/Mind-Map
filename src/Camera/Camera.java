package Camera;

import Core.MindMap;
import javafx.scene.PerspectiveCamera;
import mikera.vectorz.Vector2;

public class Camera extends PerspectiveCamera {

    private MindMap mindMap;
    private Vector2 pos;

    public Camera(MindMap mindMap) {
        super(true);

        this.mindMap = mindMap;
        this.pos = new Vector2(0, 0);
        super.setLayoutX(1);
        super.setLayoutY(10);
    }

    public void translate(double mouseX, double mouseY) {

        int velX = 1;
        int velY = 1;

        if (this.pos.x > mouseX) {
            velX = -1;
        } else if (this.pos.y > mouseY) {
            velY = -1;
        }

        this.pos.x = mouseX;
        this.pos.y = mouseY;
        super.setLayoutX(this.pos.x + velX);
        super.setLayoutY(this.pos.y + velY);
    }
}

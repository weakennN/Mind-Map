package NodeCreator;

import UI.UI;

public abstract class NodeCreator {

    private UI ui;

    public NodeCreator(UI ui) {

        this.ui = ui;
    }

    public abstract void createNode(double posX, double posY);

    public UI getUi() {
        return this.ui;
    }
}

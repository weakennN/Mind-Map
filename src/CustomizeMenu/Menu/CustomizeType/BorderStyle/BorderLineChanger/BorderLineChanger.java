package CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger;

import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderChanger;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.BorderLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.DottedLine;
import CustomizeMenu.Menu.CustomizeType.BorderStyle.BorderLineChanger.Options.SolidLine;
import CustomizeMenu.Preview.Preview;
import Nodes.Node;
import NodeSkin.SkinProperty.BorderProperty;

public abstract class BorderLineChanger extends BorderChanger {

    public BorderLineChanger(Preview preview) {
        super(preview);
    }

    @Override
    protected void init() {

        super.init();
    }
}

package CustomizeMenu.Preview;

import javafx.geometry.Orientation;
import javafx.scene.layout.Region;

public abstract class Preview extends Region implements Cloneable{

    public Preview() {

    }

    public abstract void init();

    @Override
    protected double computePrefHeight(double width) {
        return 90;
    }

    @Override
    protected double computePrefWidth(double height) {
        return 60;
    }

    @Override
    public Orientation getContentBias() {
        return Orientation.HORIZONTAL;
    }
}

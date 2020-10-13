package model;

import java.awt.*;

public class GreenCell implements Cell {
    public static final GreenCell instance = new GreenCell();

    private GreenCell(){}

    public static GreenCell getInstance() {
        return instance;
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public Cell process(int energy) {
        return energy < -7 ? GreenCell.getInstance() : ClearCell.getInstance();
    }

    @Override
    public int getEnergy() {
        return -7;
    }
}

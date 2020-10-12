package model;

import java.awt.*;

public class RedCell implements Cell {
    public static final RedCell instance = new RedCell();

    private RedCell(){}

    public static RedCell getInstance() {
        return instance;
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public Cell process(int energy) {
        return null;
    }

    @Override
    public int getEnergy() {
        return 3;
    }
}

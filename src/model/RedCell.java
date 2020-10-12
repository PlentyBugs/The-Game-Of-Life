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
        return energy % 3 == 0 ? WhiteCell.getInstance() : energy % 11 < 9 ? RedCell.getInstance() : ClearCell.getInstance();
    }

    @Override
    public int getEnergy() {
        return 3;
    }
}

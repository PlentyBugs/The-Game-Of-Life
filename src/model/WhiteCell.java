package model;

import java.awt.*;

public class WhiteCell implements Cell {
    public static final WhiteCell instance = new WhiteCell();

    private WhiteCell(){}

    public static WhiteCell getInstance() {
        return instance;
    }

    @Override
    public Color getColor() {
        return Color.WHITE;
    }

    @Override
    public Cell process(int energy) {
        return (energy == 2 || energy == 3) ? getInstance() : energy > 9 ? YellowCell.getInstance() : ClearCell.getInstance();
    }

    @Override
    public int getEnergy() {
        return 1;
    }
}

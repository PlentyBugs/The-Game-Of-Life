package model;

import java.awt.*;

public class YellowCell implements Cell {
    public static final YellowCell instance = new YellowCell();

    private YellowCell(){}

    public static YellowCell getInstance() {
        return instance;
    }

    @Override
    public Color getColor() {
        return Color.YELLOW;
    }

    @Override
    public Cell process(int energy) {
        return energy < 4 ? WhiteCell.getInstance(): energy % 5 == 0 ? RedCell.getInstance(): ClearCell.getInstance();
    }

    @Override
    public int getEnergy() {
        return 4;
    }
}

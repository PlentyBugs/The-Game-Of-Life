package model;

import java.awt.*;

public class ClearCell implements Cell {
    public static final ClearCell instance = new ClearCell();

    private ClearCell(){}

    public static ClearCell getInstance() {
        return instance;
    }

    @Override
    public Color getColor() {
        return Color.BLACK;
    }

    @Override
    public Cell process(int energy) {
        return energy == 3 ? WhiteCell.getInstance() : energy == 6 ? YellowCell.getInstance() : energy % 10 > 8 ? RedCell.getInstance(): energy % 9 == 2 ? GreenCell.getInstance(): getInstance();
    }

    @Override
    public int getEnergy() {
        return 0;
    }
}

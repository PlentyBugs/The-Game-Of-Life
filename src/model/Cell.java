package model;

import java.awt.Color;

public interface Cell {
    Color getColor();
    Cell process(int energy);
    int getEnergy();

    static int countNeighbours(Cell ... cells) {
        int count = 0;
        for (Cell cell : cells) count += cell.getEnergy();
        return count;
    }
}

package processor;

import model.Cell;
import model.ClearCell;

import javax.swing.*;

public class LifeProcessor {

    private final JPanel panel;
    private final Cell[][] field;
    private boolean active;
    private int speed;

    public LifeProcessor(JPanel panel, Cell[][] field) {
        this.panel = panel;
        this.field = field;
        active = false;
        speed = 5;
    }

    public void run() {
        int hC = field.length;
        int wC = field[0].length;
        Cell[][] newField = new Cell[hC][wC];
        for (int i = 0; i < hC; i++)
            for (int j = 0; j < wC; j++)
                newField[i][j] = ClearCell.getInstance();

        while (true) {
            synchronized (this) {
                try {
                    wait(1000 / speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (active) {
                for (int y = 0; y < hC; y++) {
                    for (int x = 0; x < wC; x++) {
                        int energy = Cell.countNeighbours(
                                field[y > 0 ? y - 1: hC - 1][x],
                                field[y][x > 0 ? x - 1: wC - 1],
                                field[y < hC - 1 ? y + 1: 0][x],
                                field[y][x < wC - 1 ? x + 1: 0],
                                field[y > 0 ? y - 1: hC - 1][x > 0 ? x - 1: wC - 1],
                                field[y > 0 ? y - 1: hC - 1][x < wC - 1 ? x + 1: 0],
                                field[y < hC - 1 ? y + 1: 0][x > 0 ? x - 1: wC - 1],
                                field[y < hC - 1 ? y + 1: 0][x < wC - 1 ? x + 1: 0]
                        );
                        newField[y][x] = field[y][x].process(energy);
                    }
                }

                for (int i = 0; i < hC; i++)
                    System.arraycopy(newField[i], 0, field[i], 0, wC);

                panel.repaint();
                panel.revalidate();
            }
        }
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setSpeed(int speed) {
        this.speed = Math.max(speed, 1);
    }
}

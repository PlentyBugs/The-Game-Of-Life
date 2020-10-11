package processor;

import javax.swing.*;

public class LifeProcessor {

    private final JPanel panel;
    private final int[][] field;
    private boolean active;
    private int speed;

    public LifeProcessor(JPanel panel, int[][] field) {
        this.panel = panel;
        this.field = field;
        active = false;
        speed = 5;
    }

    public void run() {
        int hC = field.length;
        int wC = field[0].length;
        int[][] newField = new int[hC][wC];

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
                        int z = field[y][x];
                        int neighboursCount =
                                field[y > 0 ? y - 1: hC - 1][x] +
                                field[y][x > 0 ? x - 1: wC - 1] +
                                field[y < hC - 1 ? y + 1: 0][x] +
                                field[y][x < wC - 1 ? x + 1: 0] +
                                field[y > 0 ? y - 1: hC - 1][x > 0 ? x - 1: wC - 1] +
                                field[y > 0 ? y - 1: hC - 1][x < wC - 1 ? x + 1: 0] +
                                field[y < hC - 1 ? y + 1: 0][x > 0 ? x - 1: wC - 1] +
                                field[y < hC - 1 ? y + 1: 0][x < wC - 1 ? x + 1: 0];
                        if (z == 1 && (neighboursCount == 2 || neighboursCount == 3) || z == 0 && neighboursCount == 3 || z == 2 && (neighboursCount < 4)) {
                            newField[y][x] = 1;
                        } else if (z == 0 && neighboursCount == 6 || z == 1 && neighboursCount > 9) {
                            newField[y][x] = 2;
                        } else {
                            newField[y][x] = 0;
                        }
                    }
                }
                for (int i = 0; i < hC; i++) {
                    System.arraycopy(newField[i], 0, field[i], 0, wC);
                }
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

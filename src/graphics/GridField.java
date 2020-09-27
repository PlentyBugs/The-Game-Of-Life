package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;

public class GridField extends JPanel implements MouseListener, MouseMotionListener {

    private final int width;
    private final int height;
    private final int[][] field;
    private final int size;

    public GridField(int width, int height, int[][] field, int size) {
        this.width = width;
        this.height = height;
        this.field = field;
        this.size = size;

        Dimension dimension = new Dimension(width, height);
        setPreferredSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int hC = field.length;
        int wC = field[0].length;
        Graphics2D graphics2D = (Graphics2D) g;

        for (int y = 0; y < hC; y++) {
            for (int x = 0; x < wC; x++) {
                if (field[y][x] == 0) {
                    graphics2D.setColor(Color.BLACK);
                } else {
                    graphics2D.setColor(Color.WHITE);
                }
                Rectangle2D.Double rect = new Rectangle2D.Double(x * size, y * size, size, size);
                graphics2D.fill(rect);
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mousePaint(e);
    }

    private void mousePaint(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x < width && y < height && x > 0 && y > 0) {
            field[y / size][x / size] = 1;
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePaint(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}

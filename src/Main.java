import graphics.GridField;
import graphics.Window;
import model.Cell;
import model.ClearCell;
import processor.LifeProcessor;

public class Main {

    private static final int WIDTH = 720;
    private static final int HEIGHT = 720;
    private static final int SIZE = 8;

    public static void main(String[] args) {
        Cell[][] field = new Cell[HEIGHT / SIZE][WIDTH / SIZE];
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[i].length; j++)
                field[i][j] = ClearCell.getInstance();

        GridField gridField = new GridField(WIDTH, HEIGHT, field, SIZE);

        LifeProcessor processor = new LifeProcessor(gridField, field);

        new Window("Life", gridField, processor);

        processor.run();
    }
}

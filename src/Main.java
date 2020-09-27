import graphics.GridField;
import graphics.Window;
import processor.LifeProcessor;

public class Main {

    private static final int WIDTH = 720;
    private static final int HEIGHT = 720;
    private static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] field = new int[HEIGHT / SIZE][WIDTH / SIZE];

        GridField gridField = new GridField(WIDTH, HEIGHT, field, SIZE);

        LifeProcessor processor = new LifeProcessor(gridField, field);

        new Window("Life", gridField, processor);

        processor.run();
    }
}

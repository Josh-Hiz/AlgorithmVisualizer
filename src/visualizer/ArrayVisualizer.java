package visualizer;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;

import javax.swing.*;
import java.util.*;

public class ArrayVisualizer extends JPanel {

    private static final long serialVersionUID = 1L;

    private ShellSort shellSort = new ShellSort();
    private InsertionSort insertionSort = new InsertionSort();
    private SelectionSort selectionSort = new SelectionSort();
    private BubbleSort bubbleSort = new BubbleSort();
    private GnomeSort gnomeSort = new GnomeSort();
    private BrickSort brickSort = new BrickSort();

    protected static int[] array;
    private final int[] barColors;


    private final int REC_WIDTH = 10; //1980 rectangles
    private final int NUMBER_OF_RECS = Window.WINDOW_WIDTH / REC_WIDTH;

    public ArrayVisualizer() {
        setBackground(Color.black);
        array = new int[NUMBER_OF_RECS];
        barColors = new int[NUMBER_OF_RECS];
        generateRandom(array);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g.create();
        graphics.setColor(Color.orange);
        for(int i = 0; i < NUMBER_OF_RECS; i++) {

            int height = array[i] * 4; //Done for scaling
            int recX = i + (REC_WIDTH - 1) * i; //Read fillRect documentation
            int recY = Window.WINDOW_HEIGHT - height; //Read fillRect documentation


            graphics.fillRect(recX, recY, REC_WIDTH, height);


        }
    }


    //This will return the Dimension of the actual rectangles. i.e the rectangles will only exist when this exists, almost like a canvas in javascript
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
    }

    //Creates a random unsorted array with numbers 1-200
    protected void generateRandom(int[] array) {
        Random number = new Random();
        for(int i = 0; i < NUMBER_OF_RECS; i++) {
            array[i] = number.nextInt(100);
        }
    }

    protected void shuffle(int[] array) {
        generateRandom(array);
    }

    protected void sort(int[] array) {
        selectionSort.sortWithDelay(array);
    }
}

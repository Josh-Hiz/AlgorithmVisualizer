package visualizer;

import java.awt.Color;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.JMenu;

public class Window implements ActionListener {

    //Window width
    protected static int WINDOW_WIDTH = 1440;
    //Window height
    protected static int WINDOW_HEIGHT = 700;

    //This will draw all our rectangles
    protected static ArrayVisualizer arrayVisualizer;

    //Add a Logo
    ImageIcon logo = new ImageIcon("/AlgorithmVisualizer/src/resources/java.png");

    //Make a new JFrame
    JFrame window = new JFrame();

    //Shuffle button
    JButton shuffleBut = new JButton("Shuffle");

    //Start sorting button
    JButton startSort = new JButton("Start Sorting");

    JMenu algoMenu;
    JMenuBar algoBar;

    public Window() {
        initWindow();
    }

    private void addButtons() {

        //Shuffle Button
        shuffleBut.setBounds(100, 50, 100, 100);
        shuffleBut.setBackground(Color.white);
        shuffleBut.addActionListener(this);

        startSort.setBounds(500, 50, 100, 100);;
        startSort.setBackground(Color.white);

        window.add(shuffleBut);
        window.add(startSort);

    }

    //A method to add a more concise menu rather than bugged out buttons
    //This will also add action listeners
    private void addMenu() {

        algoMenu = new JMenu("Algorithms");
        algoBar = new JMenuBar();

        JMenuItem insertionSort = new JMenuItem("Insertion Sort");
        JMenuItem selectionSort = new JMenuItem("Selection Sort");

        algoMenu.add(insertionSort);
        algoMenu.add(selectionSort);

        algoBar.add(algoMenu);

        window.setJMenuBar(algoBar);

//		insertionSort.addActionListener(	);
//		selectionSort.addActionListener(	);
    }

    private void initWindow() {

        window = new JFrame();
        window.setIconImage(logo.getImage());
        window.setTitle("JAlgorithms");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        addButtons();
        addMenu();

        startSort.addActionListener(taskPerformer);

        arrayVisualizer = new ArrayVisualizer();
        window.add(arrayVisualizer);
        arrayVisualizer.repaint(); //Will call paint component method

        window.pack();
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == shuffleBut) {
            arrayVisualizer.shuffle(ArrayVisualizer.array);
            arrayVisualizer.repaint();
        }
    }

    ActionListener menuListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {

        }
    };

    ActionListener taskPerformer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == startSort) {
                if(!timer.isRunning()) { //If timer is not running
                    timer.setInitialDelay(0); //Set initial delay
                    timer.start();	//Start the timer
                }
            }
        }
    };

    ActionListener sortWithDelay = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(sorted(ArrayVisualizer.array)) { //If it is sorted
                timer.stop();	//Stop the timer
                return;
            } else {
                arrayVisualizer.sort(ArrayVisualizer.array); //If it is not sorted continue the sort
                arrayVisualizer.repaint();	//Called after each swap
            }

        }
    };

    private int delay = 100; //Milliseconds
    private Timer timer = new Timer(delay, sortWithDelay);

    private boolean sorted(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }
}

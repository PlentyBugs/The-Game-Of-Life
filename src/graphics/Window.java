package graphics;

import processor.LifeProcessor;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(String name, JPanel panel, LifeProcessor processor) {
        super(name);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.NORTH);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 4));

        JButton stopButton = new JButton("Stop");
        JButton runButton = new JButton("Run");
        stopButton.addActionListener(e -> processor.setActive(false));
        runButton.addActionListener(e -> processor.setActive(true));

        JSlider slider = new JSlider(1, 20, 5);
        slider.addChangeListener(e -> processor.setSpeed(slider.getValue()));

        controlPanel.add(stopButton);
        controlPanel.add(runButton);
        controlPanel.add(slider);

        getContentPane().add(controlPanel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
}

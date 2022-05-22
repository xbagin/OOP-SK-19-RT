package sk.stuba.fei.uim.oop.app.gui;

import sk.stuba.fei.uim.oop.app.logic.Modes;
import sk.stuba.fei.uim.oop.app.shapes.Colors;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class App {
    public App() {
        JFrame frame = new JFrame("OOP-SK-19-RT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());


        MyPanel canvas = new MyPanel(Colors.RED.getColor());

        JPanel topPanel = new JPanel(new GridLayout(1, 4));
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        MyButton plus = new MyButton("PLUS", canvas.getHandler());
        MyButton ring = new MyButton("RING", canvas.getHandler());
        MyButton line = new MyButton("LINE", canvas.getHandler());
        MyButton colorChange = new MyButton("COLOR", canvas.getHandler());

        JComboBox<String> color = new JComboBox<>(Arrays.stream(Colors.values()).map(Colors::name).toArray(String[]::new)/*new String[]{"RED", "GREEN", "BLUE"}*/);
        color.addItemListener(canvas.getHandler());
        color.setFocusable(false);

        topPanel.add(plus);
        topPanel.add(ring);
        topPanel.add(line);
        topPanel.add(colorChange);

        bottomPanel.add(color);
        bottomPanel.add(canvas.getHandler().getLabel());

        frame.add(topPanel, BorderLayout.PAGE_START);
        frame.add(canvas, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }
}

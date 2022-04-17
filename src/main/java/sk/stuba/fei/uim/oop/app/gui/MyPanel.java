package sk.stuba.fei.uim.oop.app.gui;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.app.logic.EventHandler;
import sk.stuba.fei.uim.oop.app.shapes.MyShape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MyPanel extends JPanel {
    EventHandler handler;
    List<MyShape> shapes;
    @Setter
    MyShape shape;

    public MyPanel(Color color) {
        super();
        this.handler = new EventHandler(this, color);
        this.shapes = new ArrayList<>();
        this.shape = null;
        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
    }

    public void addShape() {
        this.shapes.add(this.getShape());
        this.shape = null;
    }

    public MyShape getMostFrontShape(int x, int y) {
        MyShape frontShape = null;
        for(MyShape shape : this.shapes) {
            if (shape.isInCoordinate(x, y)) {
                frontShape = shape;
            }
        }
        return frontShape;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.shapes.forEach(shape -> shape.draw(g));
        if (this.shape != null) {
            this.shape.draw(g);
        }
    }
}

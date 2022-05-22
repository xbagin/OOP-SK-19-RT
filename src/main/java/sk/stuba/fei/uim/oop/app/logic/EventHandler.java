package sk.stuba.fei.uim.oop.app.logic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.app.gui.MyPanel;
import sk.stuba.fei.uim.oop.app.shapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Locale;
import java.util.Objects;

public class EventHandler extends MouseAdapter implements ActionListener, ItemListener {
    @Getter
    private final JLabel label;
    private final MyPanel canvas;
    private Color color;
    private String mode;
    private int originX;
    private int originY;

    public EventHandler(MyPanel canvas, Color color) {
        super();
        this.canvas = canvas;
        this.label = new JLabel();
        this.label.setOpaque(true);
        this.color = color;
        this.label.setBackground(this.color);
        this.mode = "";
        this.originX = 0;
        this.originY = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.mode = e.getActionCommand();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            this.color = Colors.valueOf((String) e.getItem()).getColor();
            this.label.setBackground(this.color);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.modeIs(Modes.COLOR)) {
            MyShape shape = this.canvas.getMostFrontShape(e.getX(), e.getY());
            if (shape != null) {
                shape.setColor(this.color);
                this.canvas.repaint();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (this.modeIs(Modes.PLUS)){
            this.canvas.setShape(new Plus(e.getX(), e.getY(), this.color, this.canvas));
        } else if (this.modeIs(Modes.RING)) {
            this.canvas.setShape(new Ring(e.getX(), e.getY(), this.color, this.canvas));
        } else if (this.modeIs(Modes.LINE)) {
            this.canvas.setShape(new Line(e.getX(), e.getY(), this.color, this.canvas));
        }
        this.originX = e.getX();
        this.originY = e.getY();
        this.canvas.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.modeIsShapeKind()) {
            this.canvas.addShape();
            this.canvas.repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (this.modeIsShapeKind()) {
            MyShape shape = this.canvas.getShape();
            shape.resize(this.originX, this.originY, e.getX(), e.getY());
            this.canvas.repaint();
        }
    }

    private boolean modeIs(Modes mode) {
        //return Objects.equals(this.mode, mode);
        try {
            return Objects.equals(Modes.valueOf(this.mode.toUpperCase(Locale.ROOT)), mode);
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean modeIsShapeKind() {
        try {
            return Modes.valueOf(this.mode.toUpperCase(Locale.ROOT)).isShapeKind();
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}

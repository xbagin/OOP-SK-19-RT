package sk.stuba.fei.uim.oop.app.gui;

import sk.stuba.fei.uim.oop.app.logic.EventHandler;

import javax.swing.*;

public class MyButton extends JButton {
    public MyButton(String title, EventHandler handler) {
        super(title);
        this.addActionListener(handler);
        this.setFocusable(false);
    }
}

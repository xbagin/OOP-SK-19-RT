package sk.stuba.fei.uim.oop.app.shapes;

import sk.stuba.fei.uim.oop.app.gui.MyPanel;

import java.awt.*;

public class Plus extends MyShape {
    public Plus(int x, int y, Color color, MyPanel canvas) {
        super(x, y, color, canvas);
    }

    @Override
    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(this.color);
        g.fillRect(this.x + this.size / 3, this.y,this.size / 3, this.size);
        g.fillRect(this.x, this.y + this.size / 3, this.size, this.size / 3);
        g.setColor(c);
    }
}

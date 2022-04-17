package sk.stuba.fei.uim.oop.app.shapes;

import sk.stuba.fei.uim.oop.app.gui.MyPanel;

import java.awt.*;

public class Ring extends MyShape {
    public Ring(int x, int y, Color color, MyPanel canvas) {
        super(x, y, color, canvas);
    }

    @Override
    public void draw(Graphics g) {
        Color clr = g.getColor();
        g.setColor(this.color);
        g.fillOval(this.x, this.y, this.size, this.size);
        g.setColor(super.getCanvas().getBackground());
        g.fillOval(this.x + this.size / 3, this.y + this.size / 3, this.size / 3, this.size / 3);
        g.setColor(clr);
    }
}

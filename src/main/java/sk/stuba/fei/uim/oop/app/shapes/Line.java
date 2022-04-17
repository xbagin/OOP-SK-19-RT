package sk.stuba.fei.uim.oop.app.shapes;

import sk.stuba.fei.uim.oop.app.gui.MyPanel;

import java.awt.*;

public class Line extends MyShape {
    private final int x0;
    private final int y0;
    private int x2;
    private int y2;

    public Line(int x, int y, Color color, MyPanel canvas) {
        super(x, y, color, canvas);
        this.x0 = x;
        this.y0 = y;
        this.x2 = x;
        this.y2 = y;
    }

    @Override
    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(this.color);
        g.drawLine(this.x0, this.y0, this.x2, this.y2);
        g.setColor(c);
    }

    @Override
    public void resize(int x0, int y0, int x, int y) {
        super.resize(x0, y0, x, y);
        this.x2 = x;
        this.y2 = y;
    }

    @Override
    public boolean isInCoordinate(int x, int y) {
        if (this.x2 - this.x0 == 0) {
            return super.isInCoordinate(x, y) && Math.abs(this.x - x) < 5 &&
                    y >= Math.min(this.y0, this.y2) && y <= Math.max(this.y2, this.y0);
        }
        if (this.y2 - this.y0 == 0) {
            return super.isInCoordinate(x, y) && Math.abs(this.y - y) < 5 &&
                    x >= Math.min(this.x0, this.x2) && x <= Math.max(this.x2, this.x0);
        }
        // y = k * x + q
        double k = (double) (this.y2 - this.y0) / (this.x2 - this.x0);
        double q = this.y0 - k * this.x0;
        // ax + by + c = 0
        // abs(aX + bY + c) / sqrt(a*a + b*b)
        double d = Math.abs(k * x - y + q) / Math.sqrt(k * k + 1);
        return super.isInCoordinate(x, y) && d < 10.;

    }
}

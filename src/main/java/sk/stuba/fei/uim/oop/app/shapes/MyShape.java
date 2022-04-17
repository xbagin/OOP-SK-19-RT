package sk.stuba.fei.uim.oop.app.shapes;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.app.gui.MyPanel;

import java.awt.*;

@Getter
@Setter
public abstract class MyShape implements Drawable {
    protected int x;
    protected int y;
    protected int size;
    protected Color color;
    @Getter
    private final MyPanel canvas;

    public MyShape(int x, int y, Color color, MyPanel canvas) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.canvas = canvas;
        this.size = 0;
    }

    public void resize(int x0, int y0, int x, int y) {
        int orientedSizeX = x - x0;
        int orientedSizeY = y - y0;
        this.size = Math.max(Math.abs(orientedSizeX), Math.abs(orientedSizeY));
        this.x = Math.min(x0, x0 + (orientedSizeX < 0 ? -1 : 1) * this.size);
        this.y = Math.min(y0, y0 + (orientedSizeY < 0 ? -1 : 1) * this.size);
    }

    public boolean isInCoordinate(int x, int y) {
        boolean inBoundsX = this.x <= x && (this.x + size) >= x;
        boolean inBoundsY = this.y <= y && (this.y + size) >= y;
        return inBoundsX && inBoundsY;
    }
}

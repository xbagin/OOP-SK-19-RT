package sk.stuba.fei.uim.oop.app.shapes;

import lombok.Getter;

import java.awt.*;

public enum Colors {
    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE);

    @Getter
    private final Color color;

    Colors(Color color) {
        this.color = color;
    }
}

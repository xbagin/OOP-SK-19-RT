package sk.stuba.fei.uim.oop.app.logic;

import lombok.Getter;

public enum Modes {
    PLUS(true),
    RING(true),
    LINE(true),
    COLOR(false);

    @Getter
    private final boolean shapeKind;

    Modes(boolean shapeKind) {
        this.shapeKind = shapeKind;
    }
}

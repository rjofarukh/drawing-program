package org.example.models;

import java.util.Objects;

public class InputCoordinates {
    private final int topLeftX;
    private final int topLeftY;
    private final int bottomRightX;
    private final int bottomRightY;

    public InputCoordinates(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        if ((topLeftX + topLeftY) <= (bottomRightX + bottomRightY)) {
            this.topLeftX = topLeftX;
            this.topLeftY = topLeftY;
            this.bottomRightX = bottomRightX;
            this.bottomRightY = bottomRightY;
        } else {
            this.topLeftX = bottomRightX;
            this.topLeftY = bottomRightY;
            this.bottomRightX = topLeftX;
            this.bottomRightY = topLeftY;
        }
    }

    public int getTopLeftX() {
        return topLeftX;
    }

    public int getTopLeftY() {
        return topLeftY;
    }

    public int getBottomRightX() {
        return bottomRightX;
    }

    public int getBottomRightY() {
        return bottomRightY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputCoordinates that = (InputCoordinates) o;
        return topLeftX == that.topLeftX && topLeftY == that.topLeftY && bottomRightX == that.bottomRightX && bottomRightY == that.bottomRightY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeftX, topLeftY, bottomRightX, bottomRightY);
    }
}

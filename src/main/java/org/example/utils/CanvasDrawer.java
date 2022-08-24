package org.example.utils;

import org.example.models.Canvas;
import org.example.models.InputCoordinates;

public class CanvasDrawer {
    private final char pixel;
    private final char verticalLine;
    private final char horizontalLine;

    private final char emptySpace;

    public CanvasDrawer(char pixel, char verticalLine, char horizontalLine, char emptySpace) {
        this.pixel = pixel;
        this.verticalLine = verticalLine;
        this.horizontalLine = horizontalLine;
        this.emptySpace = emptySpace;
    }

    public CanvasDrawer() {
        this.pixel = 'x';
        this.verticalLine = '|';
        this.horizontalLine = '-';
        this.emptySpace = ' ';
    }

    public Canvas drawBorder(Canvas canvas) {
        if (canvas.getArrayHeight() <= 2 || canvas.getArrayWidth() <= 2) {
            return null;
        }
        char[][] surface = canvas.getSurface();

        for (int y = 0; y < canvas.getArrayHeight(); ++y) {
            for (int x = 0; x < canvas.getArrayWidth(); ++x) {
                if (y == 0 || y == canvas.getArrayHeight() - 1) {
                    surface[x][y] = horizontalLine;
                } else if (x == 0 || x == canvas.getArrayWidth() - 1){
                    surface[x][y] = verticalLine;
                } else {
                    surface[x][y] = emptySpace;
                }
            }
        }

        return canvas;
    }

    public Canvas drawLine(Canvas canvas, InputCoordinates coordinates) {
        if (coordinatesOutOfBounds(canvas, coordinates)) {
            return canvas;
        }
        char[][] surface = canvas.getSurface();

        for (int x = coordinates.getTopLeftX(); x <= coordinates.getBottomRightX(); ++x) {
            for (int y = coordinates.getTopLeftY(); y <= coordinates.getBottomRightY(); ++y) {
                surface[x][y] = pixel;
            }
        }
        canvas.setSurface(surface);
        return canvas;
    }

    public Canvas drawRectangle(Canvas canvas, InputCoordinates coordinates) {
        if (coordinatesOutOfBounds(canvas, coordinates)) {
            return canvas;
        }

        char[][] surface = canvas.getSurface();

        for (int x = coordinates.getTopLeftX(); x <= coordinates.getBottomRightX(); ++x) {
            for (int y = coordinates.getTopLeftY(); y <= coordinates.getBottomRightY(); ++y) {
                if (x == coordinates.getTopLeftX()
                        || x == coordinates.getBottomRightX()
                        || y == coordinates.getTopLeftY()
                        || y == coordinates.getBottomRightY()) {
                    surface[x][y] = pixel;
                }
            }
        }

        canvas.setSurface(surface);
        return canvas;
    }

    private boolean coordinatesOutOfBounds(Canvas canvas, InputCoordinates coordinates) {
        return coordinates.getTopLeftX() <= 0 || coordinates.getTopLeftX() >= canvas.getArrayWidth() - 1
                || coordinates.getBottomRightX() <= 0 || coordinates.getBottomRightX() >= canvas.getArrayWidth() - 1
                || coordinates.getTopLeftY() <= 0 || coordinates.getTopLeftY() >= canvas.getArrayHeight() - 1
                || coordinates.getBottomRightY() <= 0 || coordinates.getBottomRightY() >= canvas.getArrayHeight() - 1;
    }
}

package org.example.models;

public class Canvas {
    private char[][] surface;

    private final int arrayWidth;
    private final int arrayHeight;

    public Canvas(int width, int height) {
        this.arrayWidth = width + 2;
        this.arrayHeight = height + 2;
        this.surface = new char[this.arrayWidth][this.arrayHeight];
    }

    public char[][] getSurface() {
        return surface;
    }

    public void setSurface(char[][] surface) {
        this.surface = surface;
    }

    public int getArrayWidth() {
        return arrayWidth;
    }

    public int getArrayHeight() {
        return arrayHeight;
    }

    @Override
    public String toString() {
        StringBuilder printOut = new StringBuilder();
        for (int y = 0; y < this.arrayHeight; y++) {
            for (int x = 0; x < this.arrayWidth; x++) {
                printOut.append(surface[x][y]);
            }
            printOut.append("\n");
        }
        return printOut.toString();
    }
}

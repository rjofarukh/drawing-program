package org.example.utils;

import org.example.models.Canvas;
import org.example.models.InputCoordinates;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanvasDrawerTest {


    @Test
    void drawBorder10x10() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Canvas canvas = new Canvas(10, 10);

        assertEquals("""
                ------------
                |          |
                |          |
                |          |
                |          |
                |          |
                |          |
                |          |
                |          |
                |          |
                |          |
                ------------
                """,
                canvasDrawer.drawBorder(canvas).toString());
    }

    @Test
    void drawBorder1x1() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Canvas canvas = new Canvas(1, 1);

        assertEquals("""
                ---
                | |
                ---
                """,
                canvasDrawer.drawBorder(canvas).toString());
    }

    @Test
    void drawBorder5x10() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Canvas canvas = new Canvas(5, 10);

        assertEquals("""
                -------
                |     |
                |     |
                |     |
                |     |
                |     |
                |     |
                |     |
                |     |
                |     |
                |     |
                -------
                """,
                canvasDrawer.drawBorder(canvas).toString());
    }

    @Test
    void failToDraw0x5() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Canvas canvas = new Canvas(0, 5);

        assertNull(canvasDrawer.drawBorder(canvas));
    }

    @Test
    void failToDraw5x0() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Canvas canvas = new Canvas(5, 0);

        assertNull(canvasDrawer.drawBorder(canvas));
    }

    @Test
    void drawHorizontalLine() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Canvas canvas = new Canvas(20, 10);
        canvas = canvasDrawer.drawBorder(canvas);

        assertEquals("""
                ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                |    xxxxxx          |
                |                    |
                |                    |
                |                    |
                |                    |
                |                    |
                ----------------------
                """,
                canvasDrawer.drawLine(canvas, new InputCoordinates(5,5, 10, 5)).toString());
    }

    @Test
    void drawVerticalLine() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Canvas canvas = new Canvas(20, 10);
        canvas = canvasDrawer.drawBorder(canvas);

        assertEquals("""
                ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                |    x               |
                |    x               |
                |    x               |
                |    x               |
                |    x               |
                |    x               |
                ----------------------
                """,
                canvasDrawer.drawLine(canvas, new InputCoordinates(5,5, 5, 10)).toString());
    }

    @Test
    void drawLine1x1() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Canvas canvas = new Canvas(20, 10);
        canvas = canvasDrawer.drawBorder(canvas);

        assertEquals("""
                ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                |    x               |
                |                    |
                |                    |
                |                    |
                |                    |
                |                    |
                ----------------------
                """,
                canvasDrawer.drawLine(canvas, new InputCoordinates(5,5, 5, 5)).toString());
    }

    @Test
    void drawRectangle1x1() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Canvas canvas = new Canvas(20, 10);
        canvas = canvasDrawer.drawBorder(canvas);

        assertEquals("""
                ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                |    x               |
                |                    |
                |                    |
                |                    |
                |                    |
                |                    |
                ----------------------
                """,
                canvasDrawer.drawRectangle(canvas, new InputCoordinates(5,5, 5, 5)).toString());
    }

    @Test
    void drawRectangle5x5() {
        CanvasDrawer canvasDrawer = new CanvasDrawer();
        Canvas canvas = new Canvas(20, 10);
        canvas = canvasDrawer.drawBorder(canvas);

        assertEquals("""
                ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                |    xxxxx           |
                |    x   x           |
                |    x   x           |
                |    x   x           |
                |    xxxxx           |
                |                    |
                ----------------------
                """,
                canvasDrawer.drawRectangle(canvas, new InputCoordinates(5,5, 9, 9)).toString());
    }
}
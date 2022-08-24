package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CanvasDrawingEndToEndTest {

    @Test
    void drawingEndToEndTest() {
        String output;
        State state = new State();
        output = Main.runInputCommand(state, "C 20 5");

        assertEquals("""
                ----------------------
                |                    |
                |                    |
                |                    |
                |                    |
                |                    |
                ----------------------
                """,
                output);

        output = Main.runInputCommand(state, "L 1 3 7 3");

        assertEquals("""
                ----------------------
                |                    |
                |                    |
                |xxxxxxx             |
                |                    |
                |                    |
                ----------------------
                """,
                output);

        output = Main.runInputCommand(state, "L 7 1 7 3");
        assertEquals("""
                ----------------------
                |      x             |
                |      x             |
                |xxxxxxx             |
                |                    |
                |                    |
                ----------------------
                """,
                output);

        output = Main.runInputCommand(state, "R 15 2 20 5");
        assertEquals("""
                ----------------------
                |      x             |
                |      x       xxxxxx|
                |xxxxxxx       x    x|
                |              x    x|
                |              xxxxxx|
                ----------------------
                """,
                output);
    }
}

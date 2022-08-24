package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputCoordinatesTest {

    @Test
    void whenVerticalLineStartsFromTop_ThenItDoesNotInvert() {
        InputCoordinates given = new InputCoordinates(1, 5, 1, 10);
        assertProperties(given,1, 5, 1, 10);
    }

    @Test
    void whenVerticalLineStartsFromBottom_ThenItGetsInverted() {
        InputCoordinates given = new InputCoordinates(1, 10, 1, 5);
        assertProperties(given,1, 5, 1, 10);
    }

    @Test
    void whenHorizontalLineStartsFromLeft_ThenItDoesNotInvert() {
        InputCoordinates given = new InputCoordinates(5, 1, 10, 1);
        assertProperties(given,5, 1, 10, 1);
    }

    @Test
    void whenHorizontalLineStartsFromRight_ThenItGetsInverted() {
        InputCoordinates given = new InputCoordinates(10, 1, 5, 1);
        assertProperties(given,5, 1, 10, 1);

    }

    @Test
    void whenRectangleStartsFromBottomRight_ThenItGetsInverted() {
        InputCoordinates given = new InputCoordinates(10, 10, 1, 1);
        assertProperties(given, 1, 1, 10, 10);
    }

    @Test
    void whenRectangleStartsFromTopLeft_ThenItDoesNotInvert() {
        InputCoordinates given = new InputCoordinates(1, 1, 10, 10);
        assertProperties(given, 1, 1, 10, 10);
    }

    private void assertProperties(InputCoordinates given, int x1, int y1, int x2, int y2) {
        assertEquals(x1, given.getTopLeftX());
        assertEquals(y1, given.getTopLeftY());
        assertEquals(x2, given.getBottomRightX());
        assertEquals(y2, given.getBottomRightY());
    }
}
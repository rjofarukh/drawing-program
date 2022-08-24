package org.example;

import org.example.models.Canvas;
import org.example.utils.CanvasDrawer;
import org.example.utils.InputValidator;

public class State {
    private boolean isRunning = true;
    private Canvas canvas = null;
    private InputValidator validator = new InputValidator();
    private CanvasDrawer canvasDrawer = new CanvasDrawer();

    public State() {
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public InputValidator getValidator() {
        return validator;
    }

    public void setValidator(InputValidator validator) {
        this.validator = validator;
    }

    public CanvasDrawer getCanvasDrawer() {
        return canvasDrawer;
    }

    public void setCanvasDrawer(CanvasDrawer canvasDrawer) {
        this.canvasDrawer = canvasDrawer;
    }
}

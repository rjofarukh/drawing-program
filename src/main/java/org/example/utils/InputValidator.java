package org.example.utils;

import java.util.Optional;

public class InputValidator {

    private static final String PARAMETERS_NEED_TO_BE_INTEGERS = "Parameters need to be integers";
    private static final String NUMBERS_SHOULD_BE_POSITIVE = "Numbers should be positive";
    private static final String INSUFFICIENT_PARAMETERS = "Insufficient parameters";

    public Optional<String> validateCanvasInput(String[] fullCommand) {
        if (fullCommand.length != 3) {
            return Optional.of(INSUFFICIENT_PARAMETERS);
        }
        try {
            int height = Integer.parseInt(fullCommand[1]);
            int width = Integer.parseInt(fullCommand[2]);
            if (height <= 0 || width <= 0) {
                return Optional.of(NUMBERS_SHOULD_BE_POSITIVE);
            }
        } catch (NumberFormatException e) {
            return Optional.of(PARAMETERS_NEED_TO_BE_INTEGERS);
        }
        return Optional.empty();
    }

    public Optional<String> validateLineInput(String[] fullCommand) {
        if (fullCommand.length != 5) {
            return Optional.of(INSUFFICIENT_PARAMETERS);
        }
        try {
            int x1 = Integer.parseInt(fullCommand[1]);
            int y1 = Integer.parseInt(fullCommand[2]);
            int x2 = Integer.parseInt(fullCommand[3]);
            int y2 = Integer.parseInt(fullCommand[4]);

            if (x1 <= 0 || x2 <= 0 || y1 <= 0 || y2 <= 0) {
                return Optional.of(NUMBERS_SHOULD_BE_POSITIVE);
            }

            if (x1 != x2 && y1 != y2) {
                return Optional.of("Coordinates don't correspond to a line");
            }
        } catch (NumberFormatException e) {
            return Optional.of(PARAMETERS_NEED_TO_BE_INTEGERS);
        }
        return Optional.empty();
    }

    // Could potentially extract a method for the duplicate code from the above method
    public Optional<String> validateRectangleInput(String[] fullCommand) {
        if (fullCommand.length != 5) {
            return Optional.of(INSUFFICIENT_PARAMETERS);
        }
        try {
            int x1 = Integer.parseInt(fullCommand[1]);
            int y1 = Integer.parseInt(fullCommand[2]);
            int x2 = Integer.parseInt(fullCommand[3]);
            int y2 = Integer.parseInt(fullCommand[4]);

            if (x1 <= 0 || x2 <= 0 || y1 <= 0 || y2 <= 0) {
                return Optional.of(NUMBERS_SHOULD_BE_POSITIVE);
            }

            if (x1 == x2 || y1 == y2) {
                return Optional.of("Coordinates don't correspond to a rectangle");
            }
        } catch (NumberFormatException e) {
            return Optional.of(PARAMETERS_NEED_TO_BE_INTEGERS);
        }
        return Optional.empty();
    }
}

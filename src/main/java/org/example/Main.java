package org.example;

import org.example.models.Canvas;
import org.example.models.InputCoordinates;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        State state = new State();

        try (Scanner reader = new Scanner(System.in)) {

            while (state.isRunning()) {
                System.out.print("enter command: ");
                String fullCommandString = reader.nextLine();

                String output = runInputCommand(state, fullCommandString);
                System.out.println(output);

            }
        } catch (NoSuchElementException e) {
            System.out.println("Unexpected input, exiting program");
        }
    }

    public static String runInputCommand(State state, String fullCommandString) {
        String[] fullCommand = fullCommandString.split(" ");
        String commandType = fullCommand[0];

        StringBuffer printOut = new StringBuffer();
        InputCoordinates coordinates;
        Optional<String> invalidMessage;

        switch (commandType) {
            case "C":
                invalidMessage = state.getValidator().validateCanvasInput(fullCommand);
                if (invalidMessage.isPresent()) {
                    appendWithLine(printOut, invalidMessage.get());
                    break;
                } else {
                    state.setCanvas(new Canvas(Integer.parseInt(fullCommand[1]), Integer.parseInt(fullCommand[2])));
                    state.setCanvas(state.getCanvasDrawer().drawBorder(state.getCanvas()));
                    printOut.append(state.getCanvas().toString());
                }
                break;
            case "L":
                invalidMessage = state.getValidator().validateLineInput(fullCommand);

                if (invalidMessage.isPresent()) {
                    appendWithLine(printOut, invalidMessage.get());
                    break;
                } else {
                    coordinates = new InputCoordinates(
                            Integer.parseInt(fullCommand[1]),
                            Integer.parseInt(fullCommand[2]),
                            Integer.parseInt(fullCommand[3]),
                            Integer.parseInt(fullCommand[4])
                    );
                    if (state.getCanvas() != null) {
                        state.setCanvas(state.getCanvasDrawer().drawLine(state.getCanvas(), coordinates));
                        printOut.append(state.getCanvas().toString());
                    } else {
                        appendWithLine(printOut, "No canvas present");
                    }
                }
                break;
            case "R":
                invalidMessage = state.getValidator().validateRectangleInput(fullCommand);

                if (invalidMessage.isPresent()) {
                    appendWithLine(printOut, invalidMessage.get());
                    break;
                } else {
                    coordinates = new InputCoordinates(
                            Integer.parseInt(fullCommand[1]),
                            Integer.parseInt(fullCommand[2]),
                            Integer.parseInt(fullCommand[3]),
                            Integer.parseInt(fullCommand[4])
                    );
                    if (state.getCanvas() != null) {
                        state.setCanvas(state.getCanvasDrawer().drawRectangle(state.getCanvas(), coordinates));
                        printOut.append(state.getCanvas().toString());
                    } else {
                        appendWithLine(printOut, "No canvas present");
                    }
                }
                break;
            case "Q":
                state.setRunning(false);
                appendWithLine(printOut, "Quitting application");
                break;
            default:
                appendWithLine(printOut, "Invalid input");
        }
        return printOut.toString();
    }

    private static void appendWithLine(StringBuffer buffer, String textToAppend) {
        buffer.append(textToAppend + "\n");
    }
}
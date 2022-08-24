### To note
- Java version used - `java 17.0.4 2022-07-19 LTS`
- This is a more optimized solution (where we draw only , where we would save a full O(x*y) pass through of the surface and make it a O(x+y)
- In this implementation, the printing class would need to check if a character is unassigned, and print a space if that's true
- However, this would decrease the readability inside the printing class

```java 
public Canvas drawBorder(Canvas canvas) {
    char[][] surface = canvas.getSurface();

    for (int x = 0; x < canvas.getArrayWidth(); ++x) {
        surface[x][0] = horizontalLine;
        surface[x][canvas.getArrayHeight() - 1] = horizontalLine;
    }

    for (int y = 1; y < canvas.getArrayHeight() - 1; ++y) {
        surface[0][y] = verticalLine;
        surface[canvas.getArrayWidth() - 1][y] = verticalLine;
    }
    return canvas;
}
```

- Could have done System.exit(0), but I think setting the boolean in the main class is clearer
- The InputCoordinates class automatically corrects itself such that top left comes first and bottom right comes second. Alternatively, this could have been a validation on the user input to only allow them to draw in a specific direction, however this is the simplest implementation.
- The InputValidator handles the messages to be printed out if the input is invalid. The spec did not mention error handling, but this is the most testable way I could find. 
- I wanted to validate everything before even initializing the canvas, instead of doing error handing in a constructor or drawing the borders in a constructor.

- I added the validator after the original implementation realizing I would have time only for the tests or the implementation, but the tests are trivial for it
- The CanvasDrawer methods return a value instead of only editing the reference for clarity in tests and implementation
- I thought of the main class testable solution really late and it was added last minute, which is why there is only one end to end test

## To run

- Make sure you're on Java 17 or later
- Run `mvn exec:java -Dexec.mainClass=org.example.Main`
- The tests should be runnable in IntelliJ
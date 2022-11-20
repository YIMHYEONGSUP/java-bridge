package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public abstract class IoTest {
    private ByteArrayOutputStream outputStream;
    private PrintStream printStream;

    protected void SystemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @BeforeEach
    void setUp() {
        printStream = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    protected void printResult() {
        System.setOut(printStream);
        System.out.println(getOutput()
        );
    }

    protected String getOutput() {
        return outputStream.toString();
    }
}
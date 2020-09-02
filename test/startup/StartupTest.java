package startup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class StartupTest {
    private Startup instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        instanceToTest = null;
        printoutBuffer = null;

        System.setOut(originalSysOut);
    }

    @Test
    void main() {
        String[] args = null;
        Startup.main(args);
        String printout = printoutBuffer.toString();
        String expectedOutput = "Program started";
        assertTrue(printout.contains(expectedOutput), "Program did not start correctly.");
    }
}
package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {
    ReadFile rf;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        rf = new ReadFile();

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        rf = null;

        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    void openNewFile() {
        JTextPane tp;
        tp = rf.openNewFile();
        assertNotNull(tp);
    }

    @Test
    void doOpenFail() throws IOException {

        rf.doOpen();
        String printout = printoutBuffer.toString();
        String expectedOutput = "Open Cancelled";
        assertTrue(printout.contains(expectedOutput), "Cancelling Open wrong");
    }
}
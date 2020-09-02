package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ExportTest {
    Export sc;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalSysOut;

    @BeforeEach
    void setUp() {
        sc = new Export();

        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @AfterEach
    void tearDown() {
        sc = null;

        printoutBuffer = null;
        System.setOut(originalSysOut);
    }

    @Test
    void save() {
        JTextPane ta = new JTextPane();
        sc.save(ta);

        String printout = printoutBuffer.toString();
        String expectedOutput = "Nothing to Export";
        assertTrue(printout.contains(expectedOutput), "Cancelling Export wrong");
    }
}
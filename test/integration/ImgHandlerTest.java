package integration;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ImgHandlerTest {


    @Test
    void insertImg() {
        JTextPane ta = new JTextPane();
        ImgHandler imagehandler= new ImgHandler();
        ByteArrayOutputStream printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        PrintStream originalPS=System.out;
        System.setOut(inMemSysOut);
        imagehandler.insertImg(ta);

        String printout = printoutBuffer.toString();
        String expectedString="c:";
        assertTrue(printout.contains(expectedString), "uh-oh, something went horribly wrong...");

        printoutBuffer =null;

        System.setOut(originalPS);
    }

}
package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import javax.swing.text.Caret;
import javax.swing.text.StyleConstants;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class FontManagementTest {
 private JTextPane ta;
 private FontManagement fontManagement;

    @BeforeEach
    void setUp(){
        ta = new JTextPane();
        fontManagement= new FontManagement();
        fontManagement.setTextPane(ta);

    }
    @AfterEach
    void tearDown(){
        ta = null;
        fontManagement = null;
    }


    @Test
    void getSelectedText() {
        String expectedString= null;
        String returnedString="this should be null";

       try {
             returnedString=fontManagement.getSelectedText();
        assertEquals(expectedString, returnedString);

        }catch(NullPointerException e){
            e.printStackTrace();
        }

    }

    @Test
    void setTextPaneTest(){
        JTextPane testPane = new JTextPane();
        assertNotEquals(testPane, ta);
    }

    @Test
    void bold() {

        boolean expectedIsBoldBoolean = true;
        fontManagement.bold();
        boolean returnedIsBoolean = StyleConstants.isBold(fontManagement.getAttributeSet());
        assertEquals(expectedIsBoldBoolean,returnedIsBoolean);
    }

    @Test
    void cursive() {
        boolean expectedIsCursiveBoolean = true;
        fontManagement.cursive();
        boolean returnedIsBoolean = StyleConstants.isItalic(fontManagement.getAttributeSet());
        assertEquals(expectedIsCursiveBoolean,returnedIsBoolean);

    }

    @Test
    void setFont() {
        String expectedFontName = "Monospaced";
        StyleConstants.setForeground(fontManagement.getAttributeSet(), Color.red);
        StyleConstants.setFontFamily(fontManagement.getAttributeSet(), expectedFontName );
        String resultFontName = StyleConstants.getFontFamily(fontManagement.getAttributeSet());
        assertEquals(expectedFontName, resultFontName);
    }

    @Test
    void setColor() {
        String testColor = "Blue";
        Color expectedColor= Color.BLUE;
        fontManagement.setColor(testColor);
        Color returnedColor =fontManagement.getColor();
        assertEquals(expectedColor, returnedColor);
    }
}
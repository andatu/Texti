package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SidePanelTest {
    SidePanel sp;

    @BeforeEach
    void setUp() {
        sp = new SidePanel();
    }

    @AfterEach
    void tearDown() {
        sp = null;
    }

    @Test
    void press() {
        sp.press(sp.bold);
        assertTrue(sp.bold.getModel().isSelected());
    }

    @Test
    void getSidePanel() {
        assertNotNull(sp.help);
    }
}
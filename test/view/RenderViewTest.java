package view;

import controller.TextiController;
import integration.ImgHandler;
import model.SidePanel;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class RenderViewTest {

    @Test
    void actionPerformed() {
        ImgHandler imgHdlr = new ImgHandler();
        TextiController contr = new TextiController(imgHdlr);
        RenderView rv = new RenderView(contr);
        boolean expectedIsVisibleBoolean= true;
        boolean resultIsVisibleBoolean=rv.isVisible();
        assertEquals(expectedIsVisibleBoolean, resultIsVisibleBoolean);

    }

    @Test
    void checkConstructor(){
        ImgHandler imgHdlr = new ImgHandler();
        TextiController contr = new TextiController(imgHdlr);
        RenderView rw = new RenderView(contr);
        assertNotNull(rw.menu);
        assertNotNull(rw.sidePanel);
    }
}
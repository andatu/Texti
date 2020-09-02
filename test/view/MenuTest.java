package view;

import controller.TextiController;
import integration.ImgHandler;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;

    @Test
    void MenuTest(){
        menu = new Menu();
        assertNotEquals(null, menu);
        menu=null;
    }
    @Test
    void getMenuBar(){
        menu = new Menu();
        JMenuBar mb = menu.getMB();

        assertNotEquals(null, mb);

    }

}
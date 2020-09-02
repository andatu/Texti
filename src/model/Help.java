package model;

import java.awt.*;
import java.net.URI;

/**
 * Class to open help page on git
 */
public class Help {
    public void help() {
        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://github.com/Abbe-alshaikh/texti/wiki");
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package model;

import javax.swing.*;
import java.io.*;

/**
 * Class to open an object of JTextPane.
 */
public class ReadFile {
    JTextPane ta;

    /**
     * Creates a new JTextPane
     * @return the JTextPane
     */
    public JTextPane openNewFile(){
        return new JTextPane();
    }

    /**
     * Opens a JTextPane from a saved file.
     * @return the textpane
     * @throws IOException
     */
    public JTextPane doOpen() throws IOException {
        try {
            JFileChooser chooser = new JFileChooser("c:");
            int r = chooser.showOpenDialog(null);
            File f = new File(chooser.getSelectedFile().getAbsolutePath());

            if (r == JFileChooser.APPROVE_OPTION) {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                ta = (JTextPane) ois.readObject();
                ois.close();
            }

       }catch(NullPointerException | ClassNotFoundException e){
            System.out.println("Open Cancelled");
       }
        return ta;
    }
}

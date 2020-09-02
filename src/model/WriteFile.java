package model;

import javax.swing.*;
import java.io.*;

/**
 * Class to save the whole JTextPane as an object to a file.
 */
public class WriteFile {
    String formattedText;

    /**
     * The save function.
     * @param ta JTextPane to be saved
     * @throws IOException
     */
    public void save(JTextPane ta) throws IOException {
        if(ta.getText().length() > 0) {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.setMultiSelectionEnabled(true);

                int option = chooser.showSaveDialog(null);
                String filePath = chooser.getSelectedFile().getPath();

                if (option == JFileChooser.APPROVE_OPTION) {
                    FileOutputStream fos = new FileOutputStream(filePath);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(ta);
                    System.out.println("Saved");
                    oos.flush();
                    oos.close();


                } else {
                    System.out.println("Save cancelled.");
                }
            }catch(NullPointerException e){
                System.out.println("Save cancelled.");
            }
        }
        else{
            System.out.println("Nothing to save");
        }
    }
}

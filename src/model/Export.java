package model;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Export {
    /**
     * This class export the text pane to a .rtf-file
     * @param text to be exported
     */
    public void save(JTextPane text){
        if(text.getText().length() > 0) {
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.setMultiSelectionEnabled(true);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("RICH TEXT FORMAT", "rtf", "rtf");
                chooser.setFileFilter(filter);

                int option = chooser.showSaveDialog(null);
                String filePath = chooser.getSelectedFile().getPath();

                if (!chooser.getSelectedFile().getPath().toLowerCase().endsWith(".rtf")) {
                    filePath = chooser.getSelectedFile().getPath() + ".rtf";
                }
                if (option == JFileChooser.APPROVE_OPTION) {
                    StyledDocument doc = text.getStyledDocument();
                    HTMLEditorKit kit = new HTMLEditorKit();
                    BufferedOutputStream out;

                    try {
                        out = new BufferedOutputStream(new FileOutputStream(filePath));
                        kit.write(out, doc, doc.getStartPosition().getOffset(), doc.getLength());
                    } catch (IOException | BadLocationException e) {

                    }
                } else {
                    System.out.println("Export Cancelled.");
                }
            }catch(NullPointerException ne){
                System.out.println("Export Cancelled");
            }
        }
        else{
            System.out.println("Nothing to Export");
        }
    }
}



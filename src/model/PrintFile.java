package model;

import javax.swing.*;
import java.awt.*;
import java.awt.print.*;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class PrintFile{

    public void printSetup(JTextPane ta){
        try { ta.setContentType("text/rtf");
        boolean done = ta.print();
         if (done) {
             JOptionPane.showMessageDialog(null, "Printing done");
         }else {
             JOptionPane.showMessageDialog(null, "Printing failed");
         }
         }catch (PrinterException ex) {
            JOptionPane.showMessageDialog(null, "Error while printing");
        }
    }

}

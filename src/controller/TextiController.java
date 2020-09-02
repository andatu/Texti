package controller;
import integration.ImgHandler;
import model.*;

import javax.swing.*;
import java.io.IOException;

public class TextiController extends JFrame {
    JTextPane ta;
    ReadFile rf = new ReadFile();
    PrintFile pf = new PrintFile();
    FontManagement fontm= new FontManagement();
    ImgHandler imgHandler;

    public TextiController(ImgHandler imgHdlr){
        this.imgHandler=imgHdlr;
    }

    //vi flyttar skapandet av ta till modellen och det returneras här tbx till vyn
    public JTextPane openNewFile(){
        ta = rf.openNewFile();
        fontm.setTextPane(ta);
        return ta;
    }

    public void bold(){
        fontm.bold();
        System.out.println("bold in controller");
    }
    public void cursive(){
        fontm.cursive();
    }
    //controlling fonts
    public void setFont(String font){
        fontm.setFont(font);
    }

    public void doSave(JTextPane ta) throws IOException, ClassNotFoundException {
        WriteFile wf = new WriteFile();
        wf.save(ta);
    }
    public void export(JTextPane ta){
        Export sc = new Export();
        sc.save(ta);
    }
    public JTextPane doOpen() throws IOException, ClassNotFoundException {
        ta = rf.doOpen();
        fontm.setTextPane(ta);
        return ta;
    }
    public void setColor(String color){
        fontm.setColor(color);
       // ta.setForeground(fontm.getColor());
    }

    public void createList(){
        fontm.createList();
    }
    public void insertImg(JTextPane ta)
    {
        imgHandler.insertImg(ta);
    }
    public void setSize(int size){
        fontm.size(size);
    }
    public void highlighting ()  {
            fontm.highlighting();
    }
    public void copy (){
        fontm.copy();
    }
    public void doUnderline(){
        fontm.doUnderline();
    }
    public void help(){
        Help help = new Help();
        help.help();
    }

    public void setAlignment(String placement) {
        fontm.setAlignment(placement);
    }
    public void printFile(JTextPane ta) {
        pf.printSetup(ta);
    }

    public void paste() {
        fontm.paste();
    }

    public void cut() {
        fontm.cut();
    }

    public void redo() {
        fontm.redo ();
    }

    public void undo() {
        fontm.undo ();
    }


}
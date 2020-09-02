package view;


import controller.TextiController;

import javax.swing.*;
import java.awt.event.*;

public class Menu extends JFrame{
   private TextiController contr;
    private JMenuBar menuBar;
    private JMenuItem menuItem;
    private JRadioButtonMenuItem rbMenuItem;
    public JComboBox colors;
    private JCheckBoxMenuItem cbMenuItem;
    private JMenu file, view, toolWindow, edit, insert, formatting, help, print, alignment, lists, size_of_letters;
    JMenuItem newItem, openItem, saveItem,saveAsItem,undo, redo, cut, copy, paste, spell_check,
            editWindow, fontWindow, picture, table, doBold, cursive, underline,
            highlighting, left, center, right, bullet_points, enumeration, fonts, s8, s10, s12, s14, s16, s18, s20,
            cantarell, monospaced, sansserif, serif, export, help2, printer;

    public Menu(){

      render();
    }
    String[] colorArr={"Black","Red", "Purple", "Orange",  "Blue", "Green", "Yellow"};
    private void render(){
       menu();
    }

    private void menu(){

       //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the scroll-down menus.
        file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_A);
        file.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        edit = new JMenu("Edit");
        view = new JMenu("View");
        insert = new JMenu("Insert");
        formatting = new JMenu("Text Formatting");
        help = new JMenu("Help");
        print = new JMenu("Print");
        fonts = new JMenu("Fonts");


        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);
        menuBar.add(insert);
        menuBar.add(formatting);
        menuBar.add(help);
        menuBar.add(print);
        menuBar.add(fonts);

        //add font options to scroll-down menu Fonts
        serif = new JMenuItem("Serif");
        monospaced = new JMenuItem("Monospaced");
        sansserif = new JMenuItem("SansSerif");
        cantarell = new JMenuItem("Cantarell");
        fonts.add(serif);
        fonts.add(monospaced);
        fonts.add(sansserif);
        fonts.add(cantarell);

        //add items to File scroll-down menu
        newItem = new JMenuItem("New");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        export = new JMenuItem("Export to .rtf");
        file.add(newItem);
        file.add(openItem);
        file.add(saveItem);
        file.add(export);

        undo = new JMenuItem("Undo");
        redo = new JMenuItem("Redo");
        cut = new JMenuItem("Cut");
        copy = new JMenuItem("Copy");
        paste = new JMenuItem("Paste");
        spell_check = new JMenuItem("Spell check");
        edit.add(undo);
        edit.add(redo);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(spell_check);

        editWindow = new JMenuItem("Edit Window");
        fontWindow = new JMenuItem("Font Window");
        toolWindow = new JMenu("Tool Windows");
        view.add(toolWindow);
        toolWindow.add(editWindow);
        toolWindow.add(fontWindow);

        picture = new JMenuItem("Insert Picture");
        insert.add(picture);
        table = new JMenuItem("Insert Table");
        insert.add(table);

        doBold = new JMenuItem("Bold");
        formatting.add(doBold);

        cursive = new JMenuItem("Cursive");
        formatting.add(cursive);

        size_of_letters = new JMenu("Size");
        formatting.add(size_of_letters);
         s8 = new JMenuItem("8");
        s10 = new JMenuItem("10");
        s12 = new JMenuItem("12");
        s14 = new JMenuItem("14");
        s16 = new JMenuItem("16");
        s18 = new JMenuItem("18");
        s20 = new JMenuItem("20");
        size_of_letters.add(s8);
        size_of_letters.add(s10);
        size_of_letters.add(s12);
        size_of_letters.add(s14);
        size_of_letters.add(s16);
        size_of_letters.add(s18);
        size_of_letters.add(s20);

        //code for coloring text
        colors= new JComboBox(colorArr);
        colors.setBounds( 40, 30, 10, 35);
        colors.setMaximumSize(colors.getPreferredSize());

        menuBar.add(colors);

        //Printer
        printer = new JMenuItem("Print");
        print.add(printer);


        underline = new JMenuItem("Underline");
        formatting.add(underline);

        highlighting = new JMenuItem("Highlighting");
        formatting.add(highlighting);

        alignment = new JMenu ("Alignment ");
        formatting.add(alignment);
        left = new JMenuItem("Left");
        center = new JMenuItem("Center");
        right = new JMenuItem("Right");
        alignment.add(left);
        alignment.add(center);
        alignment.add(right);

        lists = new JMenu ("Lists");
        bullet_points = new JMenuItem("Bullet Points");
        enumeration = new JMenuItem("Enumeration");
        formatting.add(lists);
        lists.add(bullet_points);
        lists.add(enumeration);

        fonts = new JMenuItem("Fonts");
        formatting.add(fonts);

        help2 = new JMenuItem("Help");
        help.add(help2);

    }
   //public void openFile(){
    //    TextView tv = contr.openFile();
     //   renderTv(tv);
    //}
    public JMenuBar getMB(){
        return menuBar;
    }


}
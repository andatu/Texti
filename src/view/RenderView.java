package view;

import controller.TextiController;
import model.SidePanel;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RenderView extends JFrame implements ActionListener {
    private JScrollPane scrollbar;

    private int width = 1200, height = 900;
    private JMenuBar mb;
    private JPanel sp;
    private String fName;
    TextiController contr;
    Menu menu;
    SidePanel sidePanel;
    JTextPane ta;
    Font bold, plain;
    UndoManager manager = new UndoManager();
    public RenderView(TextiController contr){
        this.contr=contr;
        menu = new Menu();
        sidePanel = new SidePanel();
        userInterface(menu, sidePanel);
      //menu.setVisible(true);
    }

    private void userInterface(Menu menu, SidePanel sidePanel){

        mb = menu.getMB();
        sp = sidePanel.getSidePanel();

        menu.newItem.addActionListener(this);
        menu.doBold.addActionListener(this);
        menu.underline.addActionListener(this);
        menu.saveItem.addActionListener(this);
        menu.openItem.addActionListener(this);
        menu.copy.addActionListener(this);
        menu.paste.addActionListener(this);
        menu.cut.addActionListener(this);
        menu.undo.addActionListener( this);
        menu.redo.addActionListener(this);
        menu.cursive.addActionListener(this);
        menu.export.addActionListener(this);
        menu.printer.addActionListener(this);
        //image,picture actionListener
        menu.picture.addActionListener(this);
        // Size action listeners
        menu.s8.addActionListener(this);
        menu.s10.addActionListener(this);
        menu.s12.addActionListener(this);
        menu.s14.addActionListener(this);
        menu.s16.addActionListener(this);
        menu.s18.addActionListener(this);
        menu.s20.addActionListener(this);

        // Alignment action listeners
        menu.left.addActionListener(this);
        menu.center.addActionListener(this);
        menu.right.addActionListener(this);

        //Fonts action Listeners:
        menu.serif.addActionListener(this);
        menu.cantarell.addActionListener(this);
        menu.monospaced.addActionListener(this);
        menu.sansserif.addActionListener(this);
        //colors action-listener
        menu.colors.addActionListener(this);
        menu.help2.addActionListener(this);

        //menu.colors.setPrototypeDisplayValue("Orange");

        //Action listener for highlighting
        menu.highlighting.addActionListener(this);
        //Action listeners for Side Panel
        sidePanel.bold.addActionListener(this);
        sidePanel.high.addActionListener(this);
        sidePanel.cursive.addActionListener(this);
        sidePanel.underline.addActionListener(this);
        sidePanel.numberedList.addActionListener(this);
        sidePanel.bulletList.addActionListener(this);
        sidePanel.help.addActionListener(this);

        this.setTitle("Texti - the worlds best word processor!");
        //this.iconImage

        this.setLocation(0,0);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // this.add(scrollbar);
        this.setJMenuBar(mb);
        this.add(sp, BorderLayout.BEFORE_LINE_BEGINS);

        this.pack();
        this.setVisible(true);
        this.setBounds(10,10,width,height);
        //this.show();

        //Lists
        menu.bullet_points.addActionListener(this);

        //initiate with a new text-area
        newTA();

    }


    public void actionPerformed(ActionEvent e){
        String action = e.getActionCommand();

        if(action.equals("New")){
             newTA();
        }else if(action.equals("Bold")){
            contr.bold();
            sidePanel.press(sidePanel.bold);
        }else if(action.equals("Save")) {
            try {
                contr.doSave(ta);
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }else if(action.equals("Open")) {
            JTextPane tempPane = ta;
            try {
                //this.remove(ta);
                this.ta = contr.doOpen();
            } catch (IOException | ClassNotFoundException ex) {
                //ex.printStackTrace();
            }
            this.remove(tempPane);
            scrollbar = new JScrollPane((ta));
            this.add(ta);
            this.setVisible(true);
        }else if (action.equals("Export to .rtf")) {
            contr.export(ta);
        }else if(action.equals("Cursive")){
            contr.cursive();
            sidePanel.press(sidePanel.cursive);
        }else if (action.equals("Underline")){
            contr.doUnderline();
            sidePanel.press(sidePanel.underline);
        } else if(action.equals("Serif")){
            fName= "Serif";
            contr.setFont(fName);
        }else if(action.equals("Monospaced")){
            fName= "Monospaced";
            contr.setFont(fName);
        }else if(action.equals("SansSerif")){
             fName= "SansSerif";
            contr.setFont(fName);
        }else if(action.equals("Cantarell")){
            fName= "Cantarell";
            contr.setFont(fName);
        }
        // Size
        else if(action.equals("8")){
            contr.setSize(8);
        }
        else if(action.equals("10")){
            contr.setSize(10);
        }
        else if(action.equals("12")){
            contr.setSize(12);
        }
        else if(action.equals("14")){
            contr.setSize(14);
        }
        else if(action.equals("16")){
            contr.setSize(16);
        }
        else if(action.equals("18")){
            contr.setSize(18);
        }
        else if(action.equals("20")){
            contr.setSize(20);
        } else if(e.getSource()==menu.colors){
            System.out.println("listening in colors");
            contr.setColor(menu.colors.getSelectedItem().toString());
        }else if(action.equals("Bullet Points")){
            contr.createList();
            sidePanel.press(sidePanel.bulletList);
        }else if(action.equals("Insert Picture")){
            contr.insertImg(ta);
        }
        //Sidepanel
        else if (action.equals("B")){
            contr.bold();
            //sidePanel.press(sidePanel.bold);
        }else if (action.equals("C")){
            contr.cursive();
        }else if (action.equals("U")){
            contr.doUnderline();
        }else if (action.equals("H")){
            contr.highlighting();
        }else if (action.equals("*")){
            contr.createList();
        }else if (action.equals("1.")){
        }else if (action.equals("Help")){
            contr.help();
        }
        //Allignment
        else if (action.equals("Left")){
            contr.setAlignment("left");
        }else if (action.equals("Center")){
            contr.setAlignment("center");
        }else if (action.equals("Right")){
            contr.setAlignment("right");
        }else if (action.equals("Highlighting")) {
            contr.highlighting();
        }
        //Print
        else if (action.equals("Print")){
            contr.printFile(ta);
        }


        else if (action.equals("Cut")) {
        }else if (action.equals("Cut")) {
            contr.cut();
        }else if (action.equals("Copy")){
            contr.copy();
        }else if (action.equals("Paste")){
            contr.paste();
        } else if (action.equals("Undo")){
            System.out.println("Undo");
                    contr.undo();
        }else if (action.equals("Redo")){
            System.out.println("redo");
                    contr.redo();
        }

    }
    public void newTA(){
        if(ta == null) {
            ta = contr.openNewFile();
            scrollbar = new JScrollPane((ta));
            this.add(ta);
            ta.setText("");
            this.setVisible(true);
        }else{
            ta.setText("");
        }
    }
}
package model;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

/**
 * This creates the side panel of the app
 */
public class SidePanel extends JFrame {
    private JPanel sidePanel;
    public JToggleButton bold, high, cursive, underline, bulletList, numberedList;
    public JButton help;

    /**
     * Constructor of side panel which also renders it.
     */
    public SidePanel() {
        render();
    }

    private void render(){sidePanel();}

    private void sidePanel(){

        sidePanel = new JPanel();

        bold = new JToggleButton("B");
        high = new JToggleButton("H");
        cursive = new JToggleButton("C");
        underline = new JToggleButton("U");
        bulletList = new JToggleButton("*");
        numberedList = new JToggleButton("1.");

        bold.setFocusable(false);
        high.setFocusable(false);
        cursive.setFocusable(false);
        underline.setFocusable(false);
        bulletList.setFocusable(false);
        numberedList.setFocusable(false);

        bold.setFont(new Font("Dialog", Font.BOLD, 12));
        cursive.setFont(new Font(cursive.getFont().getName(),Font.ITALIC+Font.PLAIN,cursive.getFont().getSize()));
        Border lineBorder = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK);
        CompoundBorder border = new CompoundBorder(underline.getBorder(), lineBorder);
        underline.setBorder( border );
        underline.setBorder(border);
        underline.setFont((new Font(cursive.getFont().getName(),Font.PLAIN,underline.getFont().getSize())));
        high.setForeground(Color.RED);

        sidePanel.add(bold);
        sidePanel.add(cursive);
        sidePanel.add(underline);
        sidePanel.add(high);
        sidePanel.add(bulletList);
        sidePanel.add(numberedList);

        help = new JButton("Help");
        sidePanel.add(help);

        sidePanel.setPreferredSize(new Dimension(100,40));
    }

    /**
     * Function called from controller to press or depress buttons manually
     * for visual effects.
     * @param button the button to be changed
     */
    public void press(JToggleButton button){
        if(button.getModel().isSelected()){
            button.getModel().setSelected(false);
        }
        else{
            button.getModel().setSelected(true);
        }
    }

    /**
     * @return sidePanel
     */
    public JPanel getSidePanel(){
        return sidePanel;
    }
}

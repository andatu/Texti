package integration;

import javax.swing.*;
import java.io.File;

public class ImgHandler {
    File f;
    public void insertImg(JTextPane ta){
       // String path="";
        JFileChooser fileChooser=new JFileChooser("c:");
        System.out.println("c:");
        int openDialog=fileChooser.showOpenDialog(ta);

        if(openDialog==JFileChooser.APPROVE_OPTION){

            f=fileChooser.getSelectedFile();

            if(isImage(f)){
                String path= f.getAbsolutePath();
                ImageIcon imageIcon= new ImageIcon(path);
                ta.insertIcon(imageIcon);
            }
            else{
                System.out.println("c:");
                JOptionPane.showMessageDialog(ta,
                        "you have selected a file that is not an image-file" +
                                "please retry with the right file-type", "wrong file-type",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private boolean isImage(File f){

        boolean isImg=false;

            String fileName=f.getName();
            if(fileName.endsWith(".jpg")){
                isImg=true;
            }else if(fileName.endsWith(".jpeg")){
                isImg=true;
            }else if(fileName.endsWith(".gif")){
                isImg=true;
            }else if(fileName.endsWith(".png")){
                isImg=true;
            }else{
                isImg=false;
            }

        return isImg;
    }
}

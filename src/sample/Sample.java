package sample;

import javafx.scene.control.Alert;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Sample {

    private int counter;
    private String mainPath;

    public String extention(String fullName) {
        //create by Vadimka
        if(fullName.lastIndexOf(".") == -1){

        }
        else{
            return fullName.substring(fullName.lastIndexOf("."));
        }
        return "0";
    }

    public void myMoveFile(String start_file, String finish_flie) throws IOException {
        File source = new File(start_file);
        File dest = new File(finish_flie);
        source.renameTo(new File(dest.toString()));
        source.delete();
    }

    public void search(String path, String pathM, String pathV, String pathT, String pathO) throws IOException{

        File folder = new File(path);
        Collect collect = new Collect();
        this.mainPath = path;

        for(File f : folder.listFiles()){

            if(f.isDirectory()){
                System.out.println("Dir");
            }
            else {
                collect.addCheck(f.getName());

                switch (collect.valKey(f.getName())) {
                    case "music":
                        collect.mapToTxt();
                        useInfo(pathM, f);
                        break;
                    case "video":
                        collect.mapToTxt();
                        useInfo(pathV, f);
                        break;
                    case "text":
                        collect.mapToTxt();
                        useInfo(pathT, f);
                        break;
                    case "other":
                        collect.mapToTxt();
                        System.out.println(pathO);
                        useInfo(pathO, f);
                        break;
                    default:
                        System.out.println("Error!");
                        break;
                }
            }
        }
        MessageBox("Automizer", "Сортировка прошла успешно!", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);

    }


    public void useInfo(String path, File f) throws IOException{
        File dest;
        dest = new File(path + "\\" + f.getName());
        DataBase.insertPaths(mainPath, dest.toString());
        System.out.println(dest.toPath());
        myMoveFile(f.toString(), dest.toString());
        ++counter;
    }

    public static void MessageBox(String title, String message, int optionType, int messageType){
        Component frame = new Component() {
            @Override
            public boolean isValid() {
                return true;
            }
        };
        Object[] options = {"ОК"};

        int n = JOptionPane.showOptionDialog(frame,
                message,
                title,
                optionType,
                messageType,
                null,
                options,
                options[0]);
    }

}
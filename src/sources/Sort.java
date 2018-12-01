package sources;

import services.database.DataBase;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Sort {

    private String mainPath;

    public void myMoveFile(String start_file, String finish_file) {
        File source = new File(start_file);
        File dest = new File(finish_file);
        source.renameTo(new File(dest.toString()));
        source.delete();
    }

    public void search(String path, String pathMusic, String pathVideo, String pathText, String pathOther){
        try {
            File folder = new File(path);
            Collect collect = new Collect();
            this.mainPath = path;
            HashMap<String, String> typesMap = new HashMap<>();
            typesMap.put("text", pathText);
            typesMap.put("music", pathMusic);
            typesMap.put("video", pathVideo);
            typesMap.put("other", pathOther);

            for (File f : folder.listFiles()) {

                if (f.isDirectory()) {
                    System.out.println("Dir");
                } else {
                    collect.addCheck(f.getName());
                    collect.valKey(f.getName());
                    useInfo(typesMap.get(collect.valKey(f.getName())), f);
                }
            }
            collect.mapToTxt();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        MessageBox("Automizer", "Сортировка прошла успешно!", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
    }


    public void useInfo(String path, File f){
        File dest;
        dest = new File(path + "\\" + f.getName());
        DataBase.insertPaths(mainPath, dest.toString());
        System.out.println(dest.toPath());
        myMoveFile(f.toString(), dest.toString());
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
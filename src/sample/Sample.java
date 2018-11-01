package sample;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.Scanner;

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

        // чтение файла
        FileInputStream fip = new FileInputStream(source);
        BufferedInputStream fbs= new BufferedInputStream(fip);

        int size = fbs.available();
        byte b[] = new byte[size];
        fbs.read(b);

        FileOutputStream fos = new FileOutputStream(finish_flie);
        fos.write(b);

        fip.close();//прочитанный файл
        fbs.close();//буфф-прочитанный файл
        fos.close();//записанный файл

        boolean isdeleted = source.delete();

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
        MessageBox("Automizer", "Сортировка прошла успешно!", Alert.AlertType.INFORMATION);

    }


    public void useInfo(String path, File f) throws IOException{
        File dest;
        dest = new File(path + "\\" + f.getName());
        DataBase.insertPaths(mainPath, dest.toString());
        System.out.println(dest.toPath());
        myMoveFile(f.toString(), dest.toString());
        ++counter;
    }

    public void MessageBox(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }

}
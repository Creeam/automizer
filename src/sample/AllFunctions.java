package controllers;

import javafx.scene.control.Alert;

import java.io.*;


public class AllFunctions {

    static public String extention(String fullName) {
        //create by Vadimka
        if(fullName.lastIndexOf(".") == -1){

        }
        else{
            return fullName.substring(fullName.lastIndexOf("."));
        }
        return "0";
    }

    static void myMoveFile(String start_file, String finish_flie) throws IOException{

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

    static public void search(String path, String pathM, String pathV, String pathT, String pathD) throws IOException{

        File folder = new File(path);
        File dest;
        int temp = 0;
        for(File f : folder.listFiles()){
            switch (extention(f.getName())){
                case ".mp3":
                    System.out.println("МУЗОНН!!!!!!!!!" + "       " + f.getName());
                    dest = new File(pathM + "\\" + f.getName());
                    System.out.println(dest.toPath());
                    myMoveFile(f.toString(), dest.toString());
                    ++temp;
                    break;
                case "0":
                    System.out.println("Папка: " + f.getName());
                    break;
                default:
                    System.out.println("Неизвестные расширения." + f.getName());
                    break;
            }
        }
        MessageBox("Automizer", "Сортировка прошла успешно!", Alert.AlertType.INFORMATION);


    }

    static public void MessageBox(String title, String message, Alert.AlertType type){
        Alert alert = new Alert(type);

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }


}
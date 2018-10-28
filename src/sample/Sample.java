package sample;

import javafx.scene.control.Alert;

import java.io.*;

public class Sample {

    private int counter;

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

    public void search(String path, String pathM, String pathV, String pathT, String pathD) throws IOException{

        File folder = new File(path);

        for(File f : folder.listFiles()){
            switch (extention(f.getName())){

                //-------------Music formats--------------
                case ".mp3":
                    System.out.println("МУЗОНН!!!!!!!!!" + "       " + f.getName());
                    useInfo(pathM, f);
                    break;
                case ".wav":
                    System.out.println("МУЗОНН!!!!!!!!!" + "       " + f.getName());
                    useInfo(pathM, f);
                    break;

                //-------------Video formats--------------
                case ".AVI":
                    System.out.println("Видео!!!!");
                    useInfo(pathV, f);
                    break;
                case ".mp4":
                    System.out.println("Видео!!!!");
                    useInfo(pathV, f);
                    break;
                case ".flv":
                    System.out.println("Видео!!!!");
                    useInfo(pathV, f);
                    break;
                case ".MOV":
                    System.out.println("Видео!!!!");
                    useInfo(pathV, f);
                    break;

                //-------------Documents formats--------------


                //-------------Text formats--------------
                case ".txt":
                    System.out.println("Текстовые документы!!!!");
                    useInfo(pathT, f);
                    break;
                case ".rtf":
                    System.out.println("Текстовые документы!!!!");
                    useInfo(pathT, f);
                    break;
                case ".doc":
                    System.out.println("Текстовые документы!!!!");
                    useInfo(pathT, f);
                    break;
                case ".docx":
                    System.out.println("Текстовые документы!!!!");
                    useInfo(pathT, f);
                    break;
                case ".pdf":
                    System.out.println("Текстовые документы!!!!");
                    useInfo(pathT, f);
                    break;

                //-------------Папка-----------------------------
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

    public void useInfo(String path, File f) throws IOException{
        File dest;
        dest = new File(path + "\\" + f.getName());
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
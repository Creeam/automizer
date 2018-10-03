package sample;

import java.io.File;

public class AllFunctions {

    public static String extention(String fullName) {
        //create by Vadimka
        if(fullName.lastIndexOf(".") == -1){

        }
        else{
            return fullName.substring(fullName.lastIndexOf("."));
        }
        return "0";
    }

    public static void search(String path){

        File folder = new File(path);
        int temp = 0;
        for(File f : folder.listFiles()){
            switch (extention(f.getName())){
                case ".mp3":
                    System.out.println("МУЗОНН!!!!!!!!!" + "       " + f.getName());
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

    }


}
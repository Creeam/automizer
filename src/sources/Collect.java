package sources;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Collect {
    HashMap<String, Set<String>> ext;
    private Set<String> text;
    private Set<String> music;
    private Set<String> video;
    private Set<String> other;
    private Scanner scn;
    final private String[] types = {"text", "music", "video", "other"};

    Collect() throws IOException, NullPointerException {
        ext = new HashMap<>();
        text = new HashSet<>();
        music = new HashSet<>();
        video = new HashSet<>();
        other = new HashSet<>();
        int i = 0;
        readToMap(types[i], text);
        i++;
        readToMap(types[i], music);
        i++;
        readToMap(types[i], video);
        i++;
        readToMap(types[i], other);
    }

    private void readToMap(String key, Set<String> type) throws IOException {
        try {
            scn = new Scanner(new File(key + ".txt"));
            while (scn.hasNext()) {
                type.add(scn.next());
            }
            scn.close();
        } catch (IOException e) {
            e.printStackTrace();
            Files.createFile(Paths.get(key + ".txt"));
        }
        ext.put(key, type);
    }

    public String extention(String fullName) throws IndexOutOfBoundsException {
        int dotPoint = fullName.lastIndexOf(".");
        String str;
        try{
            str = fullName.substring(dotPoint);
            return str;
        }catch(IndexOutOfBoundsException e){
            System.out.println("Catched");
            e.printStackTrace();
            return null;
        }
    }

    String undefinedExtension(String str){
        String type = "";
        Component frame = new Component() {};
        Object[] options = {"Музыка",
                "Видео",
                "Текст",
                "Остальное"};
        int n = JOptionPane.showOptionDialog(frame,
                "Какой это тип файла имеет данное расширение: "
                        + str,
                "Выберите тип файла",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[2]);
        System.out.println(n);
        switch (n){
            case 0:
                type = "music";
                break;
            case 1:
                type = "video";
                break;
            case 2:
                type = "text";
                break;
            case 3:
                type = "other";
                break;
        }
        return type;
    }

    void addCheck(String str){
        if(isContain(extention(str))) return;
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("Undefined extention: " + extention(str) +" Enter type:");
            String key = undefinedExtension(extention(str));
            if (ext.containsKey(key)) {
                ext.computeIfAbsent(key, k -> new HashSet<>()).add(extention(str));
            } else {
                ext.computeIfAbsent("other", k -> new HashSet<>()).add(extention(str));
            }
        }
    }

    void mapToTxt() throws IOException {
        setToTxt("music", music);
        setToTxt("text",text);
        setToTxt("video",video);
        setToTxt("other", other);
    }

    boolean isContain(String val){
        String str = extention(val);
        return (music.contains(str) || text.contains(str) ||
                video.contains(str) || other.contains(str));
    }

    String valKey(String val){
        String str = extention(val);
        if (!isContain(val)) return "NotDefined";
        if (music.contains(str)) return "music";
        if (text.contains(str)) return "text";
        if (video.contains(str)) return "video";
        if (other.contains(str)) return "other";
        return null;
    }

    private void setToTxt(String key, Set<String> type) throws IOException {
        try{
            FileWriter prnt = new FileWriter(key + ".txt");
            Iterator<String> iter = type.iterator();
            while (iter.hasNext() == true) {
                prnt.write(iter.next()+"\n");
         }
         prnt.close();
        }catch (IOException e){
          e.printStackTrace();

        }
    }

}




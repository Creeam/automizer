package sample;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NameService {
    Set<String> setOfExt;

    NameService(){
        setOfExt = new HashSet<String>();
    }

    public String extention(String fullName) {
        int dotPoint = fullName.lastIndexOf(".");
        if (dotPoint == -1) return "0";
        setOfExt.add(fullName.substring(dotPoint));
        return fullName.substring(dotPoint);
    }

    public void printSet(){
        Iterator<String> iter = setOfExt.iterator();

        while(iter.hasNext() == true) {
            System.out.println(iter.next());
        }
    }
}
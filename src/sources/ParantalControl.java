package sources;

import java.io.IOException;
import java.util.Date;

public class ParantalControl {

    private Date date;
    private long now;
    private long after;
    private String osName;
    private Process process;

    public ParantalControl(){
        date = new Date();
    }

    public void lockScreen(String hour, String minute){

        osName = System.getProperty("os.name");
        System.out.println(date.getTime());

        now = date.getTime();
        after = now + ((Integer.parseInt(hour) * 60) * 60000) + (Integer.parseInt(minute) * 60000);

        while (now != after){
            now = new Date().getTime();
        }

        try {
            switch (osName) {
                case "Linux":
                    process = Runtime.getRuntime().exec("xdg-screensaver lock");
                    break;
                case "Windows":
                    process = Runtime.getRuntime().exec("%SystemRoot%\\system32\\rundll32.exe USER32.DLL LockWorkStation");
                    break;
                default:
                    break;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

}
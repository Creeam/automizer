package sources;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ParantalControl implements Initializable {

    private Date time;

    public void initialize(URL url, ResourceBundle rb){
        time = new Date();
    }

    public void lockScreen(String hour, String minute){
        System.out.println(time.toString());
    }

}
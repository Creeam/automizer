package sample;

import com.sun.nio.sctp.MessageInfo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import java.io.File;

public class Controller {

    @FXML
    private Button waybutton;
    @FXML
    private Button sortButton;
    @FXML
    private TextField wayText;

    private String path;



    @FXML
    public void onClickMethodWayButton(){

        DirectoryChooser fileopen = new DirectoryChooser();
        wayText.setText(fileopen.showDialog(null).toString());
        path = wayText.getText().toString();

    }

    public void onClickMethodSortButton(){
        System.out.println(path);
        File folder = new File(path);
        int temp = 0;
        for(File f : folder.listFiles()){
            switch (AllFunctions.extention(f.getName())){
                case ".mp3":
                    System.out.println("МУЗОНН!!!!!!!!!" + "       " + f.getName());
                    ++temp;

                    break;
                default:
                    System.out.println("Неизвестные расширения." + f.getName());
                    break;
            }

        }
        System.out.println(temp);
    }

}
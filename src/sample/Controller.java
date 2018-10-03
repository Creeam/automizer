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
        for(File f : folder.listFiles()){
            if("Main.java".equals(f.getName())){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }

}
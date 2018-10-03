package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;


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
        AllFunctions.search(path);
    }

}
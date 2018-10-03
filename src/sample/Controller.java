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
    private Button musicWayButton;
    @FXML
    private Button videoWayButton;
    @FXML
    private Button textWayButton;
    @FXML
    private Button documentWayButton;
    @FXML
    private TextField wayText;
    @FXML
    private TextField wayTextM;
    @FXML
    private TextField wayTextV;
    @FXML
    private TextField wayTextT;
    @FXML
    private TextField wayTextD;

    private String mainPath;
    private String musicPath;
    private String videoPath;
    private String textPath;
    private String docPath;

    DirectoryChooser fileopen;

    @FXML
    public void onClickMethodWayButton(){

        DirectoryChooser fileopen = new DirectoryChooser();
        wayText.setText(fileopen.showDialog(null).toString());
        mainPath = wayText.getText().toString();

    }

    public void onClickMethodWayMButton(){

        DirectoryChooser fileopen = new DirectoryChooser();
        wayTextM.setText(fileopen.showDialog(null).toString());
        musicPath = wayText.getText().toString();
    }

    public void onClickMethodWayVButton(){

        DirectoryChooser fileopen = new DirectoryChooser();
        wayTextV.setText(fileopen.showDialog(null).toString());
        videoPath = wayText.getText().toString();
    }

    public void onClickMethodWayTButton(){

        DirectoryChooser fileopen = new DirectoryChooser();
        wayTextT.setText(fileopen.showDialog(null).toString());
        textPath = wayText.getText().toString();
    }

    public void onClickMethodWayDButton(){

        DirectoryChooser fileopen = new DirectoryChooser();
        wayTextD.setText(fileopen.showDialog(null).toString());
        docPath = wayText.getText().toString();
    }

    public void onClickMethodSortButton(){
        System.out.println(mainPath);
        AllFunctions.search(mainPath);
    }

}
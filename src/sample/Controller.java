package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML
    private Button waybutton;
    @FXML
    private Button sortButton;
    @FXML
    private Button historyButton;
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

        fileopen = new DirectoryChooser();
        wayText.setText(fileopen.showDialog(null).toString());
        mainPath = wayText.getText().toString();

    }

    public void onClickMethodWayMButton(){

        fileopen = new DirectoryChooser();
        musicPath = fileopen.showDialog(null).toString();
        wayTextM.setText(musicPath);
        System.out.println(musicPath);
    }

    public void onClickMethodWayVButton(){

        fileopen = new DirectoryChooser();
        wayTextV.setText(fileopen.showDialog(null).toString());
        videoPath = wayText.getText().toString();
    }

    public void onClickMethodWayTButton(){

        DirectoryChooser fileopen = new DirectoryChooser();
        wayTextT.setText(fileopen.showDialog(null).toString());
        textPath = wayText.getText().toString();
    }

    public void onClickMethodWayDButton(){

        fileopen = new DirectoryChooser();
        wayTextD.setText(fileopen.showDialog(null).toString());
        docPath = wayText.getText().toString();
    }

    public void onClickMethodSortButton() throws IOException{
        System.out.println(mainPath);
        AllFunctions.search(mainPath, musicPath, videoPath, textPath, docPath);
    }

    public void onClickMethodHistoryButton(ActionEvent event) throws IOException{
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("history.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Automizer | History");
        stage.setScene(scene);
        stage.setMaxWidth(620);
        stage.setMaxHeight(380);
        stage.setMinWidth(620);
        stage.setMinHeight(380);
        stage.show();
    }
}
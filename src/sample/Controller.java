package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {

    @FXML private TextField wayText;
    @FXML private TextField wayTextM;
    @FXML private TextField wayTextV;
    @FXML private TextField wayTextT;
    @FXML private TextField wayTextD;

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
        Sample.search(mainPath, musicPath, videoPath, textPath, docPath);
    }

    public void onClickMethodParantalControlButton(ActionEvent event) throws IOException{
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("parantal control.fxml"));
        Scene scene = new Scene(root);
        ParantalControl pc = new ParantalControl();
        stage.setTitle("Automizer | Parantal Control");
        stage.setScene(scene);
        stage.setMaxWidth(336);
        stage.setMaxHeight(400);
        stage.setMinWidth(336);
        stage.setMinHeight(400);
        stage.show();
    }

    public void onClickMethodTimerPowerButton(ActionEvent event) throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("power.fxml"));
        Scene scene = new Scene(root);
        Power p = new Power();
        stage.setTitle("Automizer | Timer");
        stage.setScene(scene);
        stage.setMaxWidth(306);
        stage.setMaxHeight(200);
        stage.setMinWidth(306);
        stage.setMinHeight(200);
        stage.show();

    }

    public void onClickMethodHistoryButton(ActionEvent event) throws IOException{
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("history.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Automizer | History");
        stage.setScene(scene);
        stage.setMaxWidth(336);
        stage.setMaxHeight(400);
        stage.setMinWidth(336);
        stage.setMinHeight(400);
        stage.show();
    }
}
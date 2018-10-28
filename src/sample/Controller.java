package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    DirectoryChooser fileopen = new DirectoryChooser();

    /***
     * Method allows user to do something
     */
    @FXML
    public void onClickMethodWayButton() {
        wayText.setText(fileopen.showDialog(null).toString());
        mainPath = wayText.getText().toString();
    }

    public void onClickMethodWayMButton(){
        musicPath = fileopen.showDialog(null).toString();
        wayTextM.setText(musicPath);
    }

    public void onClickMethodWayVButton(){

        fileopen = new DirectoryChooser();
        videoPath = fileopen.showDialog(null).toString();
        wayTextV.setText(videoPath);
    }

    public void onClickMethodWayTButton(){
        DirectoryChooser fileopen = new DirectoryChooser();
        textPath = fileopen.showDialog(null).toString();
        wayTextT.setText(textPath);
    }

    public void onClickMethodWayDButton(){

        fileopen = new DirectoryChooser();
        docPath = fileopen.showDialog(null).toString();
        wayTextD.setText(docPath);
    }

    public void onClickMethodSortButton(){
        System.out.println(mainPath);
        Date date = new Date();
        Sample sam = new Sample();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        DataBase.insertInfo(mainPath, formatDate.format(date));
        System.out.println(musicPath);
        System.out.println(videoPath);
        System.out.println(textPath);
        try {
            sam.search(mainPath, musicPath, videoPath, textPath, docPath);
        }
        catch (IOException e){e.printStackTrace();}
    }

    public void onClickMethodParantalControlButton() throws IOException{
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("parantal control.fxml"));
        Scene scene = new Scene(root);
       // ParantalControl pc = new ParantalControl();
        stage.setTitle("Automizer | Parantal Control");
        stage.setScene(scene);
        stage.setMaxWidth(336);
        stage.setMaxHeight(400);
        stage.setMinWidth(336);
        stage.setMinHeight(400);
        stage.show();
    }

    public void onClickMethodTimerPowerButton() throws IOException{
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

    public void onClickMethodHistoryButton() throws IOException{
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
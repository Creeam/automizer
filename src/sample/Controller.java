package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Controller implements Initializable{

    @FXML private TextField wayText;
    @FXML private TextField wayTextM;
    @FXML private TextField wayTextV;
    @FXML private TextField wayTextT;
    @FXML private TextField wayTextO;

    private String mainPath;
    private String musicPath;
    private String videoPath;
    private String textPath;
    private String otherPath;

    DirectoryChooser fileopen;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        fileopen = new DirectoryChooser();
        readPathsFromFile();
    }

    /***
     * Method allows user to do something
     */
    public void onClickMethodWayButton() {
        wayText.setText(fileopen.showDialog(null).toString());
        mainPath = wayText.getText().toString();
    }

    /***
     * Method allows user to do something on music path button
     */
    public void onClickMethodWayMButton(){
        musicPath = fileopen.showDialog(null).toString();
        wayTextM.setText(musicPath);
    }

    /***
     * Method allows user to do something on video path button
     */
    public void onClickMethodWayVButton(){
        videoPath = fileopen.showDialog(null).toString();
        wayTextV.setText(videoPath);
    }

    /***
     * Method allows user to do something on text path button
     */
    public void onClickMethodWayTButton(){
        textPath = fileopen.showDialog(null).toString();
        wayTextT.setText(textPath);
    }

    /***
     * Method allows user to do something on document path button
     */
    public void onClickMethodWayOButton(){
        otherPath = fileopen.showDialog(null).toString();
        wayTextO.setText(otherPath);
    }

    /***
     * Method allows user to do something on sort button
     */
    public void onClickMethodSortButton(){
        System.out.println(mainPath);
        Date date = new Date();
        Sample sam = new Sample();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        DataBase.conn();
        DataBase.createDB();
        DataBase.insertInfo(mainPath, formatDate.format(date));
        System.out.println(musicPath);
        System.out.println(videoPath);
        System.out.println(textPath);
        try {
            sam.search(mainPath, musicPath, videoPath, textPath, otherPath);
            writePathsInFile();
            DataBase.closeConnection();
        }
        catch (IOException e){e.printStackTrace();}
    }

    /***
     * Method allows user to do something on parantal control button
     */
    public void onClickMethodParantalControlButton() throws IOException{
        Stage stage = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("parantal control.fxml"));
        Scene scene = new Scene(root);
       // ParantalControl pc = new ParantalControl();
        stage.setTitle("Automizer | Parantal Control");
        stage.setScene(scene);
        stage.setMaxWidth(490);
        stage.setMaxHeight(225);
        stage.setMinWidth(490);
        stage.setMinHeight(225);
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
        stage.setMinWidth(450);
        stage.setMinHeight(450);
        stage.show();
    }

    public void writePathsInFile(){
        try {
            FileWriter writer = new FileWriter("settings.dll");
            writer.write(this.mainPath + "\n");
            writer.write(this.musicPath + "\n");
            writer.write(this.videoPath + "\n");
            writer.write(this.textPath + "\n");
            writer.write(this.otherPath + "\n");
            writer.close();
        }
        catch (IOException e){
            System.out.println("Ошибка записи!");
            e.printStackTrace();
        }
    }

    public void readPathsFromFile(){
        try {
            FileReader reader = new FileReader("settings.dll");
            Scanner scan = new Scanner(reader);

            this.mainPath = scan.next();
            this.musicPath = scan.next();
            this.videoPath = scan.next();
            this.textPath = scan.next();
            this.otherPath = scan.next();

            System.out.println(mainPath + "\n" + musicPath + "\n" + videoPath + "\n" + textPath + "\n" + otherPath);

            wayText.setText(mainPath);
            wayTextM.setText(musicPath);
            wayTextV.setText(videoPath);
            wayTextT.setText(textPath);
            wayTextO.setText(otherPath);

            reader.close();
        }
        catch (IOException e){
            System.out.println("Ошибка считывания из файла!");
            e.printStackTrace();
        }
    }
}
package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import services.database.DataBase;
import sources.Sort;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;


public class MainController implements Initializable{

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

    DirectoryChooser fileOpen;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        fileOpen = new DirectoryChooser();
        readPathsFromFile();
        System.out.println(System.getProperty("os.name"));
    }

    /***
     * Method allows user to do something
     */
    public void onClickMethodWayButton() {
        wayText.setText(fileOpen.showDialog(null).toString());
        mainPath = wayText.getText().toString();
    }

    /***
     * Method allows user to do something on music path button
     */
    public void onClickMethodWayMButton(){
        musicPath = fileOpen.showDialog(null).toString();
        wayTextM.setText(musicPath);
    }

    /***
     * Method allows user to do something on video path button
     */
    public void onClickMethodWayVButton(){
        videoPath = fileOpen.showDialog(null).toString();
        wayTextV.setText(videoPath);
    }

    /***
     * Method allows user to do something on text path button
     */
    public void onClickMethodWayTButton(){
        textPath = fileOpen.showDialog(null).toString();
        wayTextT.setText(textPath);
    }

    /***
     * Method allows user to do something on document path button
     */
    public void onClickMethodWayOButton(){
        otherPath = fileOpen.showDialog(null).toString();
        wayTextO.setText(otherPath);
    }

    /***
     * Method allows user to do something on sort button
     */
    public void onClickMethodSortButton(){
        System.out.println(mainPath);
        Date date = new Date();
        Sort sam = new Sort();
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        DataBase.conn();
        DataBase.createDB();
        DataBase.insertInfo(mainPath, formatDate.format(date));
        System.out.println(musicPath);
        System.out.println(videoPath);
        System.out.println(textPath);
        sam.search(mainPath, musicPath, videoPath, textPath, otherPath);
        writePathsInFile();
        DataBase.closeConnection();
    }

    /***
     * Method allows user to do something on parantal control button
     */
    public void onClickMethodParantalControlButton(){
        Stage stage = new Stage();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../views/parantal control.fxml"));
            Scene scene = new Scene(root);
            // ParantalControl pc = new ParantalControl();
            stage.setTitle("Automizer | Parantal Control");
            stage.setScene(scene);
            stage.setMaxWidth(490);
            stage.setMaxHeight(260);
            stage.setMinWidth(490);
            stage.setMinHeight(260);
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onClickMethodTimerPowerButton() throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../views/power.fxml"));
        Scene scene = new Scene(root);
        PowerController p = new PowerController();
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
        Parent root = FXMLLoader.load(getClass().getResource("../views/history.fxml"));
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
        }
    }
}
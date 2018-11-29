package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HistoryController implements Initializable{
    @FXML private TextArea TA;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        TA.setText("TEST");
        DataBase.conn();
        DataBase.createDB();
        DataBase.insertIntoArea(TA);
        DataBase.closeConnection();
    }




}
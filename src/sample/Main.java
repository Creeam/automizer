package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        DataBase.Conn();
        DataBase.CreateDB();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Automizer");
        primaryStage.setScene(new Scene(root, 620, 380));
        primaryStage.setMaxWidth(620);
        primaryStage.setMaxHeight(420);
        primaryStage.setMinWidth(620);
        primaryStage.setMinHeight(420);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

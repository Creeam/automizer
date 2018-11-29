package sample;

import javafx.scene.control.TextArea;

import java.sql.*;

public class DataBase {

    private static Connection conn;
    private static Statement statmt;
    private static Statement statementForArea;
    private static ResultSet resSet;
    private static ResultSet resultSetForArea;


    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void conn(){
        conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:DateBase.db");
        }
        catch (SQLException e){
            System.out.println("Error connect to DataBase!");
            e.printStackTrace();
        }

        System.out.println("База Подключена!");
    }

    // --------Создание таблицы--------
    public static void createDB(){
        try {
            statmt = conn.createStatement();
            statementForArea = conn.createStatement();
            statmt.execute("CREATE TABLE if not exists 'Changes' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'Path' text, 'Date' text);");
            statmt.execute("CREATE TABLE if not exists 'Paths' ('id' INTEGER, 'Path' text);");
        }
        catch (SQLException e){
            System.out.println("Error to create a table!");
            e.printStackTrace();
        }
        System.out.println("Таблица создана или уже существует.");
    }

    // --------Заполнение таблицы Changes--------
    public static void insertInfo(String path, String date){
        try {
            statmt.execute("INSERT INTO Changes (Path, Date) VALUES ('"+ path +"', '"+ date +"');");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertPaths(String path, String pathOfFile){
        try {
            String id = "";
            resSet = statmt.executeQuery("SELECT id FROM Changes WHERE Path = '"+ path +"'");
            while(resSet.next()){
                id = resSet.getString("id");
            }
            System.out.println("ID: " + id);
            statmt.execute("INSERT INTO Paths (id, Path) VALUES ('"+ Integer.parseInt(id) +"', '"+ pathOfFile +"')");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertIntoArea(TextArea TA){
        try {
            int id;
            String path = "";
            String date = "";
            resSet = statmt.executeQuery("SELECT id, Path, Date FROM Changes");
            while (resSet.next()){

                id = resSet.getInt("id");
                path = resSet.getString("Path");
                date = resSet.getString("Date");

                System.out.println(path + "   " + date);
                TA.setText(TA.getText() + path + "   " + date + "\n\n");
                resultSetForArea = statementForArea.executeQuery("SELECT Path FROM Paths WHERE id = '"+ id +"'");
                while (resultSetForArea.next()){
                    System.out.println("        " + resultSetForArea.getString("Path"));
                    TA.setText( TA.getText() +"\n        " + resultSetForArea.getString("Path"));
                }
                TA.setText(TA.getText() + "\n\n\n");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    // --------Закрытие соединения с БД--------
    public static void closeConnection() {
        try {
            conn.close();
            System.out.println("Соединение с БД закрыто.");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
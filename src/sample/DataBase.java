package sample;

import java.sql.*;

public class DataBase {

    private static Connection conn;
    private static Statement statmt;
    private static ResultSet resSet;


    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn(){
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
    public static void CreateDB(){
        try {
            statmt = conn.createStatement();
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
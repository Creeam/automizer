package sample;

import java.sql.*;

public class DataBase {

    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;
    private DataBase INSTANCE;

    public DataBase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataBase();
        }
        return INSTANCE;
    }

    private DataBase() {

    }

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


}
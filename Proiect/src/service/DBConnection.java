package service;

import java.sql.*;
public class DBConnection {
    private static final String URL = "jdbc:oracle:thin:@localhost:1522:XE";
    private static final String USER = "Serban";
    private static final String PASSWROD = "Gherut09";

    private static Connection conn;
    private static DBConnection instance;

    private DBConnection(){
        try{
            conn = DriverManager.getConnection(URL, USER, PASSWROD);
            if(conn != null)
                System.out.println("Te-ai conectat la baza de date");
        } catch(SQLException ex){
            System.out.println("Error connectiong to database" + ex.getMessage());
        }
    }
    public static DBConnection getInstance(){
        if(instance == null){
            instance = new DBConnection();
        }
        return instance;
    }

    public static Connection getContext(){
        return conn;
    }
    public static void setContext(Connection context){
        DBConnection.conn = context;
    }
    public static void setInstance(DBConnection instance){
        DBConnection.instance = instance;
    }
}
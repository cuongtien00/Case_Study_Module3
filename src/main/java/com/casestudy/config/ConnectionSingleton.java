package com.casestudy.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
    private static Connection connection;

    private ConnectionSingleton() {
    }
    public static final String URL = "jdbc:mysql://localhost:3306/case_study_module3";
    public static final String USER = "root";
    public static final String PASSWORD = "tuanbenguyen23101997";
    public static Connection getConnection(){
        if(connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
                System.out.println("Connect success!");
            } catch (ClassNotFoundException | SQLException e){
                System.out.println("Connect MYSQL failed!");
                e.printStackTrace();
            }
        }
        return connection;
    }
}

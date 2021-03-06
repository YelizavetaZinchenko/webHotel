package com.ua.zinchenko.db.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class DBManager {

    private static Connection conn = null;
    private static final Properties properties = new Properties();
    private static final String URL = "jdbc:mysql://localhost:3306/hotel?user=root&password=root&" +
            "serverTimezone=Europe/Kiev&useSSL=false";

    public DBManager() {
    }

    public static Connection getConnection() {
        properties.setProperty("useUnicode", "true");
        properties.setProperty("characterEncoding", "UTF-8");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            conn = DriverManager.getConnection(URL, properties);
        } catch (Exception exception) {
            Logger.getLogger(exception.getMessage());
        }
        return conn;
    }
}

package de.jan2k17.coins.main.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import de.jan2k17.coins.main.data.ConfigManager;

public class MySQL {
  public static Connection con;
  
  public static void connect() {
    if (!isConnected()) {
      try {
        con = DriverManager.getConnection("jdbc:mysql://" + ConfigManager.host + ":3306/" + ConfigManager.database + "?autoReconnect=true", ConfigManager.username, ConfigManager.password);
        System.out.println("MySQL Verbindung aufgebaut!");
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    }
  }
  
  public static void disconnect() {
    if (isConnected()) {
      try {
        con.close();
        System.out.println("MySQL Verbindung getrennt!");
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    }
  }

  
  public static boolean isConnected() { return (con != null); }

  
  public static void createTable() {
    try {
      con.prepareStatement("CREATE TABLE `coinsTable` (\r\n" + 
      		"  `id` int(11) NOT NULL,\r\n" + 
      		"  `UUID` varchar(100) DEFAULT NULL,\r\n" + 
      		"  `coins` int(16) DEFAULT '0'\r\n" + 
      		") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;").executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
}
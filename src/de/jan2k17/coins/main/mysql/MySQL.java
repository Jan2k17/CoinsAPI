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
        con = DriverManager.getConnection("jdbc:mysql://" + ConfigManager.host + ":" + ConfigManager.port + "/" + ConfigManager.database + "?autoReconnect=true", ConfigManager.username, ConfigManager.password);
        
        if(ConfigManager.sprache == "de") {
        	System.out.println("MySQL Verbindung aufgebaut!");
        } else if(ConfigManager.sprache == "en") {
        	System.out.println("MySQL connected!");
        }
      
      } catch (SQLException e) {
        e.printStackTrace();
      } 
    }
  }
  
  public static void disconnect() {
    if (isConnected()) {
      try {
        con.close();
        if(ConfigManager.sprache == "de") {
        System.out.println("MySQL Verbindung getrennt!");
        } else if(ConfigManager.sprache == "en") {
        	System.out.println("MySQL disconnected!");
        }
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
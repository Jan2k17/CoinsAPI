package de.jan2k17.coins.main.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import de.jan2k17.coins.main.mysql.MySQL;

public class CoinsAPI {
	public static int getCoins(String uuid) {
		try {
			PreparedStatement st = MySQL.con.prepareStatement("SELECT coins FROM coinsTable WHERE UUID = ?");
			st.setString(1, uuid);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt("coins");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return 0;
	}
	
	public static void setCoins(String uuid, int coins) {
		if (getCoins(uuid) == 0) {
			try {
				PreparedStatement st = MySQL.con.prepareStatement("INSERT INTO coinsTable (UUID,coins) VALUES (?,?)");
				st.setString(1, uuid);
				st.setInt(2, coins);
				st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} else {
			PreparedStatement st = null;
			try {
				st = MySQL.con.prepareStatement("UPDATE coinsTable SET coins = ? WHERE UUID = ?");
				st.setString(2, uuid);
				st.setInt(1, coins);
				st.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		} 
	}
	
	public static void addCoins(String uuid, int coins) {
		int current = getCoins(uuid);
		setCoins(uuid, coins + current);
	}
	
	
	public static void removeCoins(String uuid, int coins) {
		setCoins(uuid, getCoins(uuid) - coins);
	}
}
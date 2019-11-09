package de.jan2k17.coins.main;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import de.jan2k17.coins.main.Commands.CMD_Coins;
import de.jan2k17.coins.main.data.ConfigManager;
import de.jan2k17.coins.main.mysql.MySQL;

public class Main extends JavaPlugin{
	
	public static Plugin plugin;
	public static String prefix = ChatColor.GREEN + "[Coins] " + ChatColor.RESET;
	
	@Override
	public void onEnable() {
		
	    loadConfig();
	    getConfig().options().copyDefaults(true);
	    saveDefaultConfig();
	    MySQL.connect();
	    MySQL.createTable();
	    
	    getCommand("coins").setExecutor(new CMD_Coins());
	    
	}


	@Override
	public void onDisable() {
		
		MySQL.disconnect();
		
	}

	  
	public void loadConfig() {
		
		ConfigManager.host = getConfig().getString("Host");
	    ConfigManager.database = getConfig().getString("Database");
	    ConfigManager.username = getConfig().getString("Username");
	    ConfigManager.password = getConfig().getString("Password");
	    ConfigManager.sprache = getConfig().getString("Language");
	    
	}
	
}

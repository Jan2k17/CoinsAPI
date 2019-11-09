package de.jan2k17.coins.main.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.jan2k17.coins.main.Main;
import de.jan2k17.coins.main.data.CoinsAPI;
import de.jan2k17.coins.main.data.ConfigManager;


public class CMD_Coins implements CommandExecutor {
	public boolean onCommand(CommandSender cs, Command cmd, String arg2, String[] args) {
    if (cs instanceof Player) {
    	Player player = (Player)cs;
      
    	if (player.hasPermission("jan2k17.coins.admin")) {
    		if (args.length == 3) {
    			Player target = Bukkit.getPlayerExact(args[1]);
    			int coins = Integer.valueOf(args[2]).intValue();
    			
    			if (args[0].equalsIgnoreCase("add")) {
    				if (coins < 0) {
    					if(ConfigManager.sprache == "de") {
        					player.sendMessage(Main.prefix + ChatColor.RED + "Du musst einen Höheren Betrag angeben!");
        					return true;
    					} else if(ConfigManager.sprache == "en") {
    						player.sendMessage(Main.prefix + ChatColor.RED + "You need to enter a higher amount!");
    						return true;
    					}
    				} 
            
    				CoinsAPI.addCoins(target.getUniqueId().toString(), coins);
    				if(ConfigManager.sprache == "de") {
    					target.sendMessage(Main.prefix + ChatColor.GREEN + "Dir wurden " + coins + " Coins hinzugefügt");
    				} else if(ConfigManager.sprache == "en") {
    					target.sendMessage(Main.prefix + ChatColor.GREEN + "Your account has been added " + coins + " Coins");
    				}
    			} else if (args[0].equalsIgnoreCase("set")) {
    				if (coins < 0) {
    					if(ConfigManager.sprache == "de") {
    						player.sendMessage(Main.prefix + ChatColor.RED + "Du musst einen Höheren Betrag angeben!");
    						return true;
    					} else if(ConfigManager.sprache == "en") {
    						player.sendMessage(Main.prefix + ChatColor.RED + "You need to enter a higher amount!");
    						return true;
    					}
    				} 
    				
    				CoinsAPI.setCoins(target.getUniqueId().toString(), coins);
    				if(ConfigManager.sprache == "de") {
    					target.sendMessage(Main.prefix + ChatColor.GREEN + "Deine Coins wurden auf " + coins + " Coins gesetzt!");
    				} else if(ConfigManager.sprache == "en") {
    					target.sendMessage(Main.prefix + ChatColor.GREEN + "Your coins has been set to " + coins + " Coins!");
    				}
    			} else if (args[0].equalsIgnoreCase("remove")) {
    				if (coins < 0) {
    					if(ConfigManager.sprache == "de") {
	    					player.sendMessage(Main.prefix + ChatColor.RED + "Du musst einen Höheren Betrag angeben!");
	    					return true;
    					} else if(ConfigManager.sprache == "en") {
    						player.sendMessage(Main.prefix + ChatColor.RED + "You need to enter a higher amount!");
        					return true;
    					}
    				} 
    				
    				CoinsAPI.removeCoins(target.getUniqueId().toString(), coins);
    				if(ConfigManager.sprache == "de") {
    					target.sendMessage(Main.prefix + ChatColor.RED + "Dir wurden " + coins + " Coins entfernt");
    				} else if(ConfigManager.sprache == "en") {
    					target.sendMessage(Main.prefix + ChatColor.RED + "Your account has been added \" + coins + \" Coins");
    				}
    			} 
    		} else if (args.length == 1) {
    			if (args[0].equalsIgnoreCase("?")) {
    				player.sendMessage(Main.prefix + "/coins ?");
    				player.sendMessage(Main.prefix + "/coins help");
    				player.sendMessage(Main.prefix + "/coins <add/set/remove> <Name> <Coins>");
    				player.sendMessage(Main.prefix + "/coins see <Name>");
    				player.sendMessage(Main.prefix + "/coins");
    			} else if (args[0].equalsIgnoreCase("help")) {
    				player.sendMessage(Main.prefix + "/coins ?");
    				player.sendMessage(Main.prefix + "/coins help");
    				player.sendMessage(Main.prefix + "/coins <add/set/remove> <Name> <Coins>");
    				player.sendMessage(Main.prefix + "/coins see <Name>");
    				player.sendMessage(Main.prefix + "/coins");
    			}
    		} else if (args.length == 2) {
    			if (args[0].equalsIgnoreCase("see")) {
    				Player target = Bukkit.getPlayerExact(args[1]);
    				if(ConfigManager.sprache == "de") {
    					player.sendMessage(Main.prefix + "Der Spieler " + target.getName() + " hat " + CoinsAPI.getCoins(target.getUniqueId().toString()) + " Coins");
    				} else if(ConfigManager.sprache == "en") {
    					player.sendMessage(Main.prefix + "The player " + target.getName() + " have " + CoinsAPI.getCoins(target.getUniqueId().toString()) + " Coins");
    				}
    			}
    		} else {
    			if(ConfigManager.sprache == "de") {
    				player.sendMessage(Main.prefix + "Deine Coins: " + CoinsAPI.getCoins(player.getUniqueId().toString()));
    			} else if(ConfigManager.sprache == "en") {
    				player.sendMessage(Main.prefix + "Your Coins: " + CoinsAPI.getCoins(player.getUniqueId().toString()));
    			}
    		} 
    	} else {
    		if(ConfigManager.sprache == "de") {
    			player.sendMessage(Main.prefix + "Deine Coins: " + CoinsAPI.getCoins(player.getUniqueId().toString()));
    		} else if(ConfigManager.sprache == "en") {
    			player.sendMessage(Main.prefix + "Your Coins: " + CoinsAPI.getCoins(player.getUniqueId().toString()));
    		}
    	} 
    }  return false;
  }
}
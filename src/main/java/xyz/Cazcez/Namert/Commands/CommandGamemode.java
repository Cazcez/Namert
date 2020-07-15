package xyz.Cazcez.Namert.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sun.istack.internal.NotNull;

import xyz.Cazcez.Namert.Main;

public class CommandGamemode implements CommandExecutor 
{

    Main main;

    public CommandGamemode(Main main) 
    {
        this.main=main;
    }
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) 
    {
    	Player player;
    	String gamemode = null;
    	
    	if (args.length == 0 || args.length <= 3)
    	{
    		sender.sendMessage("You should set some true arguments");
    		return true;
    	}
    	else if (args.length == 2)
    	{
    		player = org.bukkit.Bukkit.getPlayer(args[0]);
    		gamemode = args[1];
    	}
    	else
    	{
    		player = (Player)sender;
    		gamemode = args[0];
    	}
    	
    	if (gamemode.equalsIgnoreCase("0") || gamemode.equalsIgnoreCase("survival"))
    		player.setGameMode(GameMode.SURVIVAL);
    	else if (gamemode.equalsIgnoreCase("1") || gamemode.equalsIgnoreCase("creative"))
    		player.setGameMode(GameMode.CREATIVE);
    	else if (gamemode.equalsIgnoreCase("2") || gamemode.equalsIgnoreCase("spectator"))
    		player.setGameMode(GameMode.SPECTATOR);
    	else if (gamemode.equalsIgnoreCase("3") || gamemode.equalsIgnoreCase("adventurer") || gamemode.equalsIgnoreCase("adventure"))
    		player.setGameMode(GameMode.ADVENTURE);    	
    	
		player.sendMessage("Your gamemode updated!");
    	return true;
    }
    
}
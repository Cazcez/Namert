package xyz.Cazcez.Namert.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import com.google.inject.Inject;

import xyz.Cazcez.Namert.Config;
import xyz.Cazcez.Namert.Main;
import xyz.Cazcez.Namert.Messages;

public class CommandSpeed implements CommandExecutor 
{

    @Inject
    Main main;
    @Inject
    Config conf;
    @Inject
    Messages msg;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args)
    {    	
    	
    	float speed;
    	
    	if (args.length == 1)
    	{  	    
        	speed = getSpeed(args[0], sender);
        	
        	setSpeed((Player)sender, sender, speed, true);
    	}
    	if (args.length == 2)
    	{
            if(Bukkit.getPlayer(args[0]) == null)
        	{
        		sender.sendMessage(String.format(msg.PLAYER_DOES_NOT_EXIST, args[0]));
        		return true;
        	}
            
        	speed = getSpeed(args[1], sender);
        	
        	setSpeed(Bukkit.getPlayer(args[1]), sender, speed, false);    		
    	}
    	
    	
    	return true;
    }
    
    void setSpeed(Player player, CommandSender sender, Float speed, boolean samePerson)
    {
    	if (speed == 100000.00f)
    	{
    		sender.sendMessage(msg.MUST_BE_NUMERIC);
    		return;
    	}
    		
    	if (player.isFlying())
    		player.setFlySpeed(speed); 
    	else
    		player.setWalkSpeed(speed);
    	
    	player.sendMessage(String.format(msg.NEW_SPEED, speed));
    	
    	if (samePerson == false)
    		sender.sendMessage(String.format(msg.NEW_SPEED_PLAYER, player.getName(), speed));   

    }
    
    Float getSpeed(String str, CommandSender sender)
    {
    	Float speed = 100000.00f; //TODO FIX THIS MESS
	    try 
	    {
	        speed = Float.parseFloat(str);
	    }
	    catch (NumberFormatException nfe) 
	    {
	    	sender.sendMessage(msg.MUST_BE_NUMERIC);
	    
	    }
	    return speed;
    }
    
    
}

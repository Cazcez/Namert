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

public class CommandFly implements CommandExecutor 
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
    	if (args.length == 0)
    	{
            if(!(sender instanceof Player)) 
            {
                sender.sendMessage(msg.MUST_BE_PLAYER);
                return true;
            }
                        
            SwitchFlyMode((Player)sender, sender, true);
            
    	}
    	
    	if (args.length == 1)
    	{       
        	
            if(Bukkit.getPlayer(args[0]) == null)
        	{
        		sender.sendMessage(String.format(msg.PLAYER_DOES_NOT_EXIST, args[0]));
        		return true;
        	}
            
            SwitchFlyMode(Bukkit.getPlayer(args[0]), sender, false);      
    	}    	
    	
    	return false;
    }
    
	void SwitchFlyMode(Player p, CommandSender sender, boolean samePerson)
	{
		
        if(p.isFlying())
        {
            p.sendMessage(msg.NOT_FLYING);
        	p.setAllowFlight(false);
        	p.setFlying(false);
        	
        	if (samePerson==false)
        		sender.sendMessage(String.format(msg.NOT_FLYING_PLAYER, p.getName()));
        	
        	return;
        	

        }
        else
        {
            p.sendMessage(msg.FLYING);
        	p.setAllowFlight(true);  
        	p.setFlying(true);

        	
        	if (samePerson==false)
        		sender.sendMessage(String.format(msg.FLYING_PLAYER, p.getName()));
        	
        	return;      
        	
        }
	}

}

package xyz.Cazcez.Namert.Commands;

import com.google.inject.Inject;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;
import xyz.Cazcez.Namert.Config;
import xyz.Cazcez.Namert.Main;
import xyz.Cazcez.Namert.Messages;

public class CommandGamemode implements CommandExecutor 
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
        Player p;
        if(args.length==0) 
        {
            if(!(sender instanceof Player)) 
            {
                sender.sendMessage(msg.MUST_BE_PLAYER);
                return true;
            }
            
            dycleOwnGamemode((Player) sender);
            return true;
        }

        if(args.length==1) 
        {
            if(!(sender instanceof Player)) 
            {
                sender.sendMessage(msg.MUST_BE_PLAYER);
                return true;
            }
            
            changeGamemode((Player) sender, args[0]);
        }
        
        if(args.length==2)
        {
        	if(Bukkit.getPlayer(args[0]) == null)
        	{
        		sender.sendMessage(String.format(msg.PLAYER_DOES_NOT_EXIST, args[0]));
        		return true;
        	}
        	
            changeGamemode(Bukkit.getPlayer(args[0]), args[0]);
       	
        }


		return true;
    }
    
    void dycleOwnGamemode(Player p) 
    {
        GameMode g;
        switch(p.getGameMode()) 
        {
            case SURVIVAL:
                g = GameMode.CREATIVE;
                break;
            case CREATIVE:
                g = GameMode.ADVENTURE;
                break;
            case ADVENTURE:
                g = GameMode.SPECTATOR;
                break;
            default:
                g = GameMode.SURVIVAL;
        }
    }
    
    void changeGamemode(Player p, String s)
    {
        GameMode g;
        try 
        {
            g = string2gm(s);
            p.setGameMode(g);
            p.sendMessage(String.format(msg.GAMEMODE_YOU_ARE_NOW_IN,gm2string(p.getGameMode())));
        }
        
        catch(IllegalArgumentException e) 
        {
            p.sendMessage(msg.GAMEMODE_INVALID);
        }
    }
    
    GameMode string2gm(String s) throws IllegalArgumentException 
    {
        if(s=="0" || s.toLowerCase().startsWith("su")) return GameMode.SURVIVAL;
        if(s=="1" || s.toLowerCase().startsWith("c")) return GameMode.CREATIVE;
        if(s=="2" || s.toLowerCase().startsWith("a")) return GameMode.ADVENTURE;
        if(s=="3" || s.toLowerCase().startsWith("sp")) return GameMode.SPECTATOR;
        throw new IllegalArgumentException();
    }

    String gm2string(GameMode g)
    {
        switch(g) 
        {
            case SURVIVAL:
                return msg.GAMEMODE0;
            case CREATIVE:
                return msg.GAMEMODE1;
            case ADVENTURE:
                return msg.GAMEMODE2;
            case SPECTATOR:
                return msg.GAMEMODE3;
            default: //just for fixing error message #TODO
            	return msg.GAMEMODE0;
        }
    }    
}
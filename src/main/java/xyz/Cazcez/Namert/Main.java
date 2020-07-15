package xyz.Cazcez.Namert;

import org.bstats.bukkit.Metrics;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.Cazcez.Namert.Commands.CommandGamemode;

public class Main extends JavaPlugin
{
	
	CommandGamemode commandGamemode;

    public void onEnable() 
    {
        createConfig();
        registerMetrics();
        getServer().getPluginManager().registerEvents(new EventListener(this),this);
        getLogger().info(ChatColor.DARK_PURPLE + "Namert is enabled!");
        

    }

    void load()
    {
    	commandGamemode = new CommandGamemode(this);

    	
    	getCommand("gm").setExecutor(commandGamemode);
    	getCommand("gamemode").setExecutor(commandGamemode);

    }
    
    public void onDisable()
    {    	
        getLogger().info(ChatColor.DARK_PURPLE + "Namert is disabled!");
    }
    
    
    private void createConfig() 
    {
        saveDefaultConfig();
    }
    
    private void registerMetrics()
    {
        @SuppressWarnings("unused")
		Metrics metrics = new Metrics(this , 8198);
    }
}



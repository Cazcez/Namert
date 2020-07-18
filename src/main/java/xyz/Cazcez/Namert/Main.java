package xyz.Cazcez.Namert;

import com.google.inject.Inject;
import com.google.inject.Injector;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import xyz.Cazcez.Namert.Commands.CommandFly;
import xyz.Cazcez.Namert.Commands.CommandGamemode;
import xyz.Cazcez.Namert.Commands.CommandSpeed;

public class Main extends JavaPlugin
{
	
	@Inject
    CommandGamemode commandGamemode;
	
	@Inject
    CommandFly commandFly;
	
	@Inject
    CommandSpeed commandSpeed;
	
	@Inject
    PlayerJoinListener playerJoinListener;

	@Override
    public void onEnable() 
    {

        saveDefaultConfig();

        SimpleBinderModule module = new SimpleBinderModule(this);
        Injector injector = module.createInjector();
        injector.injectMembers(this);

        createConfig();
        getCommand("gamemode").setExecutor(commandGamemode);
        getCommand("fly").setExecutor(commandFly);
        getCommand("speed").setExecutor(commandSpeed);
        getLogger().info(ChatColor.DARK_PURPLE + "Namert is enabled!");
        System.out.println("Listener registered");
        getServer().getPluginManager().registerEvents(playerJoinListener,this);

    }
    
    public void onDisable()
    {    	
        getLogger().info(ChatColor.DARK_PURPLE + "Namert is disabled!");
    }
    
    
    private void createConfig() 
    {
        saveDefaultConfig();
    }

}



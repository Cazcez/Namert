package xyz.Cazcez.Namert;

import com.google.inject.Inject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener
{


    private Main main;
    private Config conf;

    @Inject
    public PlayerJoinListener(Main main, Config conf) {
        this.main=main;
        this.conf=conf;
        System.out.println("Listener created");
    }

    @EventHandler(ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent e) {
        System.out.println("WTF");

        e.getPlayer().sendMessage("asd");
        e.getPlayer().sendMessage(String.format(conf.getJoinMessage(),e.getPlayer().getName()));
    }
    


}

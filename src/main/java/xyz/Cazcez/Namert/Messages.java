package xyz.Cazcez.Namert;

import com.google.inject.Inject;
import org.bukkit.ChatColor;

public class Messages {

    private Main main;

    public final String PLAYER_DOES_NOT_EXIST,MUST_BE_PLAYER,GAMEMODE_INVALID,GAMEMODE_YOU_ARE_NOW_IN,GAMEMODE0,GAMEMODE1,GAMEMODE2,GAMEMODE3;

    @Inject
    Messages(Main main) {
        this.main=main;

        GAMEMODE_INVALID= ChatColor.RED+"Invalid gamemode: %s";
        GAMEMODE_YOU_ARE_NOW_IN = ChatColor.GRAY + "You are now in " + ChatColor.GOLD + "%s" + ChatColor.GRAY + ".";
        GAMEMODE0 = "survival mode";
        GAMEMODE1 = "creative mode";
        GAMEMODE2 = "adventure mode";
        GAMEMODE3 = "spectator mode";

        MUST_BE_PLAYER = "You must be a player to run this command.";
        PLAYER_DOES_NOT_EXIST = "%s is not an existing player.";

    }


}

package xyz.Cazcez.Namert;

import javax.inject.Inject;

public class Config {

    @Inject
    private Main main;

    String getLanguage() {
        return main.getConfig().getString("language");
    }

    String getJoinMessage() {
        return main.getConfig().getString("join-message");
    }
}

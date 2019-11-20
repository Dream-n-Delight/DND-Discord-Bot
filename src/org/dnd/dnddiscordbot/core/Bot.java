package org.dnd.dnddiscordbot.core;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.dnd.dnddiscordbot.configuration.Config;
import org.dnd.dnddiscordbot.hooks.ActionHook;
import org.dnd.dnddiscordbot.hooks.CommandHook;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Bot {

    private static JDA jda;
    private static Config configuration;

    public static void main(String[] args) throws LoginException, IOException {

        initializeObjects();

        jda = new JDABuilder(configuration.getBotToken())
                .addEventListeners(
                        new CommandHook(),
                        new ActionHook()
                )
                .build();
    }

    private static void initializeObjects(){
        configuration = new Config();
    }
}

package org.dnd.dnddiscordbot.core;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.dnd.dnddiscordbot.configuration.Config;
import org.dnd.dnddiscordbot.exceptions.BotTokenException;
import org.dnd.dnddiscordbot.hooks.ActionHook;
import org.dnd.dnddiscordbot.hooks.CommandHook;

import javax.security.auth.login.LoginException;
import java.io.IOException;

public class Bot {

    public static JDA jda;

    private static Config configuration;
    private static Logger logger;

    public static void main(String[] args) throws IOException {

        initializeObjects();

        try {
            jda = new JDABuilder(configuration.getBotToken())
                    .addEventListeners(
                            new CommandHook(),
                            new ActionHook()
                    )
                    .build();
        } catch (LoginException e) {
            logger.log(new BotTokenException());
            System.exit(1);
        }
    }

    private static void initializeObjects() throws IOException {
        configuration = new Config();
        logger = new Logger();
    }
}

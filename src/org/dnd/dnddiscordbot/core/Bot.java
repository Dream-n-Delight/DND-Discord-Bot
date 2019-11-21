package org.dnd.dnddiscordbot.core;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.dnd.dnddiscordbot.command.Command;
import org.dnd.dnddiscordbot.tools.ConfigManager;
import org.dnd.dnddiscordbot.exceptions.BotTokenException;
import org.dnd.dnddiscordbot.hooks.ActionHook;
import org.dnd.dnddiscordbot.hooks.CommandHook;

import javax.security.auth.login.LoginException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bot {

    public static JDA jda;

    private static ConfigManager configuration;
    private static Logger logger;

    public static List<Command> commands;

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
        configuration = new ConfigManager();
        logger = new Logger();

        Command.commands = new ArrayList<>();
    }

    public static ConfigManager getConfiguration(){
        return configuration;
    }
}

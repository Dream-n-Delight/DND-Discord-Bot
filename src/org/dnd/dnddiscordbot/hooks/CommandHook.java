package org.dnd.dnddiscordbot.hooks;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.dnd.dnddiscordbot.command.Command;
import org.dnd.dnddiscordbot.core.Bot;
import org.dnd.dnddiscordbot.modules.moderation.Ban;
import org.dnd.dnddiscordbot.modules.moderation.Kick;

import javax.annotation.Nonnull;
import java.io.IOException;

public class CommandHook extends ListenerAdapter {

    public static Command ban;
    public static Command kick;


    public CommandHook(){
        ban = new Command("ban").register();
        kick = new Command("kick").register();
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        initializeCommandActions(event);

        try {
            String prefix = Bot.getConfiguration().getPrefix();
            String message = event.getMessage().getContentRaw();
            String[] args = message.split(" ");
            String commandLabel = args[0].replaceFirst("!", "");

            if (event.getAuthor().equals(event.getJDA().getSelfUser()) || event.getAuthor().isBot() || event.getAuthor().isFake()) return;
            if (!event.getMessage().getContentRaw().startsWith(prefix)) return;


            for (Command command : Command.commands){
                if (commandLabel.equalsIgnoreCase(command.getLabel())){
                    command.getAction().call(args);
                    break;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeCommandActions(MessageReceivedEvent event){
        ban.setAction(new Ban(event));
        kick.setAction(new Kick(event));
    }
}

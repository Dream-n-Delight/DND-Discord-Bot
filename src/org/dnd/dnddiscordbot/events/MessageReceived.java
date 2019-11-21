package org.dnd.dnddiscordbot.events;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.dnd.dnddiscordbot.command.Command;
import org.dnd.dnddiscordbot.core.Bot;
import org.dnd.dnddiscordbot.modules.moderation.Ban;
import org.dnd.dnddiscordbot.modules.moderation.Kick;

import java.io.IOException;

import static org.dnd.dnddiscordbot.hooks.CommandHook.ban;
import static org.dnd.dnddiscordbot.hooks.CommandHook.kick;

public class MessageReceived{

    private MessageReceivedEvent event;


    public MessageReceived(MessageReceivedEvent event) throws IOException {
        this.event = event;

        initializeCommandActions();

        if (this.event.getAuthor().equals(this.event.getJDA().getSelfUser()) || this.event.getAuthor().isBot() || this.event.getAuthor().isFake()) return;
        if (!this.event.getMessage().getContentRaw().startsWith(Bot.getConfiguration().getPrefix())) return;
        dispenseCommands();
    }

    private void initializeCommandActions(){
        ban.setAction(new Ban(this.event));
        kick.setAction(new Kick(this.event));
    }

    private int recursionCount = 0;

    private void dispenseCommands() throws IOException {
        String[] args = this.event.getMessage().getContentRaw().split(" ");
        String commandLabel = args[0].replace(Bot.getConfiguration().getPrefix(), "").toLowerCase();

        recursionCount++;

        for (Command command : Bot.commands){
            if (recursionCount == args.length){
                if (commandLabel == command.getLabel()) command.getAction().call();
                break;
            }
        }


    }
}

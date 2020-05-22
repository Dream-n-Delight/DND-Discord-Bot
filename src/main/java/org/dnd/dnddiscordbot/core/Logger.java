package org.dnd.dnddiscordbot.core;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.requests.restaction.MessageAction;

public class Logger {

    private TextChannel textChannel = null;
    private MessageAction messageAction = null;

    //Default System.out Logger
    public Logger(){
    }

    //Discord Channel Logger
    public Logger(TextChannel textChannel){
        this.textChannel = textChannel;
    }

    public Logger log(String s){
        if (this.textChannel == null){
            System.out.println(s);
            return null;
        }else{
            this.messageAction = this.textChannel.sendMessage(s);
        }
        return this;
    }

    public Logger log(Exception ex){
        if (this.textChannel == null){
            ex.printStackTrace(System.err);
        }else{
            this.messageAction = this.textChannel.sendMessage("[ERROR] "+ex.getMessage());
        }
        return this;
    }

    public Logger log(Message message){
        if (this.textChannel == null){
            System.out.println(message.getContentRaw());
        }else{
            this.messageAction = this.textChannel.sendMessage(message);
        }
        return this;
    }

    public Logger queue(){
        if (this.textChannel != null && this.messageAction != null){
            this.messageAction.queue();
        }
        return this;
    }
}

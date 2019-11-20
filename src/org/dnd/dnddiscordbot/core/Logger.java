package org.dnd.dnddiscordbot.core;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.requests.restaction.MessageAction;

public class Logger {

    private TextChannel textChannel = null;

    //Default System.out Logger
    public Logger(){
    }

    //Discord Channel Logger
    public Logger(TextChannel textChannel){
        this.textChannel = textChannel;
    }

    public MessageAction log(String s){
        if (this.textChannel == null){
            System.out.println(s);
            return null;
        }else{
            return this.textChannel.sendMessage(s);
        }
    }

    public MessageAction log(Exception ex){
        if (this.textChannel == null){
            ex.printStackTrace(System.err);
            return null;
        }else{
            return this.textChannel.sendMessage("[ERROR] "+ex.getMessage());
        }
    }

    public MessageAction log(Message message){
        if (this.textChannel == null){
            System.out.println(message.getContentRaw());
            return null;
        }else{
            return this.textChannel.sendMessage(message);
        }
    }
}

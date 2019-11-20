package org.dnd.dnddiscordbot.exceptions;

public class BotTokenException extends Exception {
    public BotTokenException (){
        super("Please use a valid bot token. View the generated file 'config.txt' generated in the base directory!");
    }
}

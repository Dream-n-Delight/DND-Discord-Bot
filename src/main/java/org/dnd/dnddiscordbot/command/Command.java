package org.dnd.dnddiscordbot.command;

import java.util.Arrays;
import java.util.List;

public class Command {

    public static List<Command> commands;

    private String label;
    private EventAction action;

    public Command(String label){
        this.label = label;
    }

    public Command register(){
        commands.add(this);
        return this;
    }

    public Command register(List<Command> commandList){
        commandList.add(this);
        return this;
    }

    public static void registerAll(Command[] commandsArray){
        commands.addAll(Arrays.asList(commandsArray));
    }

    public static void registerAll(Command[] commandsArray, List<Command> commandList){
        commandList.addAll(Arrays.asList(commandsArray));
    }


    //SETTERS
    public Command setAction(EventAction eventAction){
        this.action = eventAction;
        return this;
    }



    //GETTERS
    public String getLabel(){
        return this.label.toLowerCase();
    }

    public EventAction getAction(){
        return this.action;
    }



}

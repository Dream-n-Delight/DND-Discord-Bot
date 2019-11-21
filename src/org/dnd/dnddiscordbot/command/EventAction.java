package org.dnd.dnddiscordbot.command;

import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.dnd.dnddiscordbot.core.Logger;

public class EventAction {
    private Event event;
    protected Logger logger;

    public EventAction(Event event){
        this.event = event;
        this.logger = new Logger();

        if(event.getClass() == MessageReceivedEvent.class){
            logger = new Logger(((MessageReceivedEvent) event).getTextChannel());
        }
    }

    public EventAction dispense(String[] args){
        return this;
    }

    public EventAction dispense(){
        return this;
    }

    public void call(){
    }
}

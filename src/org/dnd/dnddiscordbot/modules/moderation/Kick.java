package org.dnd.dnddiscordbot.modules.moderation;

import net.dv8tion.jda.api.events.Event;
import org.dnd.dnddiscordbot.command.EventAction;

public class Kick extends EventAction {

    public Kick(Event event) {
        super(event);
    }

    @Override
    public void call(){
        logger.log("Kick action was taken").queue();
    }
}

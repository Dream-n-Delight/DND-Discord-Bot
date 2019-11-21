package org.dnd.dnddiscordbot.modules.moderation;

import net.dv8tion.jda.api.events.Event;
import org.dnd.dnddiscordbot.command.Command;
import org.dnd.dnddiscordbot.command.EventAction;

public class Ban extends EventAction {

    private Command help;
    private Command test;

    public Ban(Event event) {
        super(event);

        //Hook sub-commands
        this.help = new Command("-help").setAction(help());
        this.test = new Command("test").setAction(test());

        Command.registerAll(new Command[]{
                this.help,
                this.test
        });
    }

    @Override
    public EventAction dispense(String[] args){
        if (args.length == 1){
            call();
        }
        return this;
    }

    @Override
    public void call(){
        logger.log("Ban action was taken.").queue();
    }

    public EventAction help(){
        logger.log("BAN:help()").queue();
        return this;
    }

    public EventAction test(){
        logger.log("BAN:test()").queue();
        return this;
    }

}

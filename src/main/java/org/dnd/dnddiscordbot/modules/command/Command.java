package org.dnd.dnddiscordbot.modules.command;

import org.dnd.dnddiscordbot.enums.Permission;

public class Command {

    CommandExecutor commandExecutor;
    String commandLabel;
    Permission permission;

    Command(CommandExecutor commandExecutor, String commandLabel, Permission permission){

        this.commandExecutor = commandExecutor;
        this.commandLabel = commandLabel;
        this.permission = permission;

    }

}

package org.dnd.dnddiscordbot.modules.command;

import org.dnd.dnddiscordbot.enums.Permission;

public class CommandBuilder {

    CommandExecutor commandExecutor;
    Permission permission = Permission.ADMINISTRATOR;
    String commandLabel = null;

    public CommandBuilder(){
    }

    public CommandBuilder setCommandExecutor(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        return this;
    }

    public CommandBuilder setPermission(Permission permission) {
        this.permission = permission;
        return this;
    }

    public CommandBuilder setCommandLabel(String commandLabel) {
        this.commandLabel = commandLabel;
        return this;
    }

    public Command build(){
        return new Command(

        );
    }
}

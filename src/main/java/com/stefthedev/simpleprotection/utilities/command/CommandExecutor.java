package com.stefthedev.simpleprotection.utilities.command;

import org.bukkit.entity.Player;

public abstract class CommandExecutor {

    private final String name;
    private final String[] aliases;
    private final int length;

    public CommandExecutor() {
        CommandAnnotation commandAnnotation = getClass().getAnnotation(CommandAnnotation.class);
        name = commandAnnotation.name();
        aliases = commandAnnotation.aliases();
        length = commandAnnotation.length();
    }

    public abstract boolean execute(Player player, String[] args);

    public String getName() {
        return name;
    }

    public String[] getAliases() {
        return aliases;
    }

    public int getLength() {
        return length;
    }
}
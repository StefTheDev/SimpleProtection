package com.stefthedev.simpleprotection.listeners;

import com.stefthedev.simpleprotection.managers.CommandManager;
import com.stefthedev.simpleprotection.utilities.command.CommandExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    private CommandManager commandManager;

    public CommandListener(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @EventHandler
    public void onExecute(PlayerCommandPreprocessEvent event) {
        for(CommandExecutor commandExecutor : commandManager.asSet()) {
            if(split(event.getMessage())[0].equalsIgnoreCase(split(commandExecutor.getName())[0])) {
                if(event.getPlayer().hasPermission("sp." + commandExecutor.toString())) {
                    commandExecutor.execute(event.getPlayer(), split(event.getMessage()));
                    break;
                } else {
                    //No Permissions
                }
            }

        }
    }

    private String[] split(String string) {
        return string.split(" ");
    }
}

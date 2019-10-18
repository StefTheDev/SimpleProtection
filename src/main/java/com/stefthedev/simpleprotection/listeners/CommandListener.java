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
        String[] arguments = event.getMessage().split(" ");
        for (CommandExecutor commandExecutor : commandManager.asSet()) {
            if (arguments[0].equalsIgnoreCase("/" + commandExecutor.getName())) {
                commandExecutor.execute(event.getPlayer(), arguments);
                event.setCancelled(true);
                break;
            }
        }
    }
}

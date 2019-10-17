package com.stefthedev.simpleprotection;

import com.stefthedev.simpleprotection.listeners.CommandListener;
import com.stefthedev.simpleprotection.listeners.RegionListener;
import com.stefthedev.simpleprotection.listeners.SelectionListener;
import com.stefthedev.simpleprotection.managers.CommandManager;
import com.stefthedev.simpleprotection.managers.RegionManager;
import com.stefthedev.simpleprotection.managers.SelectionManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class SimpleProtection extends JavaPlugin {

    private CommandManager commandManager;
    private RegionManager regionManager;
    private SelectionManager selectionManager;

    public void onEnable() {
        commandManager = new CommandManager();
        regionManager = new RegionManager(this);
        selectionManager = new SelectionManager();

        registerListeners(
                new CommandListener(commandManager),
                new RegionListener(regionManager),
                new SelectionListener(selectionManager)
        );
    }

    private void registerListeners(Listener... listeners) {
        Arrays.asList(listeners).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
    }

    public CommandManager commandManager() {
        return commandManager;
    }

    public RegionManager getRegionManager() {
        return regionManager;
    }

    public SelectionManager selectionManager() {
        return selectionManager;
    }
}

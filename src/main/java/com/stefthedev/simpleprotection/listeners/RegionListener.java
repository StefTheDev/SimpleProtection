package com.stefthedev.simpleprotection.listeners;

import com.stefthedev.simpleprotection.managers.RegionManager;
import org.bukkit.event.Listener;

public class RegionListener implements Listener {

    private final RegionManager regionManager;

    public RegionListener(RegionManager regionManager) {
        this.regionManager = regionManager;
    }
}

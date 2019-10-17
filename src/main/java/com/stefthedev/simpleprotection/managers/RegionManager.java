package com.stefthedev.simpleprotection.managers;

import com.google.gson.reflect.TypeToken;
import com.stefthedev.simpleprotection.utilities.Manager;
import com.stefthedev.simpleprotection.utilities.general.Region;
import com.stefthedev.simpleprotection.utilities.storage.JSON;
import org.bukkit.plugin.Plugin;

import java.util.Set;

public class RegionManager extends Manager<Region> {

    private final JSON<Region> json;

    public RegionManager(Plugin plugin) {
        json = new JSON<>(plugin, "regions");
    }

    public void deserialize() {
        toSet(json.read(new TypeToken<Set<Region>>(){}.getType()));
    }

    public void serialize() {
        json.write(asSet());
    }
}

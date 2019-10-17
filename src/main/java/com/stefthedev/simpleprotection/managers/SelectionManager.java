package com.stefthedev.simpleprotection.managers;

import com.stefthedev.simpleprotection.utilities.Manager;
import com.stefthedev.simpleprotection.utilities.general.Point;
import com.stefthedev.simpleprotection.utilities.general.Selection;
import org.bukkit.Location;

import java.util.*;

public class SelectionManager extends Manager<Selection> {

    public Selection add(UUID uuid) {
        Selection selection = new Selection(uuid);
        add(selection);
        return selection;
    }

    public void remove(UUID uuid) {
        Selection selection = get(uuid);
        if(selection != null) remove(selection);
    }

    public Selection get(UUID uuid) {
        return asSet().stream().filter(selection -> selection.getUniqueId().equals(uuid)).findFirst().orElse(null);
    }

    public int blocksBetweenPoints(Selection selection) {
        Point one = selection.getOne();
        Point two = selection.getTwo();

        int size = 0;
        for (int x = one.getX(); x <= two.getX(); x++) {
            for (int y = one.getY(); y <= two.getY(); y++) {
                for (int z = one.getZ(); z <= two.getZ(); z++) {
                    size++;
                }
            }
        }
        return size;
    }

    public Point locationToPoint(Location location) {
        return new Point(Objects.requireNonNull(
                location.getWorld()).getName(),
                location.getBlockX(),
                location.getBlockY(),
                location.getBlockZ());
    }
}

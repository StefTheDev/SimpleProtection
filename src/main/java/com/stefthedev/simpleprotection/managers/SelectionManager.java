package com.stefthedev.simpleprotection.managers;

import com.stefthedev.simpleprotection.utilities.Manager;
import com.stefthedev.simpleprotection.utilities.general.Point;
import com.stefthedev.simpleprotection.utilities.general.PointIterator;
import com.stefthedev.simpleprotection.utilities.general.Selection;
import org.bukkit.Bukkit;
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

    public List<Point> getPoints(Selection selection) {
        Iterator<Point> iterator = new PointIterator(selection);
        List<Point> points = new ArrayList<>();
        while (iterator.hasNext()) {
            Point point = iterator.next();
            points.add(point);
            Bukkit.getLogger().info(point.toString());
        }
        return points;
    }

    public Point convert(Location location) {
        return new Point(Objects.requireNonNull(
                location.getWorld()).getName(),
                location.getBlockX(),
                location.getBlockY(),
                location.getBlockZ());
    }
}

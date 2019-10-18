package com.stefthedev.simpleprotection.utilities.general;

import java.util.UUID;

public class Selection {

    private final UUID uuid;
    private Point one, two;

    public Selection(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUniqueId() {
        return uuid;
    }

    public void setOne(Point one) {
        this.one = one;
    }

    public Point getOne() {
        return one;
    }

    public void setTwo(Point two) {
        this.two = two;
    }

    public Point getTwo() {
        return two;
    }

    public boolean collision(Point point) {
        return point.getX() >= one.getX() && point.getX() <= two.getX() &&
               point.getY() >= one.getY() && point.getY() <= two.getY() &&
               point.getZ() >= one.getZ() && point.getZ() <= two.getZ();
    }

    Point getLower() {
        int xMin = Math.min(one.getX(), two.getX());
        int yMin = Math.min(one.getY(), two.getY());
        int zMin = Math.min(one.getZ(), two.getZ());

        return new Point(one.getWorld(), xMin, yMin, zMin);
    }

    private Point getUpper() {
        int xMax = Math.max(one.getX(), two.getX());
        int yMax = Math.max(one.getY(), two.getY());
        int zMax = Math.max(one.getZ(), two.getZ());

        return new Point(one.getWorld(), xMax, yMax, zMax);
    }

    Point getSize() {
        int xAbs = Math.abs(getUpper().getX() - getLower().getX()) + 1;
        int yAbs = Math.abs(getUpper().getY() - getLower().getY()) + 1;
        int zAbs = Math.abs(getUpper().getZ() - getLower().getZ()) + 1;

        return new Point(getLower().getWorld(), xAbs, yAbs, zAbs);
    }
}

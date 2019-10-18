package com.stefthedev.simpleprotection.utilities.general;

public class Point {

    private final String world;
    private final int x, y, z;

    public Point(String world, int x, int y, int z) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    String getWorld() {
        return world;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "World: " + world + ", x: " +  x + ", y: " +  y + ", z: " +  z;
    }
}

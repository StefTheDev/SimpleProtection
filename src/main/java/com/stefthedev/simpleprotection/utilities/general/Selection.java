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
}

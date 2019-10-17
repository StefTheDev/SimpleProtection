package com.stefthedev.simpleprotection.utilities.general;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Region {

    private final UUID uuid;

    //Since we want players to handle multiple claims
    //We have a set of collection

    //Technically a claim...
    private final Set<Selection> selections;

    public Region(UUID uuid) {
        this.uuid = uuid;
        selections = new HashSet<>();
    }
}

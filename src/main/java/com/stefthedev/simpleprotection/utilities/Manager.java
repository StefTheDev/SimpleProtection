package com.stefthedev.simpleprotection.utilities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Manager<T> {

    private Set<T> set;

    public Manager() {
        set = new HashSet<>();
    }

    public void add(T t) {
        set.add(t);
    }

    public void remove(T t) {
        set.remove(t);
    }

    public T get(String string) {
        return set.stream().filter(t -> t.toString().equalsIgnoreCase(string)).findFirst().orElse(null);
    }

    public Set<T> asSet() {
        return Collections.unmodifiableSet(set);
    }

    public void toSet(Set<T> set) {
        this.set = set;
    }
}

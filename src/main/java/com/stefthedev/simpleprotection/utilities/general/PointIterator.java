package com.stefthedev.simpleprotection.utilities.general;

import java.util.Iterator;

public class PointIterator implements Iterator<Point> {

    private int x, y, z;
    private final Selection selection;

    public PointIterator(Selection selection) {
        this.selection = selection;
    }

    @Override
    public boolean hasNext() {
        return x < selection.getSize().getX() && y < selection.getSize().getY() && z < selection.getSize().getZ();
    }

    @Override
    public Point next() {
        Point point = new Point(
                selection.getOne().getWorld(),
                selection.getLower().getX() + x,
                selection.getLower().getY() + y,
                selection.getLower().getZ() + z
        );

        if (++x >= selection.getSize().getX()) { x = 0;
            if (++y >= selection.getSize().getY()) { y = 0;
                ++z;
            }
        }

        return point;
    }

}

package com.github.oxidedevelopment.snake.entity;

import com.github.oxidedevelopment.snake.misc.Location;

public class Snake {

    Location location;
    int length = 1;

    public Snake(Location location, int length) {
        this.location = location;
        this.length = length;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void draw() {

    }
}

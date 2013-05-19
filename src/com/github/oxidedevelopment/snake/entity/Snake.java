package com.github.oxidedevelopment.snake.entity;

import com.github.oxidedevelopment.snake.misc.Direction;
import com.github.oxidedevelopment.snake.misc.Location;

public class Snake {

    Location location;
    Direction direction;
    int length = 1;

    public Snake(Location location, int length, Direction direction) {
        this.location = location;
        this.length = length;
        this.direction = direction;
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


    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void draw() {

    }
}

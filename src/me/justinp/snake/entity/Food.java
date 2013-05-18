package me.justinp.snake.entity;

import me.justinp.snake.misc.Location;

import static org.lwjgl.opengl.GL11.glRectf;

public class Food {

    //TODO: Add a method to check if Snake has eaten the food
    private Location location;

    public Food(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void draw() {
        float x = location.getX(), y = location.getY();
        glRectf(x, y, x + 10, y + 10);
    }
}

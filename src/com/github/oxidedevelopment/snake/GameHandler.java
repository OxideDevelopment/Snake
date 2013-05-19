package com.github.oxidedevelopment.snake;

import com.github.oxidedevelopment.snake.entity.Food;
import com.github.oxidedevelopment.snake.entity.Snake;
import com.github.oxidedevelopment.snake.misc.Direction;
import com.github.oxidedevelopment.snake.misc.Location;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

public class GameHandler {

    Snake snake;
    Food food;

    private void start() {
        try {
            Display.setDisplayMode(new DisplayMode(500, 400));
            Display.setTitle("Snake");
            Display.create();
        } catch (LWJGLException e) {
            System.out.println("Error while trying to setup the display.");
            e.printStackTrace();
            System.exit(-1);
        }

        Random random = new Random();
        food = new Food(new Location(
                (float) random.nextInt(Display.getWidth() - 1),
                (float) random.nextInt(Display.getHeight() - 1)));

        snake = new Snake(new Location(0, 0), 3, Direction.Right);
        initGL();

        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT);
            pollKeyboard();
            snake.draw();
            food.draw();
            Display.update();
        }

        Display.destroy();
    }

    private void pollKeyboard() {
        if (Keyboard.isKeyDown(Keyboard.KEY_UP))
            snake.setDirection(Direction.Up);
        else if (Keyboard.isKeyDown(Keyboard.KEY_LEFT))
            snake.setDirection(Direction.Left);
        else if (Keyboard.isKeyDown(Keyboard.KEY_DOWN))
            snake.setDirection(Direction.Down);
        else if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT))
            snake.setDirection(Direction.Right);
    }


    private void initGL() {
        //TODO: Remove unneeded openGL calls..
        glEnable(GL_TEXTURE_2D);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glDisable(GL_DEPTH_TEST);
    }

    public static void main(String[] args) {
        GameHandler handler = new GameHandler();
        handler.start();
    }
}

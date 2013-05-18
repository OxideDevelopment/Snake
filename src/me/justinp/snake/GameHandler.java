package me.justinp.snake;

import me.justinp.snake.entity.Food;
import me.justinp.snake.entity.Snake;
import me.justinp.snake.misc.Location;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.Random;

import static org.lwjgl.opengl.GL11.*;

public class GameHandler {

    Snake snake = new Snake();
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
        initGL();

        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT);
            food.draw();
            Display.update();
        }

        Display.destroy();
    }


    private void initGL() {
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

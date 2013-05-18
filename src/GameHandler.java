import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class GameHandler {

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

        initGL();

        while (!Display.isCloseRequested()) {
            glClear(GL_COLOR_BUFFER_BIT);
            glColor3f(0, 1, 0);
            //test
            glRectf(50, 50, 100, 100);
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

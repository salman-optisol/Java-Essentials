package controller;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

public class Util {
    static Robot user;
    static {
        try {
            user = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }
    static void clicker() {
        user.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        user.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    static void scroller() {
        user.mouseWheel(5);
    }

    static int getInterval() {
        Random random = new Random();
        return (random.nextInt(90) + 1);
    }
}

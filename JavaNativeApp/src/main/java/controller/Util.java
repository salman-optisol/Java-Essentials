package controller;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

public class Util {
    static void clicker() throws AWTException {
        Robot user = new Robot();
        user.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        user.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    static int getInterval() {
        Random random = new Random();
        return (random.nextInt(90) + 1);
    }
}

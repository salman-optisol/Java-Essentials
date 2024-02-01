package controller;

import java.awt.*;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {

        Runnable job = () -> {
            try {
                while(true) {
                    Util.clicker();
                    System.out.println("Clicked at : " + LocalTime.now());
                    int interval = Util.getInterval();
                    System.out.println("Interval : " + interval);
                    Thread.sleep(interval * 1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Click job finished !");
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread = new Thread(job);
        thread.start();

        Thread.sleep(60*1000*2);
        thread.interrupt();
    }

}
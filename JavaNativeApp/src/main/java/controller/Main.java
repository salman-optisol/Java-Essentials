package controller;

import java.awt.*;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws AWTException, InterruptedException {

        Runnable job1 = () -> {
            try {
                LocalTime start = LocalTime.now();
                while(true) {
                    Util.clicker();
                    System.out.println("Hit : " + LocalTime.now());
                    int interval = Util.getInterval();
                    System.out.println("Gap : " + interval);
                    System.out.println("Fell : " + (LocalTime.now().getMinute() - start.getMinute()));
                    Thread.sleep(interval * 1000);
                }
            } catch (InterruptedException e) {
                System.out.println("Job finished at " + LocalTime.now());
            }
        };

        Runnable job2 = () -> {
            try {
                while(true) {
                    Util.scroller();
                    System.out.println("*********SCL*********");
                    Thread.sleep(5 * 60 * 1000);
                }
            } catch (InterruptedException e) {

            }
        };

        Thread thread = new Thread(job1);
        Thread thread1 = new Thread(job2);
        thread.start();
        thread1.start();

        int period = 10;

        System.out.println("JOB : " + period);

        Thread.sleep(60*1000*period);
        thread.interrupt();
        thread1.interrupt();
    }

}
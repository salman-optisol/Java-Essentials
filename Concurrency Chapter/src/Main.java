import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(new Task());
        thread.setName("Salman-thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

        System.out.println("In Main Thread...");
        System.out.println(Thread.currentThread()); // Get the current thread object

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside thread1...");
                for(int i = 0; i < 100; i++) {
                    System.out.print(i + " ");
                    if(i == 50) {
                        Thread.yield(); // Surrender to scheduler, and scheduler will lookout for any other thread with high priority.
                    }
                }
            }
        });
        thread1.start();

        // comment this try block for showing join()'s work
        try {
            thread1.join(); // Makes the main thread to wait for completion of thread1.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\nIn main thread.. after starting thread1");

        WebPageDownloader webPageDownloader = new WebPageDownloader("War History");
        Thread downloaderThread = new Thread(new HtmlDownloader(webPageDownloader));
        Thread fileCreatorThread = new Thread(new HtmlFileCreator(webPageDownloader));

        fileCreatorThread.start();
        downloaderThread.start();

    }
}

class Task implements Runnable {
    @Override
    public void run() {
        // The task for the thread...
        System.out.println("Inside thread...");
        System.out.println(Thread.currentThread());
    }
}

class HtmlDownloader implements Runnable {
    WebPageDownloader webPageDownloader;
    HtmlDownloader(WebPageDownloader webPageDownloader) {
        this.webPageDownloader = webPageDownloader;
    }

    @Override
    public void run() {
        webPageDownloader.pageDownloader();
    }
}

class HtmlFileCreator implements Runnable {
    WebPageDownloader webPageDownloader;

    HtmlFileCreator(WebPageDownloader webPageDownloader) {
        this.webPageDownloader = webPageDownloader;
    }

    @Override
    public void run() {
        webPageDownloader.pageWriter();
    }
}

/*

 ! Not recommended approach
 1. Not extend another class
 2. Tight coupled

class Task2 extends Thread {
    @Override
    public void run() {
        System.out.println("Alternate way to create a thread...");
    }
}
 */
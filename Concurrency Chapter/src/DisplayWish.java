import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DisplayWish {
    /* synchronized */

    Lock lock = new ReentrantLock();
    void display(String name) {
        try {
            lock.lock();
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello Mr. " + name );
                Thread.sleep(500);
            }
            lock.unlock();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void displayWithTry(String name) {
        try{
            // tryLock() alone is used without time, then the thread won't wait and directly go to the if
            if(lock.tryLock(1, TimeUnit.SECONDS)) {
                System.out.println("Mr." + name + " got the lock !");
                Thread.sleep(500);
                lock.unlock();
            }
            else {
                System.out.println("Sorry! Mr." + name + " lock not available");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void displayWithTryAgain(String name) {
        while(true) {
            try {
                if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                    System.out.println("Mr." + name + " got the lock!");
                    Thread.sleep(5000);
                    lock.unlock();
                    break;
                }
                else {
                    System.out.println("Sorry Mr." + name + " , try once again");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

import java.time.Period;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JavaConcurrentPackage {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(); // ReentrantLock is implementation of Lock interface
        // A thread can acquire multiple locks on an object
        // new ReentrantLock(boolean fairness)  -> if true, then longest waiting thread will get the lock
        //lock.lock(); same methods as synchronized keyword

        if(lock.tryLock()) {
            // thread will get lock and continue the execution
        }
        else {
            // alternate approach is executed
        }

        //lock.unlock(); -> to unlock the thread must have lock already, otherwise exception
        DisplayWish displayWish = new DisplayWish();
        Demo person1 = new Demo("Salman", displayWish);
        Demo person2 = new Demo("Wayne", displayWish);
        Demo person3 = new Demo("Stark", displayWish);

        Thread t1 = new Thread(person1);
        Thread t2 = new Thread(person2);
        Thread t3 = new Thread(person3);

        t1.start();
        t2.start();
        t3.start();


    }
}

class Demo implements Runnable{
    String name;
    DisplayWish displayWish;
    public Demo(String name, DisplayWish displayWish) {
        this.name = name;
        this.displayWish = displayWish;
    }

    @Override
    public void run() {
//        displayWish.display(name);
//        displayWish.displayWithTry(name);
        displayWish.displayWithTryAgain(name);
    }
}

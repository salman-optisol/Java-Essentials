/*
Synchronize all the places wherever the variable is used..
Even if the method don't modify the object, but just viewing.
 */

public class Synchronization {
    synchronized void display() {
        // method lock

        for(int i = 0; i < 1000; i++) {
            System.out.print("Locked  ");
        }
    }

    void display2() {
        // There are many lines of codes here...

        synchronized (this) {
            // but only this block is locked
            for(int i = 0; i < 1000; i++) {
                System.out.println("LockedBlock  ");
            }
        }
    }

    synchronized static void display3() {
        // same but static method
    }

    static void display4() {
        // There are 1000 lines of codes here...
        synchronized (Synchronization.class) {
            // lock for a block alone
            for(int i = 0; i < 1000; i++) {
                System.out.println("Locked static block ...");
            }
        }
    }
}

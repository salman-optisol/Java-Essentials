public class ThreadGroups {
    public static void main(String[] args) {
        ThreadGroup systemThreadGroup = Thread.currentThread().getThreadGroup().getParent();
        System.out.println(systemThreadGroup.getName());

        ThreadGroup threadGroup = new ThreadGroup("Group 1 Threads");
        System.out.println("Parent : " + threadGroup.getParent().getName());

        ThreadGroup threadGroup1 = new ThreadGroup(threadGroup, "Group 2 Threads");
        System.out.println("Parent : " + threadGroup1.getParent().getName());

        System.out.println("Priority of threadgroup : " + threadGroup.getMaxPriority());
        Thread t1 = new Thread(threadGroup, "thread1");
        threadGroup.setMaxPriority(3);
        Thread t2 = new Thread(threadGroup, "thread2");
        System.out.println("Priority of thread 1 : " + t1.getPriority());
        System.out.println("Priority of thread 2 : " + t2.getPriority());

        systemThreadGroup.list(); // list details of the thread group

        System.out.println("Active threads : " + systemThreadGroup.activeCount());
        // threadGroup.enumerate(Thread[] arr) -> to copy all the active threads in the group into the array
        // threadGroup.interrupt() -> interrupt thread in the group


    }
}

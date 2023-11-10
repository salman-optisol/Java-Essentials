import java.util.concurrent.*;

public class ExecutorFramework {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);
//        Jobber[] jobbers = {
//                new Jobber("Stark"),
//                new Jobber("Wayne"),
//                new Jobber("Roggers"),
//                new Jobber("Parker"),
//                new Jobber("Miles"),
//                new Jobber("Bucky")
//        };
//
//        for(Jobber jobber : jobbers) {
//            service.submit(jobber);
//        }
//        service.shutdown();

        ReplyJobber[] replyJobbers = {
                new ReplyJobber(1),
                new ReplyJobber(3),
                new ReplyJobber(4),
                new ReplyJobber(5),
                new ReplyJobber(6),
                new ReplyJobber(8)
        };

        for(ReplyJobber jobber : replyJobbers) {
            Future<Integer> future = service.submit(jobber);
            System.out.println("Returned value : " + future.get());
        }

        service.shutdown();
    }
}

class Jobber implements Runnable{
    String name;

    public Jobber(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " started : " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " Completed: " + Thread.currentThread().getName());
    }
}

class ReplyJobber implements Callable<Integer> {
    int value;

    public ReplyJobber(int value) {
        this.value = value;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is executing ...");
        return value * value;
    }
}

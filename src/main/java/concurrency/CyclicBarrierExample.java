package concurrency;

import java.time.LocalTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * {@link CyclicBarrier example that shows how the three threads that are created will finish at different times and
 * wait for one another until on reaching the barrier.await() call. Once all the thread reaches the barrier.await(),
 * The barrier action is executed and all the threads resume at the same time.
 */
public class CyclicBarrierExample {

    private static final CyclicBarrier barrier = new CyclicBarrier(3, () -> System.out.println("Barrier reached..."));

    private static final Runnable worker = () -> {
        try {   String threadName = Thread.currentThread().getName();
                long millis = (long) (Math.random() * 10 * 1000);
                System.out.printf("Thread %s sleeping for %s seconds...%n", threadName, (millis/1000));
                Thread.sleep(millis);
                barrier.await();
                System.out.println(threadName + " wait over starting at " + LocalTime.now());
        } catch (InterruptedException | BrokenBarrierException e) { e.printStackTrace();}
    };

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(worker);
        executorService.submit(worker);
        executorService.submit(worker);

        System.out.println(Thread.currentThread().getName() + " finished...");
        executorService.shutdown();
    }
}


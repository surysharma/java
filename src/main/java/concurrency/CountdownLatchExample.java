package concurrency;

import java.util.List;
import java.util.concurrent.*;

import static java.lang.String.format;
import static java.util.Arrays.asList;

/**
 * {@link CountdownLatchExample that shows how 3 worker threads perform individual tasks and then
 * reduce the latch count. Once the latch count reaches 0, the supervisor thread(Main thread) collects
 * the processes the results.}
 */
public class CountdownLatchExample {

    private static final int LATCH_COUNT = 3;
    private static final CountDownLatch latch = new CountDownLatch(LATCH_COUNT);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(LATCH_COUNT);

        Future<String> futureResult1 = executorService.submit(worker);
        Future<String> futureResult2 = executorService.submit(worker);
        Future<String> futureResult3 = executorService.submit(worker);

        try {   latch.await();
                String result1 = futureResult1.get();
                String result2 = futureResult2.get();
                String result3 = futureResult3.get();
                processResults(asList(result1, result2, result3));
                System.out.printf("Main thread %s exiting... \n", Thread.currentThread().getName());
        } catch (InterruptedException | ExecutionException e) {e.printStackTrace();}
        finally { executorService.shutdown();}

    }

    private static void processResults(List<String> results) {
        results.forEach(System.out::println);
    }

    private static final Callable<String> worker = () -> {
        String threadName = Thread.currentThread().getName();
        System.out.println("Executing task " + threadName);
        Thread.sleep((long) (Math.random()*10 * 1000));
        latch.countDown();
        return format("Task completed by worker thread %s ...", threadName);
    };
}

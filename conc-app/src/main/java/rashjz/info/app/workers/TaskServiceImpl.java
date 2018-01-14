package rashjz.info.app.workers;

import org.apache.log4j.Logger;
import java.util.concurrent.*;

public class TaskServiceImpl {
    private static final Logger LOGGER = Logger.getLogger(TaskServiceImpl.class);

    private ExecutorService executor = Executors.newFixedThreadPool(2);
    private Semaphore semaphore = new Semaphore(2, true);//fairness true
    BlockingQueue queue = new ArrayBlockingQueue(1024);

    public void test() {
        executor.execute(() -> {
            try {

                queue.add("test1");
                LOGGER.info("Queue size 1 " + queue.size());
                LOGGER.info("task do some actions " + Thread.currentThread().getName());
            } catch (Exception e) {
                LOGGER.error("Error occurred while task submission", e);
                e.printStackTrace();
            }
        });


        Future future = executor.submit(() -> {
            try {
                Thread.sleep(1000);

                semaphore.acquire(1);
                queue.add("test2");
                LOGGER.info("task do another action " + Thread.currentThread().getName());
                semaphore.release();

                LOGGER.info("Queue size 2 " + queue.size());
            } catch (Exception e) {
                LOGGER.error("Error occurred while task submission", e);
                e.printStackTrace();
            }
        });

        executor.shutdown();
    }


}

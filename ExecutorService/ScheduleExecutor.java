package ExecutorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecutor {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(10);
            executorService.scheduleAtFixedRate(new Schedule(), 1000, 2000, TimeUnit.MILLISECONDS);


            if (!executorService.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                executorService.shutdown();
            }
    }
}

class Schedule implements Runnable {

    int scheduleId;

    @Override
    public void run() {
        System.out.println("Schedule : " + (scheduleId++) + " scheduled by the thread : " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

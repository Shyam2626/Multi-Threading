package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutor {
    public static void main(String[] args) {

        try (ExecutorService service = Executors.newFixedThreadPool(3)) {

            for (int i = 0 ; i < 10 ; i++) {
                service.execute(new Work(i));
            }
        }
    }
}

class Work implements Runnable {

    private final int id;

    Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Work : " + id + " done by the thread : " + Thread.currentThread().getName());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

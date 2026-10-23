package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CacheThreadPoolExecutor {
    public static void main(String[] args) {

        try (ExecutorService service = Executors.newCachedThreadPool()) {

            for (int i = 0 ; i < 100 ; i++) {
                service.execute(new Process(i));
            }
        }
    }
}

class Process implements Runnable {

    private final int id;

    Process(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Process : " + id + " done by the thread : " + Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

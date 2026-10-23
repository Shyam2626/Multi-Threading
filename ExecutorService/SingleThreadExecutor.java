package ExecutorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadExecutor {

    public static void main (String[] args) {

        System.out.println("Main Thread name : " + Thread.currentThread().getName());

        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            for (int i = 0 ; i < 5 ; i++) {
                service.execute(new Task(i));
            }
        }


    }
}

class Task implements Runnable {

    private final int id;

    Task(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        System.out.println("Task with id : " + id + " is executed with thread : " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

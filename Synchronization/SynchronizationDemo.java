package Synchronization;

public class SynchronizationDemo {

    private static int counter;

    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(() -> {
           for (int i = 0 ; i < 10000 ; i++) {
               increment();
           }
        });

        Thread two = new Thread(() -> {
            for (int i = 0 ; i < 10000 ; i++) {
                increment();
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();
        System.out.println("The value of the counter is : " + counter);
    }

    private static synchronized void increment() {
        counter++;
    }
}

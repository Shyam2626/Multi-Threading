public class WaitAndNotify {

    private static final Object LOCK = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

    }

    private static void one() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Hello from Method one....");
            LOCK.wait();
            System.out.println("Back again in Method One");
            LOCK.notify();
        }
    }

    private static void two() throws InterruptedException {
        synchronized (LOCK) {
            System.out.println("Hello from Method two....");
            LOCK.notify();
            LOCK.wait();
            System.out.println("Hello from method two after notifying...");
        }
    }
}


// if t1 executes first
//Hello from Method one....
//Hello from Method two....
//Back again in Method One
//Hello from method two after notifying...

//if t2 executes
//Hello from Method one....
//Hello from Method two....
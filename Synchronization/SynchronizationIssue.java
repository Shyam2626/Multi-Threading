package Synchronization;

//In your code, while increment1() is executing, it also prevents another thread from executing increment2() because both methods use the same intrinsic lock.
//Look at your methods
//private static synchronized void increment1() {
//    counter1++;
//}
//
//private static synchronized void increment2() {
//    counter2++;
//}
//
//Because both methods are static synchronized, they acquire the lock on the same object: SynchronizationIssue.class.
//Conceptually, Java treats them like this:
//private static void increment1() {
//    synchronized (SynchronizationIssue.class) {
//        counter1++;
//    }
//}
//
//private static void increment2() {
//    synchronized (SynchronizationIssue.class) {
//        counter2++;
//    }
//}
//
//2. What happens when both threads run?
//Thread 1
//Calls increment1() and acquires SynchronizationIssue.class lock.
//
//Thread 2 tries to call increment2()
//Must wait
//
//Thread 1
//Increments counter1 and releases the lock.
//
//
//Thread 2
//Acquires the lock and increments counter2.



public class SynchronizationIssue {

    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread one = new Thread(() -> {
            for (int i = 0 ; i < 10000 ; i++) {
                increment1();
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0 ; i < 10000 ; i++) {
                increment2();
            }
        });

        one.start();
        two.start();

        one.join();
        two.join();
        System.out.println("The value of the counter is : " + counter1 + " ------ " + counter2);
    }

    private static synchronized void increment1() {
        counter1++;
    }

    private static synchronized void increment2() {
        counter2++;
    }
}

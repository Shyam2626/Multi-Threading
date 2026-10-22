//Your UserThreadHelper finishes after approximately 2000 milliseconds.
// Once the main thread and all other non-daemon threads finish, the JVM can terminate, stopping the daemon thread even if it has printed only once—or not at all, depending on scheduling.
//So the loop is designed to print 500 times, but the daemon thread's lifetime depends on whether the JVM stays alive long enough.

public class DaemonUserThread {
    public static void main(String[] args) throws InterruptedException {

        Thread daemonThread = new Thread(new DaemonThreadHelper());
        Thread userThread = new Thread(new UserThreadHelper());

        daemonThread.setDaemon(true);
        daemonThread.start();
        userThread.start();
    }
}

class DaemonThreadHelper implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (count < 500) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            System.out.println("Daemon Thread is running...!");
        }

    }
}

class UserThreadHelper implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("User Thread done with execution");
    }
}
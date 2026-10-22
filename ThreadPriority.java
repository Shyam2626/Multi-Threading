//Does thread two execute first?
//Not necessarily! This is the important concept.
//
//Even though two has the maximum priority, Java does not guarantee that it prints all its numbers before one.
//
//        For example, output could look like:
//thread one 0
//thread two 0
//thread two 1
//thread one 1
//thread two 2
//thread one 2
//
//
//The actual order depends on thread scheduling and the JVM/operating system. Priority is a scheduling hint, not a guarantee of execution order.



public class ThreadPriority {
    public static void  main(String[] args) {
        System.out.println("Current thread : " + Thread.currentThread().getName() + ", Priority : " + Thread.currentThread().getPriority());


        Thread one = new Thread(() -> {
            for (int i = 0 ; i < 10 ; i++) {
                System.out.println("thread one " + i);
            }
        });

        Thread two = new Thread(() -> {
            for (int i = 0 ; i < 10 ; i++) {
                System.out.println("thread two " + i);
            }
        });

        two.setPriority(Thread.MAX_PRIORITY);

        one.start();
        two.start();
    }
}

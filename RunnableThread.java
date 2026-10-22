public class RunnableThread {
  
  public static void main(String[] args) {

    Thread t1 = new Thread(new MyTask());
    t1.setName("Shyam's thread");
    t1.start();
  }
}

class MyTask implements Runnable {

  @Override
    public void run() {
        System.out.println("Started");

        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().threadId());
        } catch (InterruptedException e) {
          System.out.println("Interrupted");
            Thread.currentThread().interrupt();
            return;
        } finally {
            System.out.println("In Finally");
        }


    }
  
}

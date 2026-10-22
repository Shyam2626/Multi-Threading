import java.util.*;

public class ThreadPractice {
    public static void main(String[] args) {
      MyThread obj = new MyThread();
      obj.start();
    }
}

class MyThread extends Thread{

  @Override
  public void run() {
    System.out.println("Printing");
  }

}

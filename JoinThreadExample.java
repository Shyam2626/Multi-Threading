public class JoinThreadExample {
    public  static void main(String[] args) throws InterruptedException {

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

        one.start();
        two.start();
        two.join();
        System.out.println("Done executing threads");
    }
}

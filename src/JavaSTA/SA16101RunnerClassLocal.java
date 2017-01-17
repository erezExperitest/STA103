package JavaSTA;

/**
 * Created by erez.akri on 1/17/17.
 */
public class SA16101RunnerClassLocal {

    public static void main(String[] args) {

        Thread t1 = new Thread(new SA16101runnerLocal());
        Thread t2 = new Thread(new SA16101runnerLocal());
        Thread t3 = new Thread(new SA16101runnerLocal());
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();
    }
}

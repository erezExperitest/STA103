package JavaSTA;

import oldTests.ClassArray;

public class RunnerClass {

    public static void main(String[] args) {
//        for (int i = 0; i < 6; i++) {

            Thread t1 = new Thread(new SA16101Runner());
            Thread t2 = new Thread(new SA16101Runner());
            Thread t3 = new Thread(new SA16101Runner());
            t1.start();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t2.start();
        t3.start();

//        }
    }

}
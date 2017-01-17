package JavaSTA;

import oldTests.ClassArray;

public class RunnerClass {

    public static void main(String[] args) {
//        for (int i = 0; i < 6; i++) {

            Thread t1 = new Thread(new ClassArray());
            Thread t2 = new Thread(new ClassArray());
            t1.start();
            t2.start();

//        }
    }

}
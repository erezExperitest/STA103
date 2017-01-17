package JavaSTA;

import org.junit.runner.JUnitCore;

/**
 * Created by erez.akri on 1/17/17.
 */
public class SA16101Runner implements Runnable{

    @Override
    public void run() {
        JUnitCore.runClasses(SA16101.class);

    }

}

package oldTests;

import org.junit.runner.JUnitCore;


public class ClassArraycopy implements Runnable {

    @Override
    public void run() {
//        Class<?> [] classesArray = {oldTests.SA15347.class};
        JUnitCore.runClasses(SA15347.class);
        JUnitCore.runClasses(SA15347.class);
    }

}
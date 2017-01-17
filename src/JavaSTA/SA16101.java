package JavaSTA;//package <set your test package>;
import com.experitest.client.*;

import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//@RunWith(Parameterized.class)
public class SA16101 {
//	@Parameterized.Parameters
//    public static List<Object[]> data() {
//        return Arrays.asList(new Object[10][0]);
//    }

    private String projectBaseDirectory = System.getProperty("user.dir");
    protected Client client = null;


    @Before
    public void setUp(){
    }

    @Test
    public void test_1(){
        GridClient grid = new GridClient("admin", "Experitest2012", "default", "192.168.2.10", 80, false); //(user name, password, project,ip,port,secured)
//        client =  grid.lockDeviceForExecution("erezTest", "contains(@name,'samsung SM-A5000')", 10,3000 ); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client =  grid.lockDeviceForExecution("erezTest", "@os='ios'", 10,3000 ); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.uninstall("com.experitest.ExperiBank");
        client.install("/Applications/STA/SeeTest-10.3/bin/ipas/EriBank.ipa",true,false);
        client.sleep(15000);
        client.startAudioPlay("/Users/erez.akri/Desktop/Audio/DJ_Snake_Lil_Jon_-_Turn_Down_for_What_converted.wav");
        client.sleep(5000);
        client.startAudioRecording("/Users/erez.akri/Desktop/Audio/SA11635465.wav");
        client.sleep(5000);
//        client.startAudioPlay("C:\\Users\\erez.akri.experitest\\Desktop\\New folder (2)\\New folder\\Nyan_Cat.wav");
//        client.sleep(40000);

    }

    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
//        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future.
        client.releaseClient();
    }

}

package JavaSTA;//package <set your test package>;
import com.experitest.client.*;

import java.util.Arrays;
import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//@RunWith(Parameterized.class)
public class Grid {
//	@Parameterized.Parameters
//    public static List<Object[]> data() {
//        return Arrays.asList(new Object[10][0]);
//    }

    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    protected Client client = null;


    @Before
    public void setUp(){
    }
    
    @Test
    public void test_1(){
        GridClient grid = new GridClient("erez", "Experitest2012", "default", "192.168.4.63", 8090, false); //(user name, password, project,ip,port,secured)
//        client =  grid.lockDeviceForExecution("erezTest", "contains(@name,'samsung SM-A5000')", 10,3000 ); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client =  grid.lockDeviceForExecution("erezTest", "@os='ios'", 10,3000 ); //(test name, query, time for reserve in minuets, timeout in milliseconds)
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.startLoggingDevice("C:\\Users\\erez.akri.experitest\\Desktop\\aaaa.log");
        client.sleep(3000);
        client.stopLoggingDevice();
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

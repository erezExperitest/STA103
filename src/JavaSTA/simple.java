package JavaSTA;

import com.experitest.client.*;
import org.junit.*;
/**
 *
 */
public class simple {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, false);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "1");
    }

    @Test
    public void test_1(){
        client.waitForDevice("@os='ios'",30000);
        client.startLoggingDevice("C:\\Users\\erez.akri.experitest\\Desktop");
        client.sleep(3000);
        client.stopLoggingDevice();

    }

    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future.
        client.releaseClient();
    }
}

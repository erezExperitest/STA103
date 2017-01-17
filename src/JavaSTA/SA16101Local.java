package JavaSTA;//package <set your test package>;
import com.experitest.client.*;
import org.junit.*;
/**
 *
 */
public class SA16101Local {
    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "/Users/erez.akri/workspace/project2";
    protected Client client = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "2");
    }

    @Test
    public void test_2(){
        client.waitForDevice("@os='ios'",3000);
//        if(client.uninstall("cloud:com.experitest.ExperiBank")){
//            // If statement
//        }
        client.install("/Applications/STA/SeeTest-10.3/bin/ipas/EriBank.ipa", true, false);
        client.startAudioPlay("/Users/erez.akri/Desktop/Audio/DJ_Snake_Lil_Jon_-_Turn_Down_for_What_converted.wav");
        client.sleep(5000);
        client.startAudioRecording("/Users/erez.akri/Desktop/Audio/SA11635465.wav");
        client.sleep(5000);

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

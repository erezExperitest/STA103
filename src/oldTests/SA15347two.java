package oldTests;

import com.experitest.client.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//import com.experitest.client.Client;

public class SA15347two {

    private String host = "localhost";
    private int port = 8889;
    private String projectBaseDirectory = "C:\\Users\\erez.akri.experitest\\workspace\\project31";
    protected Client client = null;
    protected Client client2 = null;

    @Before
    public void setUp(){
        client = new Client(host, port, true);
        client2 = new Client(host, port, true);
        client.setProjectBaseDirectory(projectBaseDirectory);
        client.setReporter("xml", "reports", "setdevice");
    }

    @Test
    public void IosIos(){
        client.setDevice("ios_app:iPad nevo12");
        client.sleep(10);
        client2.setDevice("ios_app:iPad");
        client2.sleep(10);
//        client.setDevice("ios_app:iPad");
//        client.sleep(10);
    }



    @Test
    public void AndroidAndroid(){
        client.setDevice("adb:asus Nexus 7");
        client.sleep(10);
        client2.setDevice("adb:OnePlus A0001");
        client2.sleep(10);
    }
//
    @Test
    public void AndroidIos(){
        client.setDevice("adb:OnePlus A0001");
        client.sleep(10);
        client2.setDevice("ios_app:iPad nevo12");
        client2.sleep(10);

    }
//
    @Test
    public void IosAndroid(){
        client.setDevice("ios_app:iPad nevo12");
        client.sleep(10);
        client2.setDevice("adb:OnePlus A0001");
        client2.sleep(10);

    }
//
    @Test
    public void waitForDeviceIosIos(){
        client.waitForDevice("contains(@name,'nevo')", 3000);
        client.sleep(10);
        client2.waitForDevice("contains(@name,'iPad')", 3000);
        client2.sleep(10);
    }
//
    @Test//1
    public void waitForDeviceAndroidAndroid(){
        client.waitForDevice("contains(@name,'exus')", 3000);
        client.sleep(10);
        client2.waitForDevice("contains(@name,'OnePlu')", 3000);
        client2.sleep(10);
    }
//
    @Test//2
    public void waitForDeviceAndroidIos(){
        client.waitForDevice("contains(@name,'exus')", 3000);
        client.sleep(10);
        client2.waitForDevice("contains(@name,'nevo')", 3000);
        client2.sleep(10);
    }
//
    @Test//3
    public void waitForDeviceIosAndroid(){
        client.waitForDevice("contains(@name,'nevo')", 3000);
        client.sleep(10);
        client2.waitForDevice("contains(@name,'exus')", 3000);
        client2.sleep(10);
    }
//
    @Test//4
    public void waitSetIosIos(){
        client.waitForDevice("contains(@name,'nevo')", 3000);
        client.sleep(10);
        client2.setDevice("ios_app:iPad");
        client2.sleep(10);
    }
//
    @Test//1
    public void waitSetAndroidAndroid(){
        client.waitForDevice("contains(@name,'OnePlus')", 3000);
        client.sleep(10);
        client2.setDevice("adb:asus Nexus 7");
        client2.sleep(10);
    }
//
    @Test//2
    public void waitSetIosAndroid(){
        client.waitForDevice("contains(@name,'nevo')", 3000);
        client.sleep(10000);
        client2.setDevice("adb:asus Nexus 7");
        client2.sleep(10);
    }
//
    @Test//3
    public void waitSetAndroidIos(){
        client.waitForDevice("contains(@name,'exus')", 3000);
        client.sleep(10);
        client2.setDevice("ios_app:iPad nevo12");
        client2.sleep(10);
    }
//
    @Test//3
    public void SetWaitIosIos(){
        client.setDevice("ios_app:iPad nevo12");
        client.sleep(10);
        client2.waitForDevice("contains(@name,'iPad')", 3000);
        client2.sleep(10);
    }
//
    @Test//3
    public void SetWaitIosAndroid(){
        client.setDevice("ios_app:iPad nevo12");
        client.sleep(10);
        client2.waitForDevice("contains(@name,'exus')", 3000);
        client2.sleep(10);
    }

    @Test//3
    public void SetWaitAndroidIos(){
        client.setDevice("adb:asus Nexus 7");
        client.sleep(10);
        client2.waitForDevice("contains(@name,'nevo')", 3000);
        client2.sleep(10);
    }

    @Test//3
    public void SetWaitAndroidAndroid(){
        client.setDevice("adb:asus Nexus 7");
        client.sleep(10);
        client.waitForDevice("contains(@name,'OnePlu')", 3000);
        client.sleep(10);
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

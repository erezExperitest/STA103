package oldTests;

import com.experitest.client.Client;
import org.junit.*;


/**
 * Created by udi.valer on 9/27/2016.
 */
public class MultiTabTest {

    protected Client client = null;
    protected String iosVersion = "";
    protected String iosModel = "";
    protected boolean iphone = true; // Argument to understand if current test run oon device or on iphone

    @Before
    public void setUp(){

        client = new Client("localhost.", 8889, true);
        client.setProjectBaseDirectory(System.getProperty("user.dir"));
        client.setReporter("xml", "reports", "Untitled");
        client.waitForDevice("@os = 'ios'" , 10000);
        //client.setDevice("ios_app:iPad air 2"); //If you want to use set device you are welcome
        iosVersion = client.getDeviceProperty("device.version");
        iosModel = client.getDeviceProperty("device.model");
        if(iosModel.toLowerCase().contains("ipad"))
            iphone = false;

    }

    /** This test open the same web page 3 times, switch between them and in each page execute few different command to be sure the right dump is taken for each page.
     Passing between pages from switch application */
    @Test
    public void sameWindowMultipleTabs(){
        System.out.println("*********************************");
        System.out.println("Current test run on ios " + iosModel + " With version: " + iosVersion);
        System.out.println("*********************************");

        client.hybridClearCache(true , true);
        client.launch("com.apple.mobilesafari" , true , false);

        if(Double.valueOf(iosVersion) >= 9){
            String pagesXpath = "xpath=//*[@knownSuperClass='UIScrollView']";
            testForTheCorrectVersion(pagesXpath);

        }
        else{   // Version is lower than 9
            String pagesXpath = "xpath=(//*[@class='UIAScrollView'])[1]";
            testForTheCorrectVersion(pagesXpath);
        }

    }

    @After
    public void tearDown(){
        // Generates a report of the test case.
        // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
        client.generateReport(false);
        // Releases the client so that other clients can approach the agent in the near future.
        client.releaseClient();
    }

    private void testForTheCorrectVersion(String pagesXpath){

        int numberOfPagesToOpen = 3;
        int numberOfOpenPages = 1;

        String newPageRecognition = "";
        String searchButtonGoogle = "";

        if(iphone) {
            newPageRecognition = "xpath=//*[@text='New page']";
            searchButtonGoogle = "id=tsbb";
            System.out.println("Is iphone!!!");
        }
        else {
            newPageRecognition = "xpath=//*[@text='New tab']";
            pagesXpath = "xpath=//*[@class='UIAView' and @knownSuperClass='UIView' and @enabled='true' and boolean(@text)]/..";
            searchButtonGoogle = "id=sblsbb";
            System.out.println("Is Ipad!!!");
        }

        /** Loop for opening 3 same web pages - www.google.com */
        do{
            client.sync(2000 , 80 , 10000);
            client.elementSendText("NATIVE", "xpath=//*[@accessibilityLabel='URL' and (@class='UIAView' or @class='UIAElement')]", 0, "www.google.com");
            client.sendText("{ENTER}");
            client.sync(2000 , 80 , 10000);
            client.click("NATIVE", "xpath=//*[@text='Pages']", 0, 1);
            client.click("NATIVE", newPageRecognition, 0, 1);
            numberOfOpenPages++;
        }while(numberOfOpenPages!=numberOfPagesToOpen);

        client.sync(2000 , 80 , 10000);
        client.elementSendText("NATIVE", "xpath=//*[@accessibilityLabel='URL' and (@class='UIAView' or @class='UIAElement')]", 0, "www.google.com");
        client.sendText("{ENTER}");
        client.sync(2000 , 80 , 10000);
        client.click("NATIVE", "xpath=//*[@text='Pages']", 0, 1);

        /** Calculate pages size in switch app screen in order to press on the top of the element */
        String pageHeight = client.elementGetProperty("NATIVE" , pagesXpath + "/*[1]" , 0 , "height");
        int clickOffset = Integer.valueOf(pageHeight)/2/2;

        /** Choose each tab and do something different in this tab */
                /* First page load wikipedia */
        client.sync(2000 , 80 , 10000);
        client.click("NATIVE" , pagesXpath + "/*[1]" ,0 , 1 , 0 , -clickOffset);
        client.click("WEB", "id=lst-ib", 0, 1);
        client.sendText("wikipedia");
        client.click("WEB", searchButtonGoogle, 0, 1);
        if(client.isElementFound("WEB" , "xpath=//*[@text='Looking for results in English?']" , 0)){
            client.click("WEB" , "xpath=//*[@text='הישאר ב-']" , 0 , 1);
        }
        client.waitForElement("WEB" , "xpath=//*[@text='ויקיפדיה' and @nodeName='A']" , 0 , 10000);
        client.click("WEB" , "xpath=//*[@text='ויקיפדיה' and @nodeName='A']" , 0 , 1);

        // Move to next page
        client.click("NATIVE", "xpath=//*[@text='Pages']", 0, 1);
        client.sync(2000 , 80 , 10000);
        client.click("NATIVE" , pagesXpath + "/*[2]" ,0 , 1 , 0 , -clickOffset);

                /* Second page load apple */
        client.waitForElement("WEB", "id=lst-ib", 0, 3000);
        client.click("WEB", "id=lst-ib", 0, 1);
        client.sendText("apple");
        client.click("WEB", searchButtonGoogle, 0, 1);
        if(client.isElementFound("WEB" , "xpath=//*[@text='Looking for results in English?']" , 0)){
            client.click("WEB" , "xpath=//*[@text='הישאר ב-']" , 0 , 1);
        }
        client.waitForElement("WEB" , "xpath=//*[@text='Apple']" , 0 , 10000);
        client.click("WEB" , "xpath=//*[@text='Apple']" , 0 , 1);

        // Move to next page
        client.click("NATIVE", "xpath=//*[@text='Pages']", 0, 1);
        client.sync(2000 , 80 , 10000);
        client.click("NATIVE" , pagesXpath + "/*[3]" ,0 , 1 , 0 , -clickOffset-50);

                /* Third page load walla */
        client.waitForElement("WEB", "id=lst-ib", 0, 3000);
        client.click("WEB", "id=lst-ib", 0, 1);
        client.sendText("walla");
        client.click("WEB", searchButtonGoogle, 0, 1);
        if(client.isElementFound("WEB" , "xpath=//*[@text='Looking for results in English?']" , 0)){
            client.click("WEB" , "xpath=//*[@text='הישאר ב-']" , 0 , 1);
        }
        client.waitForElement("WEB" , "xpath=//*[@text='בוואלה!']" , 0 , 10000);
        client.click("WEB" , "xpath=//*[@text='בוואלה!']" , 0 , 1);


    }

}




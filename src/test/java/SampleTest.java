import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SampleTest {

    private   AndroidDriver driver;

//    @BeforeEach
//    public  void setUp() throws MalformedURLException {
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setCapability("deviceName", "ddd");
//        desiredCapabilities.setCapability("platformName", "android");
//        desiredCapabilities.setCapability("appPackage", "com.xueqiu.android");
//        desiredCapabilities.setCapability("appActivity", ".view.WelcomeActivityAlias");
////        desiredCapabilities.setCapability("appPackage", "io.appium.settings");
////        desiredCapabilities.setCapability("appActivity", ".Settings");
//        desiredCapabilities.setCapability("autoGrantPermissions", true);
//
//        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
//
//        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
//    }
//
//    @Test
//    public void swipe(){
//        try {
//            for(int i=0;i<10;i++){
//                FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE).getCanonicalFile(),new File(i+".png"));
//            }
//
//        } catch (IOException e) {
//
//        }
//    }
//
//    @AfterEach
//    public  void tearDown() {
//        driver.quit();
//    }
}


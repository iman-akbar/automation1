package org.example;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class Main {
    public  static DesiredCapabilities capabilities;
    public static AndroidDriver driver;
    public static URL url;
    public static void main(String[] args) throws MalformedURLException,InterruptedException {

        System.out.println("Hello world!");
        final String URL_STRING = "http://0.0.0.0:4723/wd/hub";

        url = new URL(URL_STRING);


        capabilities = new DesiredCapabilities();


        capabilities.setCapability("autoGrantPermissions", "true");


//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
//        capabilities.setCapability(MobileCapabilityType.UDID,"M5AIGF000706MZW");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"ROG Phone 5");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "AOSP on IA Emulator");
//        capabilities.setCapability(MobileCapabilityType.UDID,"uguoqkfqbuvouotg");
//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"POCO M3 Pro 5G");

//        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\iman akbar\\Downloads\\baru2.apk");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        int x = 100;
        while (x != 0) {
            System.out.println(x);
            capabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\iman akbar\\Downloads\\inno-video (1).apk");


            driver = new AndroidDriver(url, capabilities);



            Thread.sleep(1000);
            driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/androidx.compose.ui.platform.ComposeView[1]/android.view.View[1]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[3]/android.widget.FrameLayout[1]/android.view.View[1]")).click();
            driver.findElement(By.id("exo_play_pause")).click();
            driver.findElement(By.id("exo_play_pause")).click();
            Thread.sleep(5000);
            driver.quit();


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("error");
            throw new RuntimeException(e);
        }
        x--;
    }
    }
    public static void pressByCoordinates(int x, int y, long seconds) {
        new TouchAction(driver)
                .press(point(x,y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

}
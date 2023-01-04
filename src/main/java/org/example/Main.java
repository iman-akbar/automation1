package org.example;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class Main {
    public  static DesiredCapabilities capabilities;
    public static AndroidDriver driver;
    public static URL url;
    public static void main(String[] args) throws IOException, InterruptedException {
        Properties prop=new Properties();
        FileInputStream ip= new FileInputStream("H:/tesAppium5/config.properties");
        prop.load(ip);

        System.out.println("Hello world!");
        final String URL_STRING = "http://13.212.163.173:4444/wd/hub";
//        final String URL_STRING = "http://0.0.0.0:4723/wd/hub";
        url = new URL(URL_STRING);
        capabilities = new DesiredCapabilities();
        prop.getProperty("permission");
        prop.getProperty("emulatorName");
        prop.getProperty("emulatorUDID");
        prop.getProperty("automator");
        int x = 100;
        while (x != 0) {
            System.out.println(x);
//            File f = new File("src/main/java/org/example/visionplus-inno.apk");
//            System.out.println(f);
//            capabilities.setCapability(MobileCapabilityType.APP, "H:\\tesAppium5\\visionplus-inno.apk");
//            capabilities.setCapability(MobileCapabilityType.APP, "\\src\\main\\java\\org\\example\\visionplus-inno.apk");
            capabilities.setCapability(MobileCapabilityType.APP, "/home/ubuntu/tesAppium5/visionplus-inno.apk");
//            capabilities.setCapability(MobileCapabilityType.APP, "src/main/java/org/example/inno-video (1).apk");
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
package org.example;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
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
        capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"AOSP on IA Emulator");

        capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\iman akbar\\Downloads\\baru.apk");


        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");


        driver  = new AndroidDriver(url, capabilities);
        driver.findElement(By.id("login")).click();



        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("error");
            throw new RuntimeException(e);
        }

    }
}
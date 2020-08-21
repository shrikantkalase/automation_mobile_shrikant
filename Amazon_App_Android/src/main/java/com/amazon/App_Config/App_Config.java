package com.amazon.App_Config;
import com.amazon.Loadproperty_File.LoadProperty_File;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class App_Config {
    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }
    public WebDriverWait wait;
    public static AndroidDriver<AndroidElement> driver;
    @Parameters({"DEVICE_NAME","PLATFORM_NAME","VERSION"})
    @BeforeTest
    public void setup(String DEVICE_NAME,String PLATFORM_NAME,String VERSION ) throws IOException {
        try{
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(MobileCapabilityType.VERSION,VERSION);
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,DEVICE_NAME);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,PLATFORM_NAME);
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, LoadProperty_File.get_Property_Data("android_automationName"));
            capabilities.setCapability("appPackage", LoadProperty_File.get_Property_Data("android_packageName"));
            capabilities.setCapability("appActivity", LoadProperty_File.get_Property_Data("app_activityName"));
            capabilities.setCapability("app",System.getProperty("user.dir")+"/APK/Amazon_shopping.apk");     // APK location capability
            capabilities.setCapability(AndroidMobileCapabilityType.SUPPORTS_ALERTS, "true");  //autoGrant permission alerts
            capabilities.setCapability("autoGrantPermissions", "true");
            capabilities.setCapability("autoAcceptAlerts", "true");
            capabilities.setCapability(MobileCapabilityType.FULL_RESET,"true");  // It will reset application before every run.
            driver = new AndroidDriver<AndroidElement>(new URL(LoadProperty_File.get_Property_Data("appium_URL")), capabilities); //Create RemoteWebDriver instance and connect to the Appium server.
            wait = new WebDriverWait(driver, 30);
        }

        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void click_element(By element) throws InterruptedException {
        TimeUnit.SECONDS.sleep(4);
        driver.findElement(element).click();
    }

    public static MobileElement scroll_till_TV_item(){
        MobileElement scroll_till_TV_item = (MobileElement) driver
                .findElementByAndroidUIAutomator("new UiScrollable("
                        + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"65R625\"));");
        return scroll_till_TV_item;
    }

    public static MobileElement scroll_till_product_description(){
        MobileElement scroll_till_product_description = (MobileElement) driver
                .findElementByAndroidUIAutomator("new UiScrollable("
                        + "new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().textContains(\"Details\"));");
        return scroll_till_product_description;
    }



    @AfterTest
    public void tearDown() throws IOException {
        driver.quit();
    }

}

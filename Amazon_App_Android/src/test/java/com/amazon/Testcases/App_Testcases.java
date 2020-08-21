package com.amazon.Testcases;
import com.amazon.App_Config.App_Config;
import com.amazon.Loadproperty_File.LoadProperty_File;
import com.amazon.Locators.App_Locators;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Description;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class App_Testcases extends App_Config {
    App_Locators locate = new App_Locators(driver);
    public App_Testcases() throws IOException {
    }
    @BeforeClass @Description("Verify device orientation and app login with guest mode")
    public void app_login() throws IOException, InterruptedException {
        driver.rotate(ScreenOrientation.LANDSCAPE);
        System.out.println("checking device rotation in landscape");
        driver.rotate(ScreenOrientation.PORTRAIT);
        System.out.println("checking device rotation in portrait");
        click_element(locate.Skip_Sign_in); //Selecting skip sign-in option
        TimeUnit.SECONDS.sleep(5);
        Assert.assertTrue(driver.findElement(locate.Item_search_text_field).isDisplayed());
        System.out.println("User proceed into the app successfully");
     }
   @Test (priority = 1) @Description ("Search 65'inch TV and verify it on details screen")
    public void verify_search_item() throws InterruptedException, IOException {
        click_element(locate.Item_search_text_field);
        wait.until(ExpectedConditions.elementToBeClickable(locate.Item_search_text_field)).
                sendKeys(LoadProperty_File.get_Property_Data("search_item"));//Fetching search data from testdata properties file.
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        click_element(locate.US_pin_code);   //selecting pin code
        click_element(locate.Ship_outside_US);
        click_element(locate.select_shipping_country); // selected out side country "Australia"
        click_element(locate.Item_search_text_field);
        click_element(locate.select_search_suggestion);
        System.out.println("Searching 65 inch TV items which is shipped to Australia");
        scroll_till_TV_item();          //Scrolling page till desirable TV item.
        click_element(locate.select_TV);   //Tapped on TV item
        TimeUnit.SECONDS.sleep(5);
        Assert.assertTrue(driver.findElements(locate.product_detail_page_title).size()>0); //Verified that user reached on product detail page
        scroll_till_product_description();  //Scrolling to product description section.
        TimeUnit.SECONDS.sleep(3);
        String brand_tv = driver.findElement(locate.Brand_name).getText();
        System.out.println(brand_tv);
        System.out.println("Selected TV matches with user's requirement");
        driver.runAppInBackground(Duration.ofSeconds(5));

   }

   @Test (priority = 2) @Description("Get the TV price details and compare prices on detail page and checkout page")
    public void verify_price_item() throws InterruptedException, IOException {
        TimeUnit.SECONDS.sleep(5);
        click_element(locate.buying_option); // clicking on buying option for adding item into cart
        TimeUnit.SECONDS.sleep(5);
        String TV_price_detail_screen = driver.findElement(locate.price_details_screen).getText(); //Fetching price from product detail page
        System.out.println("TV price on detail screen"+" "+TV_price_detail_screen);
        click_element(locate.add_to_cart_detail_screen);    //Added to cart
        System.out.println("Tv item added into shopping cart");
        click_element(locate.Cart);    //Tapped on Shopping cart icon for checkout
        TimeUnit.SECONDS.sleep(3);
        String TV_price_checkout_screen = driver.findElement(locate.price_on_checkout_screen).getText();
        System.out.println("TV price on checkout screen"+" "+TV_price_checkout_screen);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(TV_price_detail_screen,TV_price_checkout_screen); //Comparing price with detail screen & check out screen
        System.out.println("compared prices on product details and check out details screen");
        Assert.assertEquals(TV_price_checkout_screen,LoadProperty_File.get_Property_Data("expected_tv_price")); //matching with expected price with external testdata property file.
        System.out.println("Added cart TV price does not match with expected value of external testdata property file");

   }





}

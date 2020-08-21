package com.amazon.Locators;
import com.amazon.App_Config.App_Config;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.io.IOException;
public class App_Locators extends App_Config {
  public AndroidDriver<AndroidElement> driver;
    public App_Locators(AndroidDriver<AndroidElement> driver) throws IOException {
    }
    public By Skip_Sign_in = MobileBy.id("com.amazon.mShop.android.shopping:id/skip_sign_in_button");
    public By Item_search_text_field = MobileBy.id("com.amazon.mShop.android.shopping:id/rs_search_src_text");
    public By Cart = MobileBy.AccessibilityId("Cart");
    public By US_pin_code= MobileBy.xpath("*//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/glow_subnav_label']");
    public By apply_pin_code = MobileBy.xpath("*//android.widget.button[@resource-id='com.amazon.mShop.android.shopping:id/loc_ux_update_pin_code']");
    public By Ship_outside_US = MobileBy.xpath("*//android.widget.TextView[@resource-id='com.amazon.mShop.android.shopping:id/loc_change_country_button']");
    public By select_shipping_country = MobileBy.xpath("*//android.widget.ListView[1]/android.widget.TextView[1]");
    public By select_search_suggestion = MobileBy.id("com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_text_layout");
    public By select_TV = MobileBy.xpath("*//android.widget.TextView[@text='by TCL']");
    public By product_detail_page_title = MobileBy.xpath("*//android.view.View[@resource-id='bylineInfo']");
    public By Brand_name = MobileBy.xpath("*//android.view.View/android.view.View[2]/android.view.View[7]");
    public By buying_option = MobileBy.xpath("*//android.widget.Button[@text='See All Buying Options']");
    public By price_details_screen = MobileBy.xpath("*//android.view.View[3]/android.view.View/android.view.View/android.view.View/android.view.View[3]");
    public By add_to_cart_detail_screen = MobileBy.xpath("*//android.view.View[6]/android.view.View[10]/android.view.View/android.widget.Button");
    public By price_on_checkout_screen = MobileBy.xpath("*//android.view.View[3]/android.view.View/android.view.View[3]/android.view.View[2]/android.view.View/android.view.View[3]/android.widget.ListView/android.view.View[1]");

}
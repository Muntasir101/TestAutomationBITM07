package com.BrowserOptions;

import com.Base.TestBase;
import com.OpenCart.Login;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessTest extends TestBase  {

    public static void main(String[] args) {
        ChromeBrowserHeadless();
        firefoxBrowserHeadless();
    }
    public static void ChromeBrowserHeadless(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions crobj=new ChromeOptions();
        crobj.setHeadless(true);
        driver=new ChromeDriver(crobj);
        Login.TC_001_Valid();
        System.out.println("Headless Chrome Test DONE");
    }

    public static void firefoxBrowserHeadless(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        FirefoxOptions frobj=new FirefoxOptions();
        frobj.setHeadless(true);
        driver=new FirefoxDriver(frobj);
        Login.TC_002_InValid();
        System.out.println("Headless Firefox Test DONE");
    }
}

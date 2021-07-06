package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
    public static WebDriver driver;

    public static void main(String[] args) {
        chromeLaunch();
        chromeClose();
        firefoxLaunch();
        firefoxClose();
    }
    public static void chromeLaunch(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        System.out.println("Chrome Launch Successfully!!!");
    }

    public static void firefoxLaunch(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        System.out.println("Firefox Launch Successfully!!!");
    }

    public static void chromeClose(){
        driver.close();
        System.out.println("Chrome Closed!!!");
    }
    public static void firefoxClose(){
        driver.close();
        System.out.println("Firefox Closed!!!");
    }

    public static void openTestURL(String URL){
        driver.get(URL);
    }

}

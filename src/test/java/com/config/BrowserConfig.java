package com.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserConfig {

    public static WebDriver driver;

    public static void main(String[] args) {
        chromeLaunch();
        chromeClose();
        firefoxLaunch();
        firefoxClose();
    }
    public static void chromeLaunch(){
        //Set Chrome Driver path
        //Static path
       // System.setProperty("webdriver.chrome.driver","F:\\Training\\PeopleNTech\\BITM Online 7\\Tools\\chromedriver.exe");

        //Dynamic path
         System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        //online
        driver.get("https://google.com");
        //Local host
        driver.get("http://127.0.0.1:8080/myapplication.html");
        //Offline
      //  driver.get("file:///F:/Training/PeopleNTech/BITM Online 7/Your Store.html");
        System.out.println("Chrome Launch Successfully!!!");
    }

    public static void firefoxLaunch(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.get("https://apple.com");
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

}

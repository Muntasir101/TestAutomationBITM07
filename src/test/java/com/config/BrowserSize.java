package com.config;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSize extends BrowserConfig{

    public static void main(String[] args) {
        firefoxLaunch();
        Screen_PC();
        getScreenSize();
        firefoxClose();
    }
    public static void firefoxLaunch(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.get("https://apple.com");
        System.out.println("Firefox Launch Successfully!!!");
    }
    public static void getScreenSize(){
        //get screen size
        int height=driver.manage().window().getSize().getHeight();
        int width=driver.manage().window().getSize().getWidth();
        System.out.println("Screen Width: "+width +" and Height :"+height); //Width: 1382 and Height :744

    }

    public static void Screen_PC(){
        //set screen size
        driver.manage().window().setSize(new Dimension(769,400));
    }
    public static void Screen_Tab(){
        driver.manage().window().setSize(new Dimension(768,400));
    }
}

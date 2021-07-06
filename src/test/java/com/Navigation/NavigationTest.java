package com.Navigation;

import com.Base.TestBase;

public class NavigationTest extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestURL("https://demo.opencart.com/");
        navigateTo("https://googl.com");
        navigateBack();
        navigateForward();
        navigateTo("https://bbc.com");

    }
    public static void navigateTo(String URL){
        driver.navigate().to(URL);
        System.out.println("Navigate TO: "+driver.getTitle());
    }
    public static void navigateBack(){
        driver.navigate().back();
        System.out.println("Navigate Back TO: "+driver.getTitle());
    }
    public static void navigateForward(){
        driver.navigate().forward();
        System.out.println("Navigate Forward TO: "+driver.getTitle());
    }
    public static void navigateRefresh(){
        driver.navigate().refresh();
    }
}

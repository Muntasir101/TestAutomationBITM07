package com.Alerts;

import com.Base.TestBase;

public class AllAboutAlerts extends TestBase {

    public static void main(String[] args) {
        firefoxLaunch();
        openTestURL("https://the-internet.herokuapp.com/javascript_alerts");
        normalAlert();
        confirmAlert();
        promptAlert();
        firefoxClose();
    }
    public static void normalAlert(){
        getElementByCSSandClick("#content > div > ul > li:nth-child(1) > button");
        alertAccept();
    }
    public static void confirmAlert(){
        getElementByCSSandClick("#content > div > ul > li:nth-child(2) > button");
        alertCancel();
    }
    public static void promptAlert(){
        getElementByCSSandClick("#content > div > ul > li:nth-child(3) > button");
        driver.switchTo().alert().sendKeys("Test Automation Rockzzz");
        alertAccept();
    }
}

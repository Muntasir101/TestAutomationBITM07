package com.Frames;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFramesTest extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestURL("https://the-internet.herokuapp.com/iframe");
        singleFrame();
    }
    public static void singleFrame(){
        //Locate iFrame
        driver.switchTo().frame("mce_0_ifr");

        WebElement iFrameBody=driver.findElement(By.id("tinymce"));
        iFrameBody.clear();
        iFrameBody.sendKeys("Test Automation ROCKZZZ");
    }
}

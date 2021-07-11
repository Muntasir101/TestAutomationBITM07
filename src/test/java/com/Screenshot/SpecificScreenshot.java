package com.Screenshot;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class SpecificScreenshot extends TestBase {
    public static void main(String[] args) throws IOException {
        firefoxLaunch();
        openTestURL("https://demo.opencart.com/index.php?route=account/login");
        captureWebElement();
        firefoxClose();
    }
    public static void captureWebElement() throws IOException {
        WebElement captureElement=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div"));

        //take Screenshot
        File srcFile= ((TakesScreenshot)captureElement).getScreenshotAs(OutputType.FILE);

        //Save Image
        FileUtils.copyFile(srcFile,new File("./src/test/Screenshots/Element.jpg"));
    }
}

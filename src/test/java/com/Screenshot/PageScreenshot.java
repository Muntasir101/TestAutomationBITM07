package com.Screenshot;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class PageScreenshot extends TestBase {
    public static void main(String[] args) throws IOException {
        firefoxLaunch();
        openTestURL("https://demo.opencart.com/");
        generateScreenshot();
        firefoxClose();
    }
    public static void generateScreenshot() throws IOException {
        //take Screenshot
       File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

       //Save Image
        FileUtils.copyFile(srcFile,new File("./src/test/Screenshots/pageImage.png"),true);

    }

}

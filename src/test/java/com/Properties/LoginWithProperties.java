package com.Properties;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/*
1. Go to login page.
2. Type Email.
3. Type Password.
4. Click Login button.
 */

public class LoginWithProperties extends TestBase {
    public static void main(String[] args) throws IOException {
        firefoxLaunch();
        TC_001_Valid();
        TC_002_InValid();
        firefoxClose();
    }
    public static void TC_001_Valid() throws IOException {
        //Read Properties FIle
        FileInputStream fis=new FileInputStream("./src/test/resources/OR.properties");
        Properties prObj=new Properties();
        prObj.load(fis);

        //Step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Step 2
        WebElement Email=driver.findElement(By.id("input-email"));
       // Email.sendKeys("user101@gmail.com");
        Email.sendKeys(prObj.getProperty("Email"));

        //Step 3
        WebElement Password=driver.findElement(By.id("input-password"));
        //Password.sendKeys("123456");
        Password.sendKeys(prObj.getProperty("Pass"));

        //Step 4
        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();

        //Logic Develop
        //Login Pass
        String Exp_Title="My Account";
        String Act_Title=driver.getTitle();

        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test Passed for valid Data.");
            //Logout
            WebElement logout=driver.findElement(By.linkText("Logout"));
            logout.click();
            captureScreenshot("LoginTest_Valid_Properties",".png");
        }
        else{
            System.out.println("Test Failed for valid Data.Yahooooo Bug Found.");
        }


    }
    public static void TC_002_InValid() throws IOException {
        //Read Properties FIle
        FileInputStream fis=new FileInputStream("./src/test/resources/OR.properties");
        Properties prObj=new Properties();
        prObj.load(fis);

        //Step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Step 2
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys(prObj.getProperty("Email_invalid"));

        //Step 3
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys(prObj.getProperty("Pass_Invalid"));

        //Step 4
        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();

        //Login Pass
        String Exp_Title="My Account";
        String Act_Title=driver.getTitle();

        if(!Exp_Title.equals(Act_Title)){
            System.out.println("Test Passed for Invalid Data.");
            captureScreenshot("LoginTest_InValid_Properties",".png");
        }
        else{
            System.out.println("Test Failed for Invalid Data.Yahooooo Bug Found.");
            //Logout
            WebElement logout=driver.findElement(By.linkText("Logout"));
            logout.click();

        }
    }
}

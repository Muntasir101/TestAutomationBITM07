package com.TestNG;

import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTestAdvance2 {
    WebDriver driver;
    String LoginURL="https://demo.opencart.com/index.php?route=account/login";

    @BeforeClass
    public void initSetup(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        Log.info("Firefox Launch Successfully.");
        driver.get(LoginURL);
        Log.info("Login Page Open Successfully.");
    }
    @AfterClass
    public void tearDown(){
        driver.close();
        Log.info("Firefox Close Successfully.");
    }

    @Test
    public void TC_001_Valid(){
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("user101@gmail.com");
        Log.info("Type Email");

        //Step 3
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");
        Log.info("Type Password");

        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
        Log.info("Click on Login Button");

        //Logic Develop
        //Login Pass
        String Exp_Title="My Account";
        String Act_Title=driver.getTitle();

        //Assertion
        Assert.assertEquals(Exp_Title,Act_Title);

        //Logout
        WebElement logout=driver.findElement(By.linkText("Logout"));
        logout.click();

        driver.findElement(By.linkText("Login")).click();
    }

    @Test
    public void TC_002_InValid(){
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("user101@gmail.com");
        Log.info("Type Email");

        //Step 3
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("123456232323");
        Log.info("Type Password");

        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
        Log.info("Click on Login Button");

        //Logic Develop
        //Login Pass
        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        //Assertion
        Assert.assertEquals(Exp_Title,Act_Title);
    }
}

package com.DataProvider;

import com.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DP_LoginTest {
    WebDriver driver;
    String LoginURL="https://demo.opencart.com/index.php?route=account/login";

    @BeforeClass
    @Parameters("Browser")
    public void initSetup(String browserName){
        if(browserName.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");
            driver = new FirefoxDriver();
            Log.info("Firefox Launch Successfully.");
        }
        else if(browserName.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            Log.info("Chrome Launch Successfully.");
        }

    }

    @AfterClass
    public void tearDown(){
        driver.close();
        Log.info("Firefox Close Successfully.");
    }

    @DataProvider(name ="LoginData_Invalid")
    public Object [] [] data(){

        Object [] [] data=new Object[3][2];
        //set1
        data [0][0]="mail1@mail.com";
        data [0][1]="213213213";

        //set2
        data [1][0]="mail2@test";
        data [1][1]="fdadad";

        //set3
        data [2][0]="asasdas.co";
        data [2][1]="";

        return data;
    }

    @Test(dataProvider ="LoginData_Invalid")
    public void TC_001_InValid(String DP_Email, String DP_Pass){
        driver.get(LoginURL);
        Log.info("Login Page Open Successfully.");

        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys(DP_Email);
        Log.info("Type Email: "+DP_Email);

        //Step 3
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys(DP_Pass);
        Log.info("Type Password: "+DP_Pass);

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

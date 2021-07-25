package com.DataDriven;

import com.utils.Log;
import com.utils.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DD_LoginTest {
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

    @Test
    public void TC_001_InValid(){
        driver.get(LoginURL);
        Log.info("Login Page Open Successfully.");

        //Excel
        Xls_Reader reader=new Xls_Reader("./src/test/resources/LoginData.xlsx");
        String sheetName="Sheet1";

        int rowCount= reader.getRowCount(sheetName);

        for(int rowNum=2; rowNum<=rowCount;rowNum++){
            String email=reader.getCellData(sheetName,"Email",rowNum);
            String pass=reader.getCellData(sheetName,"Password",rowNum);

            WebElement Email=driver.findElement(By.id("input-email"));
            Email.clear();
            Email.sendKeys(email);
            Log.info("Type Email: "+email);

            //Step 3
            WebElement Password=driver.findElement(By.id("input-password"));
            Password.clear();
            Password.sendKeys(pass);
            Log.info("Type Password: "+pass);

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
}

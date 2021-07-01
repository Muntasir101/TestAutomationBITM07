package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
/*
1. Go to login page.
2. Type Email.
3. Type Password.
4. Click Login button.
 */

public class Login extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        TC_001_Valid();
        TC_002_InValid();
       // firefoxClose();
    }
    public static void TC_001_Valid(){
        //Step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Step 2
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("user101@gmail.com");

        //Step 3
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");

        //Step 4
        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();

        //Logout
        WebElement logout=driver.findElement(By.linkText("Logout"));
        logout.click();

    }
    public static void TC_002_InValid(){
        //Step 1
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Step 2
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.sendKeys("user101@gmail");

        //Step 3
        WebElement Password=driver.findElement(By.id("input-password"));
        Password.sendKeys("123456");

        //Step 4
        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();
    }
}

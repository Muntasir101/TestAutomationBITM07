package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register extends TestBase {
   // private static boolean Firstname;
    private final String FirstName2Char="ad";
    private final String FirstName1Char="a";
    private final String FirstName32Char="adasdasdad";
    private final String FirstName50Char="adasdasdad";

    public static void main(String[] args) {
        chromeLaunch();
        TC_01_valid();
    }

    public static void TC_01_valid() {
        driver.get("https://demo.opencart.com/index.php?route=account/register");

//        WebElement First_name = driver.findElement(By.id("input-firstname"));
//        First_name.sendKeys("");
//
//        WebElement Last_name = driver.findElement(By.id("input-lastname"));
//        Last_name.sendKeys("");

        WebElement Email = driver.findElement(By.id("input-email"));
        Email.sendKeys("test.com");

//        WebElement Telephone = driver.findElement(By.id("input-telephone"));
//        Telephone.sendKeys("00234625178");
//
//        WebElement Password = driver.findElement(By.id("input-password"));
//        Password.sendKeys("12345");
//
//        WebElement Confirm_password = driver.findElement(By.id("input-confirm"));
//        Confirm_password.sendKeys("12345");

        WebElement ClickOnAgree = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]"));
        ClickOnAgree.click();

        WebElement ClickContinue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        ClickContinue.click();

        String EmailvalidationMsg=driver.switchTo().alert().getText();
        System.out.println(EmailvalidationMsg);

    }

    public static void inputFieldValidationTest(){
        WebElement ClickContinue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        WebElement First_name = driver.findElement(By.id("input-firstname"));
        First_name.sendKeys("dasdassdadasdasdasdasdasdasdasdasdasdasdasdasdasdasd");

        ClickContinue.click();

        String Exp_validationMessage="First Name must be between 1 and 32 characters!";
        String Act_validationMessage=driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > div")).getText();

        if(Exp_validationMessage.equals(Act_validationMessage))
        {
            System.out.println("First Name validation Pass");
        }
        else{
            System.out.println("Test Failed for First name.Yahooooo Bug Found.");
        }
    }

    public boolean Firstname(){
        WebElement ClickContinue = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]"));
        WebElement First_name = driver.findElement(By.id("input-firstname"));
        First_name.sendKeys("dasdassdadasdasdasdasdasdasdasdasdasdasdasdasdasdasd");

        getElementByCSSAndType("dsasadasd","name");
        getElementByCSSAndClick("assdadasd");

        ClickContinue.click();

        String Exp_validationMessage="First Name must be between 1 and 32 characters!";
        String Act_validationMessage=driver.findElement(By.cssSelector("#account > div:nth-child(3) > div > div")).getText();

        if(Exp_validationMessage.equals(Act_validationMessage))
        {
            System.out.println("First Name validation Pass");
        }
        return true;
    }


}

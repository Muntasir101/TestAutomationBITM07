package com.DropDowns;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AllAboutDropDown extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openTestURL("https://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        selectOptionByIndex();
        selectOptionByValue();
        selectOptionByVisibleText();
    }
    public static void selectOptionByIndex(){
        WebElement dropDown=driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropDown);
        obj.selectByIndex(1);
    }
    public static void selectOptionByValue(){
        WebElement dropDown=driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropDown);
        obj.selectByValue("2");
    }
    public static void selectOptionByVisibleText(){
        WebElement dropDown=driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropDown);
        obj.selectByVisibleText("Option 1");
    }
}

package com.Cucumber;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginStep {
    WebDriver driver;

    @Given("Open Browser and Navigate to Login page")
    public void open_browser_and_navigate_to_login_page() {
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        System.out.println("Firefox Launch Successfully!!!");
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @When("Enter valid email and password")
    public void enter_valid_email_and_password() {
        WebElement Email=driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("mail@mmm.www");

        WebElement Password=driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("12345");

        WebElement LoginBtn=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input"));
        LoginBtn.click();

    }

    @And("Login success ")
    public void login_success(){
        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        if(Exp_Title.equals(Act_Title)){
            //excel write
            System.out.println("Test Passed");
        }

        else {
            System.out.println("Test Failed");
        }
    }

    @Then(" Close Test")
    public void  lose_test() {
          driver.close();
    }
}

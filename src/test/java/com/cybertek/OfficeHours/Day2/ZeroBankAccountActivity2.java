package com.cybertek.OfficeHours.Day2;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ZeroBankAccountActivity2 {
    //Declare our driver object
    WebDriver driver;
    Select accountsDropDown;

    @BeforeClass
    public void setupClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/login.html");
        //CSS LOCATOR

        //LOCATING DYNAMIC ELEMENT WITH CONTAINS

        //The following syntax could be used when any part of the attribute is static.

        //TagName[attribute*=‘value’]  :  * Symbol for looking any part of the value

//[attribute*=‘value’] : any tag name with that following syntax

        //login
        driver.findElement(By.cssSelector("[id*='user_log']")).sendKeys("username");
        //password
        driver.findElement(By.cssSelector("[id*='user_pass']")).sendKeys("password");
        //sign in button
        driver.findElement(By.cssSelector("[type*='sub']")).click();
        //Back to safety button
        driver.findElement(By.cssSelector("[id*='primary-']")).click();
    }

    @Test
    public void accountActivity01() {
        //account activity page
        driver.findElement(By.cssSelector("[id*='acco']")).click();
        String expectedTitle = "Zero - Account Activity";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "verify title");
    }


    @Test
    public void accountActivity02() {

        ArrayList<String> expectedOptions = new ArrayList<>(Arrays.asList("Savings", "Checking",
                "Savings", "Loan", "Credit Card", "Brokerage"));
        accountsDropDown = new Select(driver.findElement(By.cssSelector("[id*='aa']")));
        List<WebElement> actualOptions = accountsDropDown.getOptions();

        List<String> actualOptionsText = new ArrayList<>();
        for (WebElement actualOption : actualOptions) {
            actualOptionsText.add(actualOption.getText());

        }

        Assert.assertEquals(actualOptionsText, expectedOptions, "verify DropDown options");

    }

        @Test
        public void accountActivity03() {


        accountsDropDown.selectByVisibleText("Brokerage");

        String expectedText = "No results.";
        String actualText = driver.findElement(By.cssSelector("[class*='well']")).getText();

        Assert.assertEquals(actualText, expectedText, "verify result text ");

    }

    @AfterClass
    public void tearDownClass() {
        driver.quit();
    }
}

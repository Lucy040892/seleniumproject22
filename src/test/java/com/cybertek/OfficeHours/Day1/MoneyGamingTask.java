package com.cybertek.OfficeHours.Day1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MoneyGamingTask {

    @Test
    public void Task1() {
        //Open Chrome Browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://moneygaming.qa.gameaccount.com/");
        //let's handle time delays
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Click the JOIN button to open the registration page
        WebElement joinButton = driver.findElement(By.xpath("//a[@class='newUser green']"));
        joinButton.click();
        //Select a title value from the dropdown
        //locate select dropdown webelement
        //xpath = //select[@class='title required']
        WebElement titleElement = driver.findElement(By.id("title"));
        //we need to create our select object so we can reach select class method
        Select titleDropDown = new Select(titleElement);
        //we are going to add a Mr to gaming
        titleDropDown.selectByVisibleText("Mr");
        //verify that Mr is selected
        String expectedTitle = "Mr";
        String actualTitle = titleDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualTitle, expectedTitle, "verify the title");

        //Enter first and last name in the form
        //first name and last name box
        WebElement firstName = driver.findElement(By.xpath("//input[aname='map(firstName)']"));
        WebElement lastName = driver.findElement(By.xpath("//input[aname='map(lastName)']"));
        firstName.sendKeys("Mike");
        lastName.sendKeys("Smith");

        //Check the termbox with text
        WebElement termBox = driver.findElement(By.xpath("//input[@name='map(terms)']"));
        termBox.click();
        //Submit the form by clicking the JOIN NOW button
        WebElement submitButton = driver.findElement(By.xpath("//input[@value='Join Now!']"));
        submitButton.click();
        //Validate that a validation message with text 'This field is required' appears under the date
        //of birth box
        String expectedError = "This field is required";
        String actualError = driver.findElement(By.xpath("//label[@for='dob']")).getText();

        Assert.assertEquals(actualError, expectedError, "verify DOB error message");






    }
}

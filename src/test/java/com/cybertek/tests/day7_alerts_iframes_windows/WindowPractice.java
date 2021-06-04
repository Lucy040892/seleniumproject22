package com.cybertek.tests.day7_alerts_iframes_windows;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WindowPractice {
    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }
    @Test
    public void window_test() {
        //Printing out the window handle of the first page opened
        //Storing the first windowHandle into a String is a useful practice for future needs when we need
        //to switch back to  it
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " +mainHandle);

        //Assert: Title is "Practice"
        String actualTitleBeforeClick = driver.getTitle();
        String expectedTitleBeforeClick = "Practice";
        System.out.println("actualTitleBeforeClick = " +actualTitleBeforeClick);

        //Click to: "Click Here" text
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        for(String eachWindow : driver.getWindowHandles()) {
            driver.switchTo().window(eachWindow);
            System.out.println("CURRENT TITLE WHILE SWITCHING: " +driver.getTitle());

        }



        String actualTitleAfterClick = driver.getTitle();

        //Switch to new Window
        //Assert: Title is "New Window"
    }
}

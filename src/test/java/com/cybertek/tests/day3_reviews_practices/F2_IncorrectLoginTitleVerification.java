package com.cybertek.tests.day3_reviews_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class F2_IncorrectLoginTitleVerification {
    public static void main(String[] args) throws InterruptedException {
        //1.Open chrome browser
        //setup browser driver
        WebDriverManager.chromedriver().setup();
        //create driver instance and open browser
        WebDriver driver = new ChromeDriver();
        //use the 'driver' object created to use selenium methods
        //maximize browser
        driver.manage().window().maximize();
        //2.Go to facebook
        driver.get("https://www.facebook.com");
        //3. Enter incorrect username
        //Locating the web element using id locator and storing it in WebElement type
        WebElement inputUserName = driver.findElement(By.id("email"));
        //Enter incorrect username
        inputUserName.sendKeys("something123@gmail.com");
        //Locate the web element using
        //Enter incorrect password
        WebElement inputPassword = driver.findElement(By.id("pass"));
        inputPassword.sendKeys("some wrong password" + Keys.ENTER);
        //5. Verify title changed to:
        //Expected: "Log into Facebook"
        String expectedTitle = "Log into Facebook";
        System.out.println("expectedTitle = " + expectedTitle);
        //Freezing the code for 5 seconds so that Chrome browser can catch up with loading the page
        Thread.sleep(5000);
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is PASSED");
        }else{
            System.out.println("Title verification is FAILED");
        }
    }
}

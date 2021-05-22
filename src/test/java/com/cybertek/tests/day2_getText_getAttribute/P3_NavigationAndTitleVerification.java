package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P3_NavigationAndTitleVerification {
    public static void main(String[] args) {
        // TC Back and forth navigation
        //Open a chrome browser;
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to google
        driver.get("https:/www.google.com");
        //3. Click to Gmail from top right
        //<---locating the web element--------><-click->
        //driver.findElement(By.linkText("Gmail")).click();
        driver.findElement(By.partialLinkText("mail")).click();
        //4-Verify title contains:
        //Expected: Gmail
        String expectedInTitle = "Gmail";
        String actualTitle = driver.getTitle();
        if(actualTitle.contains(expectedInTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }
        //MAC: COMMAND + D: multiplies the current line
        //WINDOWS: control + D: multiplies the current line

        //MAC: moving the line up and down: command + shift + up/down arrow
        //5- Go back to the Google by using the .back();
        driver.navigate().back();
        //6- Verify title equals:
        //Expected: Google
        String expectedGoogleTitle = "Google";
        String actualGoogleTitle = driver.getTitle();
        if(actualGoogleTitle.equals(expectedGoogleTitle)){
            System.out.println("Title verification PASSED!");
        }else{
            System.out.println("Title verification FAILED!");
        }

    }
}

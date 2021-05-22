package com.cybertek.tests.day3_reviews_practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F1_TitleVerification {
    public static void main(String[] args) {
        //TC #1: Facebook title verification
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
        //3. Verify title:
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        //Expected: "Facebook - Log In or Sign Up"
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is PASSED");
        }else{
            System.out.println("Title verification is FAILED");
        }
    }
}

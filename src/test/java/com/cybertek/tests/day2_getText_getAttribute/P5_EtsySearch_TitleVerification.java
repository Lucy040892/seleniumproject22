package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P5_EtsySearch_TitleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to etsy
        driver.get("https://www.etsy.com");
        //3. Search for "wooden spoon"
        //1. We need to locate search bar
        //2. We enter search value
        //3. We press ENTER
        driver.findElement(By.id("global-enhancements-search-query")).sendKeys("wooden spoon" + Keys.ENTER);
        //4. Verify title:
        //Expected: "Wooden spoon | Etsy"
        String expectedTitle = "Wooden spoon | Etsy";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Etsy title verification PASSED!");
        }else{
            System.out.println("Etsy title verification FAILED!");
        }

        
    }
}

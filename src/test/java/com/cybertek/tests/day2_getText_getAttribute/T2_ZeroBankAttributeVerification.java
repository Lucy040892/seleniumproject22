package com.cybertek.tests.day2_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBankAttributeVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://zero.webappsecurity.com/login.html");
        //Locate the link and store inside of WebElement
        WebElement zeroBankLink = driver.findElement(By.className("brand"));
        //3. Verify link text from top left:
        //Expected: "Zero Bank"
        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLink.getText();
        if(actualLinkText.equals(expectedLinkText)){
            System.out.println("Link text verification PASSED!");
        }else{
            System.out.println("Link text verification FAILED!");
        }
        //4. Verify link href attribute value contains:
        //Expected: "index.html"
        String expectedInAttributeValue = "index.html";
        String actualHrefValue = zeroBankLink.getAttribute("href");
        System.out.println("actualHrefValue = " + actualHrefValue);
        if(actualHrefValue.contains(expectedInAttributeValue)){
            System.out.println("HREF attribute value verification PASSED!");
        }else{
            System.out.println("HREF attribute value verification FAILED!");
        }

    }
}

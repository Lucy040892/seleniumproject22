package com.cybertek.tests.day5_findElements_checkboxes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P0_FindElements_Practice {
    public static void main(String[] args) {
        //TC #0: FINDELEMENTS
        //Go to http://practice.cybertekschool.com/forgot_password
        //Print out the texts of all links
        //Print out how many total links
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //If a web element is not found, this will wait UP TO given seconds
        //If web element is located before 15 seconds, it will move on
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/forgot_password");

        //WE NEED TO CREATE A LOCATOR THAT RETURNS US ALL THE LINKS ON THE PAGE
        //   //body//a -> This locator will return all of the links on the page
        //we are storing all of the links that are returned by findElements method
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        //iter + Enter -> shortcut for for each loop
        //fori + Enter -> shortcut for regular for loop
        for (WebElement each : listOfLinks) {
            System.out.println(each.getText());
            System.out.println(each.getAttribute("href"));

        }
        int numberOfLinks = listOfLinks.size();
        System.out.println("numberOfLinks = " + numberOfLinks);


        }
    }


package com.cybertek.tests.day6_testing_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class P03_Apple_task {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.apple.com");

        //Click to all of the headers one by one (Mac, IPad, IPhone, Watch,...)
        //Storing 9 web elements including "apple" logo, and search box
        List<WebElement> headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));
        //in loop we start from 1 to avoid Apple logo, and finish with -2 to avoid search box and bag

        for(int eachLink = 1; eachLink < headerLinks.size()-1; eachLink++) {
            //System.out.println(headerLinks.get(eachLink).getText());
            headerLinks.get(eachLink).click();
            Thread.sleep(1000);
            //we need to refresh variable value, because we changed page
            headerLinks = driver.findElements(By.xpath("//ul[@class='ac-gn-list']//li/a"));

            //Print out the titles of the each page
            System.out.println("Current title in the page: " +driver.getTitle());

            //Print out total number of links in each page
            List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));
            System.out.println("Total number of links in current page: " +allLinks.size());

            //While in each page:
            //a. Print out how many link is missing text TOTAL
            //b. Print out how many link has text TOTAL

            int linksWithNoText = 0;
            int linksWithText = 0;

            for (WebElement each : allLinks) {
                if(each.getText().isEmpty()) {
                    linksWithNoText++;
                }else{
                    linksWithText++;
                }

            }
            System.out.println("--> Current page links with NO TEXT: " +linksWithNoText);
            System.out.println("--> Current page links with TEXT: " +linksWithText);

        }
    }
}

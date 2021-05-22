package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        //1- setup the browser driver
        WebDriverManager.chromedriver().setup();

        //2- create instance of selenium web driver
        //this line opens a browser
        WebDriver driver = new ChromeDriver();

        //this line will basically maximize the browser size
        driver.manage().window().maximize();

        //will work for mac only, will not work in windows
        driver.manage().window().fullscreen();

        //3- get the page for Tesla.com
        driver.get("https://www.tesla.com");

        System.out.println("Current title: " + driver.getTitle());

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL = " +currentUrl);

        //putting 3 seconds of wait/ stops the code for 3 sec
        Thread.sleep(3000);

        //going back using navigations
        driver.navigate().back();

        //putting 3 seconds of wait/ stops the code for 3 sec
        Thread.sleep(3000);

        //going forward using navigations
        driver.navigate().forward();

        //putting 3 seconds of wait/ stops the code for 3 sec
        Thread.sleep(3000);

        //refreshing the page using navigations
        driver.navigate().refresh();

        //putting 3 seconds of wait/ stops the code for 3 sec
        Thread.sleep(3000);

        //going to another url using .to() method
        driver.navigate().to("https://www.google.com");

        System.out.println("Current title: " +driver.getTitle());

        currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL = " +currentUrl);

        //this method will close the currently opened browser
        //it will only close 1 browser or 1 tab
        driver.close();

        //drive.quit();


    }
}

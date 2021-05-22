package com.cybertek.tests.day4_cssSelextor_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5WebOrdersLogin {
    public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome"); //We created method for this
        driver.manage().window().maximize();
        driver.get("http://www");

        String expectedTitle = "Web Orders Login";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Login page title verification PASSED!");
        }else{
            System.out.println("Login page title verification FAILED!");
        }
        WebElement inputUsername = driver.findElement(By.id("ct100_MainContent_username"));
        inputUsername.sendKeys("Tester");

        WebElement inputPassword = driver.findElement(By.id("ct100_MainContent_password"));
        inputPassword.sendKeys("test");

        WebElement loginButton = driver.findElement(By.id("ct100_MainContent_login_button"));
        loginButton.click();

        String expectedHomePageTitle = "Web Orders";
        String actualHomePageTitle = driver.getTitle();
        if(actualHomePageTitle.equals(expectedHomePageTitle)){
            System.out.println("Home page title verification PASSED!");
        }else{
            System.out.println("Home page title verification FAILED!");
        }
    }
}

package com.cybertek.tests.day4_cssSelextor_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P1_ccsSelector_Cybertek {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //"Forgot password" header
        WebElement forgotPasswordHeader = driver.findElement(By.tagName("h2"));
        //Email text
        WebElement emailLabel = driver.findElement(By.cssSelector("label[for='email']"));
        //Email input box
        WebElement inputEmail = driver.findElement(By.cssSelector("input[name='email']"));
        //"Retrieve password" button
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button[id='form_submit']"));

        //"Powered by Cybertek Scholl" text
        WebElement poweredByText = driver.findElement(By.cssSelector("div[style='text-align: center;']"));

        //Verify all WebElements are displayed
        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed()); // SHORT CUT! homeLink.isDisplayed().sotv ENTER
        System.out.println("forgotPasswordHeader.isDisplayed() = " + forgotPasswordHeader.isDisplayed());
        System.out.println("emailLabel.isDisplayed() = " + emailLabel.isDisplayed());
        System.out.println("inputEmail.isDisplayed() = " + inputEmail.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());
        System.out.println("poweredByText.isDisplayed() = " + poweredByText.isDisplayed());


    }
}

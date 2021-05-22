package com.cybertek.tests.day4_cssSelextor_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P6_xpath_MultipleButtons {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        //Click on Button 1
        //locating using XPATH with class atribute value
        //WebElement button1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));

        //locating using text of the button with XPATH
        //WebElement button1 = driver.findElement(By.xpath("//button[.='Button 1']"));

        //locating using "onclick" attribute value with xpath locator
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedText = "Clicked on button one!";
        String actualText = resultText.getText();

        if(actualText.equals(expectedText)){
            System.out.println("Result text verification PASSED!");
        }else{
            System.out.println("Result text verification FAILED!");
        }
    }
}

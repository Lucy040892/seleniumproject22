package com.cybertek.tests.day6_testing_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class PO_Checkbox_Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //Confirm checkbox #1 is NOT selected by default
        if(!checkbox1.isSelected()) {
            System.out.println("Checkbox 1 is not selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox 1 is selected. Verification FAILED!");
        }
        //Confirm checkbox #2 is SELECTED by default
        if(checkbox2.isSelected()) {
            System.out.println("Checkbox 2 is selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox 2 is not selected. Verification FAILED!");
        }
        //Click checkbox #1 to select it
        Thread.sleep(2000);
        checkbox1.click();
        //Click checkbox #2 to deselect it
        Thread.sleep(2000);
        checkbox2.click();

        //Confirm checkbox1 is selected
        if(checkbox1.isSelected()) {
            System.out.println("Checkbox 1 is  selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox 1 is NOT selected. Verification FAILED!");
        }
        //Confirm checkbox #2 is not selected
        if(!checkbox2.isSelected()) {
            System.out.println("Checkbox 2 is NOT selected. Verification PASSED!");
        }else{
            System.out.println("Checkbox 2 is selected. Verification FAILED!");
        }
        driver.close();


    }
}

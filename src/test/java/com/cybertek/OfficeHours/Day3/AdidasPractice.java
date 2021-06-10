package com.cybertek.OfficeHours.Day3;
//In this task we will handle alerts, we will create a method that can be used in our test case for repeated actions. Try to stick to DRY (don't repeat yourself) concept.
//If something is repeating try to create a solution for that.
// You have to implement the following Web automated checks over our (Adifas) DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
//• Customer navigation through product categories: Phones, Laptops and Monitors
//• Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
//• Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart". Accept pop up confirmation.
//• Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart". Accept pop up confirmation.
//• Navigate to "Cart" → Delete "Apple monitor 24" from cart.
//• Click on "Place order".
//• Fill in all web form fields.
//• Click on "Purchase"
//• Capture and log purchase Id and Amount.
//• Assert purchase amount equals expected.
//• Click on "Ok"
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.OfficeHoursUtils;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
public class AdidasPractice {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.demoblaze.com/index.html");
    }
    @Test
    public void adidasTest(){
        // Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart".
        OfficeHoursUtils.productAdder(driver,"Laptops","Sony vaio i5");
        // Navigate to "Phones" → "Samsung galaxy s6" and click on "Add to cart".
        OfficeHoursUtils.productAdder(driver,"Phones","Samsung galaxy s6");
        // Navigate to "Monitors" → "Apple monitor 24" and click on "Add to cart".
        OfficeHoursUtils.productAdder(driver,"Monitors","Apple monitor 24");
        // Remove  Apple monitor 24
        OfficeHoursUtils.productRemover(driver,"Apple monitor 24");
        driver.findElement(By.xpath("//button[.='Place Order']")).click();
        Faker faker = new Faker();
        driver.findElement(By.id("name")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("country")).sendKeys(faker.country().name());
        driver.findElement(By.id("city")).sendKeys(faker.country().capital());
        driver.findElement(By.id("card")).sendKeys(faker.finance().creditCard());
        driver.findElement(By.id("month")).sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        driver.findElement(By.id("year")).sendKeys(String.valueOf(faker.number().numberBetween(2022,2030)));
        driver.findElement(By.xpath("//button[.='Purchase']")).click();
        BrowserUtils.sleep(1);
        String confirmation = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
        System.out.println("confirmation = " + confirmation);
        String[] confirmationArray = confirmation.split("\n");
        String orderID = confirmationArray[0];
        System.out.println("orderID = " + orderID);
        int actualAmmount = Integer.parseInt(confirmationArray[1].split(" ")[1]);
        System.out.println("actualAmmount = " + actualAmmount);
        int expectedAmount = 1150;

        Assert.assertEquals(actualAmmount,expectedAmount);
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

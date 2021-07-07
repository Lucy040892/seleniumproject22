package com.cybertek.OfficeHours.Day6;

import com.cybertek.pages.amazonPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.OfficeHoursUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class amazonTestWithPOM {
    //1.	Go to https://www.amazon.com

    @Test
    public void testAmazon(){
        // opening page
        Driver.getDriver().get(ConfigurationReader.getProperty("amazon"));
        BrowserUtils.sleep(1);
        // creating object to reach POM variables and methods
        amazonPage amazon = new amazonPage();

        // get the list of all the tabs

/*
       for (int i = 0; i < amazon.tabs.size(); i++) {
           String Text = amazon.tabs.get(i).getText();
           amazon.Tab(Text).click();
       } */
        // search for hats for men
        amazon.searchBox.sendKeys(ConfigurationReader.getProperty("searchAmazon")+ Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(amazon.firstHat));

        amazon.firstHat.click();
        // get the single price for the hat
        String priceText = amazon.price.getText();
        double singlePriceforHat = OfficeHoursUtils.priceConverter(priceText);

        // Select the quatity as 2
        Select selectQuantity = new Select(amazon.quantityDropDown);
        selectQuantity.selectByVisibleText("2");
        // add to cart
        amazon.addToCart.click();

        // go to cart
        amazon.cart.click();
        // assert that there are 2 items
        Assert.assertTrue(amazon.subTotalText.getText().contains("2 items"));
        // the price from the cart
        double priceForTwo = Double.parseDouble(amazon.subTotalAmount.getText().substring(2));
        // asserting the cart price for 2 items are same as double of single price
        Assert.assertTrue(2*singlePriceforHat==priceForTwo);

        // reduce to 1 irem
        selectQuantity.selectByVisibleText("1");
        BrowserUtils.sleep(2);
        Assert.assertTrue(amazon.subTotalText.getText().contains("1 item"));
        double priceForOne = Double.parseDouble(amazon.subTotalAmount.getText().substring(2));
        Assert.assertTrue(priceForTwo/priceForOne==2);




    }
}
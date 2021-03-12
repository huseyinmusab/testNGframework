package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsClass2 extends TestBase  {
    //Create a class: ActionClass2
    //Create test method : hoverOver() and test the following scenario:
    //Given user is on the https://www.amazon.com/
    //When use click on “Your Account” link
    //Then verify the page title contains “Your Account”
    //Create another method: imageTest()
    //Hover over the Try Prime
    //And Verify the image displays


    @Test
    public void hoverOver() throws InterruptedException {
        //Given user is on the https://www.amazon.com/
        driver.get("https://www.amazon.com/");



        //When use click on “Your Account” link
        //We have to hover over to see "Your Account"
        WebElement hoverOverElement =driver.findElement(By.id("nav-link-accountList"));
        Actions actions =new Actions(driver);
        actions.moveToElement(hoverOverElement).perform();
        Thread.sleep(5000);

        //Then verify the "page title"  contains “Your Account”
        //Locating the element of Your Account
        WebElement account = driver.findElement(By.linkText("Account"));
        account.click();
        Thread.sleep(5000);

        //Verifying your account page title
        String actualPageTitle = driver.getTitle();
        String expectedPageTitle="Your Account";
        Assert.assertEquals(actualPageTitle,expectedPageTitle);
        Thread.sleep(5000);










    }


}

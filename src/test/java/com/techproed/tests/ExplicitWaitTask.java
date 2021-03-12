package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

public class ExplicitWaitTask extends TestBase {
    @Test
    public void explicitWait(){
        //Create a class:ExplicitWaitTest. Create a method: explicitWait
        //Go to https://the-internet.herokuapp.com/dynamic_controls
        //Click on remove button
        //And verify the message is equal to “It's gone!”
        //Then click on Add button
        //And verify the message is equal to “It's back!”

        //CREATE WAIT OBJECT
        WebDriverWait wait =new WebDriverWait(driver,10 );


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click on remove button
        WebElement removeButton = driver.findElement(By.xpath("//button[@type='button']"));
        removeButton.click();

        //And verify the message is equal to “It's gone!”
        //This is where i need to wait
        //What is our expected condition??
        //Expected condition is to wait for the “It's gone!”  element


        WebElement goneMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //WebElement goneMessage =driver.findElement(By.xpath("//p[@id='message']"));====> we dont need this version anymore,because we are doing this with explicit way version, we dont need to use them together, because we already used one top of this with explicit

        String goneMessageText= goneMessage.getText();
        Assert.assertEquals(goneMessageText,"It's gone!");

        //Then click on Add button
        WebElement addButton = driver.findElement(By.xpath("//button[@type='button']"));
        addButton.click();

        //And verify the message is equal to “It's back!”

        WebElement backMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        //WebElement backMessage= driver.findElement(By.xpath("//p[@id='message']"));====> we dont need this version anymore because we already used one top of this with explicit

        String backMessageText = backMessage.getText();
        Assert.assertEquals(backMessageText,"It's back!");















    }


}

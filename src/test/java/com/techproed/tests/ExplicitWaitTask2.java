package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitTask2 extends TestBase {
    //Create a class:ExplicitWaitTest1. Create a method: isEnabled
    //Go to https://the-internet.herokuapp.com/dynamic_controls
    //Click enable Button
    //And verify the message is equal to “It's enabled!”
    //And verify the textbox is enabled (I can type in the box)
    //And click on Disable button
    //And verify the message is equal to “It's disabled!”
    //And verify the textbox is disabled (I cannot type in the box)

    @Test
    public void isEnabled(){
        //Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Click enable Button
        WebElement enableButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();

        //And verify the message is equal to “It's enabled!”
        WebDriverWait wait=new WebDriverWait(driver,10); //CREATE WAIT OBJECT
        WebElement enableMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));//enable message i bekleyerek locate ediyorsun.
        String enableMessageText=enableMessage.getText();

        //WebElement enableMessage =driver.findElement(By.xpath("//p[@id='message']"));

        //And verify the message is equal to “It's enabled!”
        Assert.assertEquals(enableMessageText,"It's enabled!");

        //And verify the textbox is enabled (I can type in the box)
        WebElement inputBox = driver.findElement(By.xpath("//input[@type='text']"));
        inputBox.isEnabled();//isEnabled is used to understand if an element is enabled
        //Hint: isEnabled(); is similar to isDisabled();
        Assert.assertTrue(inputBox.isEnabled());

        //And click on Disable button
        WebElement disableButton = driver.findElement(By.xpath("(//button[@type='button'])[2]"));//once genel olarak inspectden bul sonra kontrol et,uyusmazsa unique degildir.sonra birinci satirda buldugun xpathi () icine al,yanina[2] ekle,gercek located i yapmis oluyorsun boylelikle
        disableButton.click();

        //And verify the message is equal to “It's disabled!”
       WebElement disabledMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
       String disabledMessageText =disabledMessage.getText();

       Assert.assertEquals(disabledMessageText,"It's disabled!");


       //And verify the textbox is disabled (I cannot type in the box)
        WebElement inputBox1 = driver.findElement(By.xpath("//input[@type='text']")); //textbox location doesnt change but we need to name it again for other testing
        Assert.assertTrue(!inputBox1.isEnabled()); // MEANS is not Equal


















    }

}

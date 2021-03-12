package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertTest {
    //Go to https://the-internet.herokuapp.com/javascript_alerts
    //Create setUp method
    //Create 3 test methods:
    //acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfully
    //clicked an alert”

    //dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked:
    //Cancel”

    //sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify
    //“You entered: Hello Word
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    public void acceptAlert() throws InterruptedException {
        //acceptAlert() => click on the first alert, verify the text
        // “I am a JS Alert” , click OK , and Verify “You successfuly

        //Located the first Alert
        WebElement firstButton=driver.findElement(By.xpath("(//button)[1]"));// we used xpath by tag name((//button)[1]),short way,it is a small page already OR we can use===> //button[@onclick='jsAlert()']
        //clicking  on the first alert
        firstButton.click();

        //driver.switchTo().alert().getText()// ===>driveri alerte switch ediyoruz==>how can we get the text in the alert,we have to do this because we cant locate it
        //Getting the text on the Alert
        String firstAlertText =driver.switchTo().alert().getText();//"switch" is the connection between driver and alert,only for alert

        //Verfying if the text equal to "I am a JS Alert"
        Assert.assertEquals(firstAlertText,"I am a JS Alert");
        Thread.sleep(3000);

        //clicking OK by using alert accept() method
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

    }



    @Test
    public void dissmissAlert() throws InterruptedException {
        //dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked:
        //Cancel
        WebElement secondButton = driver.findElement(By.xpath("(//button)[2]"));//shortcut,we got tagname ==>(//button)[2], OR We can use ===>//button[@onclick='jsConfirm()']

        secondButton.click();
        Thread.sleep(3000);

        //I am getting the text on the second alert
        String secondAlertText=driver.switchTo().alert().getText();
        String expectedAlertText ="I am a JS Confirm"; //==> a little bit long way
        //asserting the expected text equals actual text
        Assert.assertEquals(secondAlertText,"I am a JS Confirm");
        Thread.sleep(3000);

        //clicking on the cancel button on the alert
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);

        //asserting the expected result text and actual text equal or not
        WebElement resultElement = driver.findElement(By.xpath("//p[@id='result']"));
        String resultText=resultElement.getText();//===>switch kullanmadik,cunku zaten ui da locate edebiliyoruz kolayca
        String expectedResultText="You clicked: Cancel";
        Assert.assertEquals(resultText,expectedResultText);
        Thread.sleep(3000);

    }




    @Test
    public void sendKeysAlert() throws InterruptedException {
        //sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify
        //“You entered: Hello Word
        WebElement thirdButton = driver.findElement(By.xpath("(//button)[3]")); //OR We can use ===>//button[@onclick='jsPrompt()']
        thirdButton.click();
        Thread.sleep(3000);

        //switching the third alert
        String thirdAlertTextText=driver.switchTo().alert().getText();
        Assert.assertEquals(thirdAlertTextText,"I am a JS prompt");

        driver.switchTo().alert().sendKeys("Hello World");

        //clicking OK button
        driver.switchTo().alert().accept();
        Thread.sleep(3000);

        //Asserting if the actual result and expected result equal
        WebElement resultElement = driver.findElement(By.xpath("//p[@id='result']"));
        String resultText=resultElement.getText();
        Assert.assertEquals(resultText,"You entered: Hello World");
        Thread.sleep(3000);

    }



    @AfterMethod
    public void tearDown(){
        driver.close();

    }

}

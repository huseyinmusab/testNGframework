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
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void hardAssertTest(){
        WebElement gmailLink= driver.findElement(By.linkText("Gmail"));
        //Assert if the gmail link text equals "Gmail"
        String expectedGmailText= "Gmail";
        String actualGmailText = gmailLink.getText();
        Assert.assertEquals(actualGmailText,expectedGmailText);// this passes and continues,if it didnt pass,we wouldnt see what happens at other methods
        //because it is hardasserttest.



        WebElement bilderLink= driver.findElement(By.linkText("Bilder"));
        //Assert if the images link text equals "Images"===> aufDeutsch Bilder
        String expectedbilderLinkText ="Bilder";
        String actualbilderLinkTest =bilderLink.getText();
        Assert.assertEquals(actualbilderLinkTest,expectedbilderLinkText);//this passes


        WebElement anmeldenLink =driver.findElement(By.linkText("Anmelden"));
        //Assert if the Anmelden link text is equal Anmelden
        String expectedAnmeldenLinkText="anmelden";
        String actualAnmeldenLinkText =anmeldenLink.getText();
        Assert.assertEquals(actualAnmeldenLinkText,expectedAnmeldenLinkText);// this fails

    }

    @Test
    public void softAssertTest(){
        WebElement gmailLink= driver.findElement(By.linkText("Gmail"));
        String expectedGmailText= "gmail";
        String actualGmailText = gmailLink.getText();

        SoftAssert softAssert= new SoftAssert();  //we have to create softassert object first to use softassert
        softAssert.assertEquals(actualGmailText,expectedGmailText);//fail




        WebElement bilderLink= driver.findElement(By.linkText("Bilder"));
        String expectedBilderLinkText="Bilder";
        String actualBilderLinkText =bilderLink.getText();
        // SoftAssert softAssert= new SoftAssert();====> to do SoftAssertion we dont need to create another object,i have already created one.we dont need to write it here again
        softAssert.assertEquals(expectedBilderLinkText,actualBilderLinkText);//pass



        WebElement anmeldenLink =driver.findElement(By.linkText("Anmelden"));
        String expectedAnmeldenLinkTest="anmelden";
        String actualAnmeldenLinkTest= anmeldenLink.getText();
        softAssert.assertEquals(expectedAnmeldenLinkTest,actualAnmeldenLinkTest);//fail
        // i want to execute everything if they pass or fail  by using softAssert ==> to see entire picture


        softAssert.assertAll();
        //softAssert.assertAll();==> by this method it makes sense why we are using sofassert,without using this ,this is not correct
        //softassert is useful when you want to have multiple test cases in a single class
        //mostly testers use hardassert

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }


}

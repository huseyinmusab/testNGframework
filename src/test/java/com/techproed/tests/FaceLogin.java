package com.techproed.tests;

import com.techproed.pages.FaceLoginPage;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FaceLogin extends TestBase {

    @Test
    public  void logInTest() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        //these 3 steps were been written by us before (without page object model)
        //driver.findElement(By.id("username")).sendKeys("dolanaaydolanaaaaa");
        //driver.findElement(By.id("password")).sendKeys("1234567890");
        //driver.findElement(By.id("btnSubmit")).click();

        //so,what should we do instead of this 3 things.
        //we need to create FaceLoginPage object

        FaceLoginPage faceLoginPage= new FaceLoginPage(driver); //by typing the driver here,we are combining to the FaceLoginPage class
        faceLoginPage.username.sendKeys("dolanaaydolanaaaaa");
        faceLoginPage.password.sendKeys("1234567890");

        faceLoginPage.login.click();


        String actualErrorMessage=faceLoginPage.errorMessage.getText();
        String expectedErrorMessage="The email or phone number you’ve entered doesn’t match any account. Sign up for an account.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);









    }


}

package com.techproed.smoketest;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTest extends TestBase {
    //Create a package : smoke_test
    //Create a class: NegativeLoginTest
    //When user goes to http://www.kaolapalace-qa-environment2.com/
    //And click on Log in
    //And send the username and password



    //Create a clickLogin Method
    public void clickOnLogin(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainloginButton= driver.findElement(By.linkText("Log in"));
        mainloginButton.click();
        //i created this method,which is not a Test Method,but a normal java method.and i used this 3 times(THEY HAVE SAME FUNCTION,THEY ARE SAME) following the test methods,It is like a SHORTCUT
        //There is also no assertion in this method,assertions are used for test cases,not everywhere
    }


    @Test
    public void invalidPassword(){
        //ACCEPTANCE CRITERIA:
        //When user goes to the application http://www.kaolapalace-qa-environment2.com/
        //And click on the Login button
        //Then verify user is not able to login with incorrect password.




        //driver.get("http://www.kaolapalace-qa-environment2.com/");
        //WebElement mainloginButton= driver.findElement(By.linkText("Log in"));
        //mainloginButton.click();

        clickOnLogin();      //FOR CALLING THE METHOD THAT WE HAVE ALREADY CREATED AT FIRST(1)
        WebElement userName = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));
        userName.sendKeys("manager2");
        password.sendKeys("1234"); // i used fake numbers,because i need a incorrect password

        WebElement loginButton = driver.findElement(By.id("btnSubmit"));
        loginButton.click();
        //Assert.assertFalse(password,"1234","");

        WebElement errorMessage = driver.findElement(By.id("divMessageResult"));
        String errorMessageText = errorMessage.getText();
        System.out.println(errorMessageText);

        //When the username correct,password is incorrect,then i must see wrong password in the error message
        Assert.assertTrue(errorMessageText.contains("Wrong password"));

    }



    @Test
    public void invalidID(){
        //ACCEPTANCE CRITERIA:
        //When user goes to the application http://www.kaolapalace-qa-environment2.com/
        //And click on the Login button
        //Then verify user is not able to login with incorrect ID when password is correct.




        //driver.get("http://www.kaolapalace-qa-environment2.com/");
        //WebElement mainloginButton= driver.findElement(By.linkText("Log in"));
        //mainloginButton.click();


        clickOnLogin();       //FOR CALLING THE METHOD THAT WE HAVE ALREADY CREATED AT FIRST(2)
        WebElement userName = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));
        userName.sendKeys("fakeid");//incorrect username
        password.sendKeys("Man1ager2!");//correct password for the application

        WebElement loginButton = driver.findElement(By.id("btnSubmit"));
        loginButton.click();


        WebElement errorMessage = driver.findElement(By.id("divMessageResult"));
        String errorMessageText = errorMessage.getText();
        System.out.println(errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Username or password is incorrect, please correct them and try again"));



    }



    @Test
    public void invalidIDAndPassword(){
        //ACCEPTANCE CRITERIA:
        //When user goes to the application http://www.kaolapalace-qa-environment2.com/
        //And click on the Login button
        //Then verify user is not able to login with incorrect ID when password is incorrect.




        //driver.get("http://www.kaolapalace-qa-environment2.com/");
        //WebElement mainloginButton= driver.findElement(By.linkText("Log in"));
        //mainloginButton.click();


        clickOnLogin();     //FOR CALLING THE METHOD THAT WE HAVE ALREADY CREATED AT FIRST(3)
        WebElement userName = driver.findElement(By.id("UserName"));
        WebElement password = driver.findElement(By.id("Password"));
        userName.sendKeys("fakeid");//incorrect username
        password.sendKeys("12344455656678");//incorrect password

        WebElement loginButton = driver.findElement(By.id("btnSubmit"));
        loginButton.click();


        WebElement errorMessage = driver.findElement(By.id("divMessageResult"));
        String errorMessageText = errorMessage.getText();
        System.out.println(errorMessageText);
        Assert.assertTrue(errorMessageText.contains("Try again please"));// we choose the sentences




    }


}

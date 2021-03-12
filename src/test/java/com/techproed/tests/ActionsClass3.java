package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass3 extends TestBase {
    //Create a class: ActionClass3
    //Create test method : keysUpDown()
    //Go to google
    //Send iPhone X prices => convert small letter capital vice versa.
    //Highlight the search box by double clicking

    @Test
    public void keysUpDown() throws InterruptedException {

        driver.get("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        actions
                .keyDown(searchBox, Keys.SHIFT)  //Pressing shift on the search box element
                .sendKeys("Send iPhone X prices")//typing in the box
                .keyUp(searchBox,Keys.SHIFT)     //we have to unpress from the shift button
                .perform();                      //performing the action
        //MEANS go to searchbox,press shift key ,then typing "Send iPhone X prices",then move our finger back from SHIFT and perform it by using perform()
        Thread.sleep(5000);


    }
    @Test
    public void keysUpDown1() throws InterruptedException {

        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        actions
                .keyDown(searchBox, Keys.SHIFT)  //Pressing shift on the search box element
                .sendKeys("Send iPhone X prices")//typing in the box
                .keyUp(searchBox,Keys.SHIFT)     //we have to unpress from the shift button
                .sendKeys("android prices")      //typing in the box without SHIFT
                .perform();                      //performing the action
        //MEANS go to searchbox,press shift key ,then typing "Send iPhone X prices",then move our finger back from SHIFT and perform it by using perform()
        Thread.sleep(5000);


    }



}

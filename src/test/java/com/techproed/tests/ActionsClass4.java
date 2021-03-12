package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsClass4 extends TestBase {

    //Create a class: ActionClass4
    //Create test method : scrollUpDown()
    ///Go to amazon
    //Scroll the page down

    @Test
    public void ScrollUpDown() throws InterruptedException {

        ///Go to amazon
        driver.get("https://www.amazon.com/");
        //Scroll the page down
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);

        actions.sendKeys(Keys.ARROW_DOWN).perform(); //This one also moves the page down but it moves less than PAGEDOWN

        //Scroll the page up
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.ARROW_UP).perform();//ARROW_UP will also move the page up but a little bit up.
        Thread.sleep(5000);

        //When do we move the page up or page down in testing?
        //Some pages are long. When we need to take a screenshot of an element that is at the buttom of the page,
        //we have to move the page down.



    }

}

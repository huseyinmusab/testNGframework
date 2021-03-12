package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleExample extends TestBase {
    //Create a new Class Tests package: WindowHandleExample
    //Given user is on the https://the-internet.herokuapp.com/windows
    //Then user verifies the text : “Opening a new window”
    //Then user verifies the title of the page is “The Internet”  ==>SEKME ISMI
    //When user clicks on the “Click Here” button
    //Then user verifies the new window title is “New Window”
    //Then user verifies the text: “New Window”
    //When user goes back to the previous window and then verifies the title : “The Internet”

    @Test
    public void newWindowTest(){

        //Given user is on the https://the-internet.herokuapp.com/windows

        driver.get("https://the-internet.herokuapp.com/windows");

        //Then user verifies the text : “Opening a new window”
        String newWindowText =  driver.findElement(By.xpath("//div[@class='example']//h3")).getText();//shortcut asalways,direct to put in a String AND SHORTCUT Webelement is "//h3" ,  "//div[@class='example']//h3"==>kind a absoloute xpath
        String expectednewWindowText ="Opening a new window";
        Assert.assertEquals(newWindowText,expectednewWindowText);



        //Then user verifies the title of the page is “The Internet”
        String expectedTitle ="The Internet";
        String actualTitle  = driver.getTitle();
        //Check if the expectedTitle  and actualTitle.If they are not equal then print title is incorrect
        Assert.assertEquals(actualTitle,expectedTitle,"Title is incorrect");


        //WE ARE GETTING THE FIRST WINDOW HANDLE SO WHEN WE NEED TO SWITCH BACK TO THIS WINDOW WE CAN DO IT
        String window1 =driver.getWindowHandle(); //this gives us current window(HANDLE OF FIRST PAGE) whichever we are on==>(BU TEKIL ASAGIDAKI SET METHOD COGUL)
        System.out.println("Default Window Handle:"+window1); //default window=window1



        //When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click(); //we located and we clicked



        //Then user verifies the new window title is “New Window”
        //THE NEW WINDOW OPENS IN A NEW TAB,THIS MEANS WE HAVE TO SWITCH TO THE NEW WINDOW!!!
        //WE WILL GET ALL OPEN WINDOW HANDLES AND PUT THEM IN A SET.

        Set<String>allWindows= driver.getWindowHandles(); //INTERVIEW QUESTION:) set gives me all of the opened windows,this is power of SET
        //Using for each loop, we can switch to the new window
        //window1=default window
        for(String eachWindow:allWindows){
            if (!eachWindow.equals(window1)){
                driver.switchTo().window(eachWindow);//MEANS=>when you are not in window 1 among the all windows,then switch to window2
            }
        }
        //this works for 2 windows ,usually we test 2 windows,if there are more than 3 ,then we need one if else statement too



        //Then user verifies the text: “New Window”
        String actualSecondWindowText = driver.findElement(By.xpath("//h3")).getText();
        String expectedSecondWindowText ="New Window";
        Assert.assertEquals(actualSecondWindowText,expectedSecondWindowText,"New window text is not matching");



        //When user goes back to the previous window and then verifies the title : “The Internet”
        driver.switchTo().window(window1);
        Assert.assertEquals(driver.getTitle(),"Internet"); //SHORTCUT ASSERTION






















    }






}

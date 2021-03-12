package com.techproed.tests;

import com.techproed.utilities.TestBase;
import okhttp3.internal.cache.DiskLruCache;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase {
    @Test
    public void iframeTest() throws InterruptedException {
        //Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Verify the Bolded text contains “Editor”
        //Note that this Bolded Text is Not inside the iframe,so we do regular  testing/which is we dont switch to iframe
        WebElement boldedText= driver.findElement(By.xpath("//h3"));  //we can also use ==> "//div[@class='example']//h3" ,or just "h3"
        //Getting the text of the element
        String boldedTextText= boldedText.getText();
        //Making the assertion
        Assert.assertTrue(boldedTextText.contains("Editor"));   //======>>> contains method

        //Locate the text box

        //WE HAVE TO SWITCH TO IFRAME FIRST,BECAUSE THE TEXTBOX IS IN THE IFRAME
        //METHOD 1: Switching the iframe by index
        //1)==>driver.switchTo().frame(0); //WITHOUT LOCATE  it is the first iframe =indexof(0)

        //METHOD 2 :Switch to iframe by ID value
        //driver.switchTo().frame("mce_0_ifr");//WITHOUT LOCATE  =>we just need to put "ID VALUE"===>(("id="mce_0_ifr")) to switch to that iframe,little bit slower than index

        //METHOD 3: Switching to iframe by webelement ===>WITH LOCATE BEFORE==> as you see it is longer because you have to locate iframe element here
        //1 VE 2. METHOD ARE FASTER THAN 3.METHOD
        WebElement iframeElement= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")); //===>iframe yazan html den bulabilirsin locate etmek icin,direcy ui uzerinden bakinca zor oluyor bulmasi
        driver.switchTo().frame(iframeElement);

        Thread.sleep(3000);


        WebElement textBoxElement=driver.findElement(By.xpath("//p")); //there were 2 html code like (parent-child),first is for all page,second one is for text box,it is like page in page

        //Delete the text in the text box.Use clear() method to clear the input
        textBoxElement.clear();

        //Type “This text box is inside the iframe”
        Thread.sleep(3000);
        textBoxElement.sendKeys("This text box is inside the iframe"); //it didnt pass without the the switching to iframe,selenium cant find ""//p""==>no such element: Unable to locate element: {"method":"xpath","selector":"//p"}
        Thread.sleep(3000);




        //Verify the text Elemental Selenium text is displayed on the page

        //Elemental Selenium is OUTSIDE of the iframe.But currently our driver is inside the frame
        // so we need need to get out of the iframe:

        // driver.switchTo().parentFrame();
        //OR
        // driver.switchTo().defaultContent();

        driver.switchTo().defaultContent();
       String elementText= driver.findElement(By.linkText("Elemental Selenium")).getText();//SHORT WAY OF Webelement.webelementi sildik yerine String yazip,element i elementText e cevirdik ve sonuna getText() ekledik
       Assert.assertTrue(elementText.equals("Elemental Selenium"));


    }
}

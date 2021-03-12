package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFileText extends TestBase {

    @Test
    public void uploadFileMethod() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //locate the element of choosefile
        WebElement chooseFile = driver.findElement(By.id("file-upload"));
        //We need to send the path of the image
        //Each of your path will be different
        //Find your own path
        //Windows Example:
        //C:\Users\Salak\Masaüstü
        String pathOfTheFile ="C:/Users/Salak/OneDrive/Masaüstü/FLOWER.jpg";
        //We will send this pathOfTheFile to the chooseFile button
        chooseFile.sendKeys(pathOfTheFile);
        Thread.sleep(5000);

        //click on upload button
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(5000);

        WebElement fileUploadedText = driver.findElement(By.xpath("//h3"));
        String actualText =fileUploadedText.getText();
        String expectedText ="File Uploaded!";
        Assert.assertEquals(actualText,expectedText);
        Thread.sleep(5000);








    }
}

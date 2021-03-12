package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownload extends TestBase {
    //Create a class:FileDownload
    //downloadTest()
    //In the downloadTest() method, do the following test:
    //Go to https://the-internet.herokuapp.com/download
    //Download FLOWER.JPG file=======>>>>adhar.jpeg (calistigim zamanda linkte cikan seceneklerden biri,stabil degil o yuzden flower yerine adhar kullandim
    //Then verify if the file downloaded successfully

    @Test
    public void downloadTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/download");
        WebElement adhar = driver.findElement(By.linkText("adhar.jpeg"));
        adhar.click();
        //Path of the file
        //We must put some wait for the download to complete,If we dont use this it will fail,synchranization issiue
        Thread.sleep(5000);

        //We can find user folder by using System.getProperty();
        String userFolder = System.getProperty("user.home");//MEANS user.home--->Users/Salak,Another way to get the path===>user-->Users,  home--->Salak,
        System.out.println(userFolder);
        String pathOfTheFile =userFolder+"/Downloads/adhar.jpeg"; //INSTEAD OF NORMAL PATH WE USE THIS PATH,IT IS MORE DYNAMIC,SO WE CAN USE IT ON  EVERY COMPUTER
        //NORMAL PATH =C:/Users/Salak/Downloads/adhar.jpeg


        //boolean isDownloaded = File.exists.(Path.get(file path));
          boolean isDownloaded = Files.exists(Paths.get(pathOfTheFile));


        //Use assertion to check if boolean true or flase
        Assert.assertTrue(isDownloaded);






    }
}

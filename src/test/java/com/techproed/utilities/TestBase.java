package com.techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    //TestBase will have only @BeforeMethod and @After Method
    //This class will not have any Test Class!!! (because abstract)
    //create the driver in the class level
    //Webdriver object MUST be protected OR public so we can access to this object in different PACKAGE.Not default access modifier we need(java rule)

    protected WebDriver driver; //we cant create testbase object but create Webdriver.because Webdriver Object is not abstract

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void tearDown(){

        //driver.quit();
    }

}

package com.techproed.utilities;

    //driver and TestBase are so similar,but design is different
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

//WE NEED DRIVER CAUSE WE WANT TO HAVE SINGLE driver INSTANCE
//We are making singleton design pattern. (btw some companies have driver class some not)

public class Driver {

    private Driver(){
        //This is a constructor and we made it private,we dont wanna make object/instance thats why we this created,without this it is working too,but we wanna make this class better
    }


    //Create the static driver
    private  static WebDriver driver; //same logic with Configread class.we must use "static",because we want to use this(same) "driver" across the framework,which means it can be used globally
                                      //and private is to call this instance only in this class
    //create a public static method to instantiate the driver (somutlastirmak)

    public static WebDriver getDriver(){ //bu kisimda getDriver methodu directly cagirabiliyoruz,driveri degil,driver static cunku

        if (driver==null){    //if (driver==null)==> this part is the difference TestBase and Driver.That part is saying;
                              //I want to instantiate the driver instance if driver is not pointing anywhere.
                              //if the driver is already pointing somewhere(being used),then we dont need second one
                              //we want to have only one driver


            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

                case "firefox":
                    WebDriverManager.chromedriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "ie":
                    WebDriverManager.chromedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
            }


        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
        //this will return driver object every single time

    }

    public static void closeDriver(){
        //Close driver if it is not null
        //it means driver is pointing chrome(is being used)
        if(driver!=null){
            driver.quit();
            //similar to tearDown Method
            driver=null;  // to be safe the driver turns to "null"

            //Driver.getDriver ();====> driver is being instantiated.This means driver is no longer null
            //Driver.closeDriver():===> river will be closed,however it is still pointing the chrome.
            //To be safe and not to get an exception ,we set driver to null. driver=null;
            //this is a kind of cycle of singleton driver,.l


        }

    }







}

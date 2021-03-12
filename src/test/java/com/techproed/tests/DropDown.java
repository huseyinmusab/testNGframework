package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
         //Create a class name : DropDown
         //Go to https://the-internet.herokuapp.com/dropdown
         //1.Select and Print Option 1 using index
         //2.Select and Print Option 2 by using value
         //3.Select and Print default value by visible text
         //4.Print all dropdown values
         //5.Find the size of the dropdown, Print true if there are 4 elements in the dropdown. Print false otherwise.

    WebDriver driver;

        // we used this instance element to use for every Test,it helps us to not write again and again
        //Create a class name : DropDown
        //Go to https://the-internet.herokuapp.com/dropdown

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void dropdownTest() throws InterruptedException {
        //1.Locate the dropdown
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

        //2.create Select Object
        Select options = new Select(dropdownElement);
        Thread.sleep(10000);

        //1.Select and Print "Option 1" using index
        //3.Select Step 3  select the option byindex,or byvalue,or byvisibletext

        options.selectByIndex(1); // 0,1,2==> 0 IS SELECTED ONE AND THATS WHY WE USE (1) for option 1

    }


    @Test
    public void selectByValue() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown")); //bu 2 satir ilk testteki ile ayni
        Select options =new Select(dropdownElement);                        //bu 2 satir ilk testteki ile ayni
        Thread.sleep(10000);
        // 2.Select and print Option 2 by value==> at first test we can by using index,here by using value
        options.selectByValue("2");            // "2"  String type,"" String cinsinden yazilir

    }



        //3.Select and  Print Option 1 by visible text
    @Test
    public void selectByVisibleTest() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown")); //bu 2 satir ilk testteki ile ayni
        Select options =new Select(dropdownElement);                        //bu 2 satir ilk testteki ile ayni
        Thread.sleep(10000);
        options.selectByVisibleText("Option 1"); //sometimes text and html code are not suitable with each other, big O,small o etc.that is
                                                 //that is why we need to copy "Option 1" from html,not from UI
    }
        //seperate test cases yaptiki istersek tek test casede de yapabilirdik ama ayri ayri daha iyi,daha duzenli





        //4.Print all dropdown values
    @Test
    public void printAllValues() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options =new Select(dropdownElement);
        Thread.sleep(10000);

        List<WebElement> allOption = options.getOptions(); // this gives all off the dropdown options
        for (WebElement option:allOption){
            System.out.println(option.getText());
        }
        // or for loop we can use==>>> for (int i=0; i<allOption.size(); i++){ }

    }




    //5.Find the size of the dropdown, Print true if there are 4 elements in the dropdown. Print false otherwise
    @Test
    public void dropdownSizeTest() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options =new Select(dropdownElement);
        Thread.sleep(10000);

        int actualSizeOfDropdown =options.getOptions().size();  //size means how many element in dropdown
        Assert.assertEquals(actualSizeOfDropdown,4,"EXPECTED IS NOT EQUAL TO ACTUAL");
        //We can give the messages by opening String ("") after 4 by putting (,)==>"EXPECTED IS NOT EQUAL TO ACTUAL"
        //Actually there are 3 elements but we checked if there are 4 or not,that is why it has failed

    }



    @Test
    public void getFirstSelectedOptionTest() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select options =new Select(dropdownElement);
        Thread.sleep(10000);
        String firstSelectedOption= options.getFirstSelectedOption().getText();
        // options.getFirstSelectedOption()=>>this is default selected value,instead of this we can use index of 0 but it is not professional
        System.out.println("First Selected Option =>"+firstSelectedOption);

    }



    @AfterMethod
    public void tearDown() {
        driver.close();}

        //sondaki @AfterMethod u iptal edince options larrin secildigini gorebiliyorsun
        //interview da dropdown nasil kullanilir ve olusturulur seklinde sorular cok geliyor





}


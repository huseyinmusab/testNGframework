package com.techproed.tests;

import com.techproed.smoketest.PositiveTest;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelRoomTest extends TestBase {


    //Create a clickLogin Method
    public void clickOnLogin(){
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainloginButton= driver.findElement(By.linkText("Log in"));
        mainloginButton.click();
    }




    @Test
    public void createHotelRoom() throws InterruptedException {
        clickOnLogin();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();

        //click on Hotel Management
        //click on Hotel Rooms
        //click on AddHotel Room
        //Enter all required fields
        //click save


        //click on Hotel Management
        WebElement hotelManagement = driver.findElement(By.xpath("(//span[@class='title'])[3]"));
        hotelManagement.click();

        //click on Hotel Rooms
        WebElement hotelRooms = driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();

        //click on AddHotel Room
        Thread.sleep(5000);
        WebElement addHotelRoomButton= driver.findElement(By.xpath("//span[@class='hidden-480']"));
        addHotelRoomButton.click();


        //Enter all required fields
        WebElement idHotelDropDown =driver.findElement(By.id("IDHotel"));
        Select select = new Select(idHotelDropDown); //CREATING DROPDOWN OBJECT ***IMPORTANT
        select.selectByIndex(1);

        WebElement code = driver.findElement(By.id("Code"));
        code.sendKeys("12345");

        WebElement name = driver.findElement(By.id("Name"));
        name.sendKeys("Best Hotel");

        WebElement location = driver.findElement(By.id("Location"));
        location.sendKeys("Houston");

        WebElement description = driver.findElement(By.xpath("//textarea[@dir='ltr']"));
        description.sendKeys("This is a Royal Class Hotel");

        //To enter a price ,we can send keys,OR we can use actions class to drag and drop
        //we can use 2. way

        WebElement source= driver.findElement(By.xpath("//li[@data-id='700']")); // DRAG UND DROP  ****IMPORTANT
        WebElement target = driver.findElement(By.id("Price"));   // DRAG UND DROP  ****IMPORTANT
        Actions actions= new Actions(driver);                    //CREATE ACTION OBJECT TO TAKE THE CONRTOL OF DRAG AND DROP
        actions.dragAndDrop(source,target).perform();            //not forget perform

        WebElement roomTypeDropDown = driver.findElement(By.id("IDGroupRoomType"));
        Select select1 = new Select(roomTypeDropDown);          //DROPDOWN object again .
        select1.selectByVisibleText("Studio");                  //but this time with selectByVisibleText( dropdown icin 3 opsiyondan bir tanesi)

        WebElement maxAdultCount = driver.findElement(By.id("MaxAdultCount"));
        maxAdultCount.sendKeys("5");

        WebElement maxChildrenCount = driver.findElement(By.id("MaxChildCount"));
        maxChildrenCount.sendKeys("6");

        WebElement approvedCheckBox = driver.findElement(By.id("IsAvailable"));
        approvedCheckBox.click();

        //click save
        Thread.sleep(5000);
        WebElement saveButton = driver.findElement(By.id("btnSubmit"));
        saveButton.click();


        //Thread.sleep(5000);===>instead of thread.sleep we use EXPLICIT WAIT.  HATA VERDI TEKRAR KONTROL ET!!!
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
        //WebElement successMessage =driver.findElement(By.xpath("//div[@class='bootbox-body']"));

        //Verify the message: HotelRoom was inserted successfully
        String successMessageText = successMessage.getText();
        Assert.assertEquals(successMessageText,"HotelRoom was inserted successfully");

        //***Success message is not an alert that we learnt before because we can locate it now,this is an element


        //click OK
        WebElement okButton = driver.findElement(By.xpath("(//button[@type='button'])[6]"));
        okButton.click();

        //HOMEWORK1
        //Now click on Hotel Rooms

        //Then verify the hotelID=STAR on that page

        //HOMEWORK2
        //As user i should be able to create a room reservation
        //As tester ,you decide your test
        //Use same manager id and password
















    }

}

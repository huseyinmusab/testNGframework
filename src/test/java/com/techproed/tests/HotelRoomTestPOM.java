package com.techproed.tests;

import com.techproed.pages.HotelRoomsPage;
import com.techproed.pages.KaolaDefaultPage;
import com.techproed.pages.KaolaLoginPage;
import com.techproed.pages.KaolaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class HotelRoomTestPOM extends TestBase {

    public void kaolaLogin(){
        //driver.get("https://www.kaolapalace-qa-environment2.com/");
        driver.get(ConfigReader.getProperty("kaola_url"));

        KaolaMainPage kaolaMainPage= new KaolaMainPage(driver); // ilk karsimiza cikan sayfa
        kaolaMainPage.kaolaMainLoginButton.click();


        KaolaLoginPage kaolaLoginPage=new KaolaLoginPage(driver); //bu sefer ikinci sayfaya gectik,yani log in sayfasina
        //kaolaLoginPage.kaolaUserName.sendKeys("manager2");
        kaolaLoginPage.kaolaUserName.sendKeys(ConfigReader.getProperty("username"));


        //kaolaLoginPage.kaolaPass.sendKeys("Man1ager2!");
        kaolaLoginPage.kaolaPass.sendKeys(ConfigReader.getProperty("password"));


        kaolaLoginPage.kaolaLoginButton.click();

    }

    @Test
    public void hotelRoomTest() throws InterruptedException {
        kaolaLogin();
        KaolaDefaultPage kaolaDefaultPage= new KaolaDefaultPage(driver);
        kaolaDefaultPage.hotelManagement.click();
        kaolaDefaultPage.hotelRooms.click();
        Thread.sleep(5000);

        HotelRoomsPage hotelRoomsPage=new HotelRoomsPage(driver);
        hotelRoomsPage.addhotelManagement.click();

        //REST IS HOMEWORK






    }


}

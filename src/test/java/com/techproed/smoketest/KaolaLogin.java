package com.techproed.smoketest;

import com.techproed.pages.KaolaLoginPage;
import com.techproed.pages.KaolaMainPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class KaolaLogin extends TestBase {

    @Test
    public void kaolaLogin() throws InterruptedException {
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
        Thread.sleep(10000);





    }
}

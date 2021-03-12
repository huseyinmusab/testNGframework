package com.techproed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FaceLoginPage {
    WebDriver driver;
    //without this we get nullPointerException
    //create the constructor to initialize the driver.this constructor will run before anything else to call the element before everything else
    public  FaceLoginPage(WebDriver driver){
        this.driver=driver;
        //initElements method initialized the driver in page object
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="email")
    public WebElement username;

    @FindBy(id="pass")
    public WebElement password;

    @FindBy(xpath="//button[@id='u_0_b']")
    public WebElement login;


    //create the errorMessage element
    //call it in the assertion in test class
    //REFACTOR
    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement errorMessage;




}

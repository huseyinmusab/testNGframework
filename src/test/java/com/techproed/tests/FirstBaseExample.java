package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;

public class FirstBaseExample extends TestBase {
    //create a test class
    //This test class will call the setUp and tearDown methods in the TestBase
    //Because we extended the TestBase class

    @Test
    public void test1(){
        driver.get("https://www.google.com/");
    }


}

package com.techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethods {


    @Test
    public void login() {
        System.out.println("Log in TEST");
    }

    @Test
    public void homePage() {
        System.out.println("Home Page Test");//by texting this we make fail delibaretly to aim a purpose
        Assert.assertTrue(false);   ////homepage test has a fail , thats why searchTest is ignored
    }
}
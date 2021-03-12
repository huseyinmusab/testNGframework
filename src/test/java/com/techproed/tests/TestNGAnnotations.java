package com.techproed.tests;



import org.testng.annotations.*;

public class TestNGAnnotations {
    //1.create a method : setUp using @BeforeMethod
    //annotation and print "This is BeforeMethod"

   @BeforeMethod //@Before method will run before each @Test
   public void setUp(){
      System.out.println("This is Before method");
   }


    //2.Create a method :tearDown using @AfterMethod
    //annotation and print "This is @AfterMethod"

   @AfterMethod // This will run after each @Test
   public void tearDown(){
      System.out.println("This is @AfterMethod");

   }
    //3.Create 4 TEST METHODS : test1 test2,test3,test4, and print "Test1","Test2","Test3,"Test4"\

   @Test(priority = 3)   //IMPORTANT: priority annotation gives priority by the ranking.but when we dont use priority,that test that we dont use priority runs first than others.when we use priority we should give it to all testes,otherwise it makes a puzzle
   public void test1(){
      System.out.println("Test1");
   }

   @Ignore// This is used to ignore for this case.if we dont have ignore @beforemethod would run 4 times,but now 3 times
   @Test
   public void test2() {
      System.out.println("Test2");
   }

   @Test(priority = 1)
   public void test3() {
      System.out.println("Test3");
   }

   @Test(priority = 2)
   public void test4(){
      System.out.println("Test4");
   }

    //4.Skip test2
      //Done


    //5.print the test in this order : Test3,Test4,Test1
   //DONE




}

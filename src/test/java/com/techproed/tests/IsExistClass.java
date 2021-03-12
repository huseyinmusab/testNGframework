package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths; //Set language level to 7 

// we dont need to extend to Testbase because we dont use anything from selenium things and driver
public class IsExistClass  {

    @Test
    public  void IsExist(){
        //Check if the Flower image is existing on your desktop

        //Find the path of the image
        String pathOfTheFile ="C:/Users/Salak/OneDrive/Masaüstü/FLOWER.jpg";



        //We will use JAVA to check if a file exist or not. ******
        boolean isExist=Files.exists(Paths.get(pathOfTheFile));


        //Assert if the path exist
        Assert.assertTrue(isExist);




    }
}

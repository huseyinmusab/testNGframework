 package com.techproed.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    //This class will READ THE DATA FROM configuration.properties file!!!

    //create a properties instance.Data type= Properties, instance name=properties
    private static Properties properties;


    static {//we must put the all things to static class,we are trying reach private static properties, it is mandatory

        //path of the configuration.properties file
        String path = "configuration.properties";

        //FileInputStream ===> this will help us to deal with the files
        //FileInputStream fileInputStream = new FileInputStream(path);===> normally this one we were going to make ,but for the exception we surounded it by try catch


            try {
                //Opening the configuration.properties file
                FileInputStream fileInputStream = new FileInputStream(path);
                //Loading and reading the file
                properties = new Properties();
                properties.load(fileInputStream);
                //Closing the file
                fileInputStream.close();


            } catch (Exception e) {     // we had 2 exceptions one from FileInputStream,one from "load",we minimized the 2 exceptions to 1 exception
                e.printStackTrace();
            }
        }


     //create a method to READ
     //This method will get the KEY and return the VALUE

    public static String getProperty(String key){
        return  properties.getProperty(key);
        //means when we will give "key" as String,it turns "value"
    }

    //TESTING IF OUR LOGIC WORKS
    //public static void main(String[] args) {
    //  System.out.println(properties.getProperty("browser"));
    //}
    // we dont need this main method,we just made it to check
    // you dont need to know how to build this very well,but you must know how to handle and how it works.in reality you create once,and use it over and over,you dont need to look back again










    }


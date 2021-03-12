package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables extends TestBase {
    //Create a method: login()
    //Log in http://www.kaolapalace-qa-environment2.com/
    //Click on Hotel Management
    //Click on Hotel Rooms


    //PRE CONDITION.THIS IS NOT A TEST CASE
    public void login() {
        //Log in http://www.kaolapalace-qa-environment2.com/
        driver.get("http://www.kaolapalace-qa-environment2.com/");
        WebElement mainloginButton = driver.findElement(By.linkText("Log in"));
        mainloginButton.click();
        driver.findElement(By.id("UserName")).sendKeys("manager2");
        driver.findElement(By.id("Password")).sendKeys("Man1ager2!");
        driver.findElement(By.id("btnSubmit")).click();

        //Click on Hotel Management
        WebElement hotelManagement = driver.findElement(By.xpath("(//span[@class='title'])[3]"));
        hotelManagement.click();

        //Click on Hotel Rooms
        WebElement hotelRooms = driver.findElement(By.partialLinkText("Hotel Rooms"));
        hotelRooms.click();
    }


        //Create a test method: entireTable() and Find the size of the entire table body and print all of headers
        //Create a test method: printRows() and Print all of the rows and print the element s on the 4th row
        //Create a test method: printCells() and Find the total number of cells in the table body and print all of the cells
        //Create a test method: printColumns() and print Find the total number of columns and Print the elements of the
        //5th column
        //Create a test method: printData(int row, int column); This method should print the given cell. Example:
        //printData(2,3); should print 2nd row,3rd column


    @Test
    public void  entireTable() throws InterruptedException {
        login();
        //Create a test method: entireTable() and

        //Print the entire table body
        Thread.sleep(5000);
        WebElement tBody = driver.findElement(By.xpath("//tbody")); //xpath yerine bazen tagName("tbody") de kullanabiliriz.
                                                                    //we can identfy table body by using tagName
        System.out.println(tBody.getText());   //short way the entire table data (total)

        //Find the size of the entire table body
        List<WebElement>tableData=driver.findElements(By.xpath("//td"));
        System.out.println("There are"+tableData.size()+"data.");

        //Another way  to print the entire data this is better,gives us individual (one by one ) data

        //for (WebElement eachData:tableData){
        //    System.out.println(eachData.getText());
        //}
        //What is the difference foer each and tBody.getText()
        //Answer: in for each, I get each data one by one and print them one by one
        //tBody gives me one SINGLE element that has ALL OF THE DATA AS A WHOLE

        // and print all of headers
        List<WebElement> allHeaders= driver.findElements(By.xpath("//th"));
        for (WebElement eachHeader:allHeaders){
            System.out.println(eachHeader.getText());
        }



    }

    //Create a test method: printRows() and Print all of the rows in the TABLE BODY and print the element s on the 4th row

       @Test
        public void printRows(){
        login();
        List<WebElement> allRows=driver.findElements(By.xpath("//tbody//tr"));
        for (WebElement eachRow:allRows){
            System.out.println(eachRow.getText());
        }

        //print the element s on the 4th row
        WebElement forthRow = driver.findElement(By.xpath("//tbody//tr[4]"));
        System.out.println(forthRow.getText());

        }


        //Create a test method: printCells()
        @Test
        public void printCells(){
        login();
        //Find the total number of cells in the table body and print all of the cells


        List<WebElement>allCells=driver.findElements(By.xpath("//tbody//td"));
        System.out.println(allCells.size());  //==>how many cells are there           ==> java
        for (WebElement eachCell:allCells){   //==>prints all of the cells one by one  --> java
            System.out.println(eachCell.getText());
        }

        }

        //Create a test method: printColumns() and print Find the total number of columns and Print the elements of the 5th column
        @Test
        public  void printColumns() throws InterruptedException {
        login();

        //print Find the total number of columns
        List<WebElement>allCoulms= driver.findElements(By.tagName("th")); //xpath yerine tagName kullandik, "th" icin de farkli kullamimlar var biz th i sectik for example==. //thead//th, or
        System.out.println(allCoulms.size());

        //Print the elements of the 5th column
            Thread.sleep(5000);
            //Location
            //Orlando
            //Miami
            //Eindhoven

            List<WebElement>fifthColumn =driver.findElements(By.xpath("//tr  //td[5]"));

            for (WebElement eachElement:fifthColumn){
                System.out.println(eachElement.getText());
            }

         }





         //printData(3,6); ==>print the data in row 3 column 6
         //Create a test method: printData(int row,int column);
         //This method should print  the given cell. Example: printData(2,3);
         //should print 2nd row,3rd coulmn

    //This custom method will take a row and a column number
    //and print the data on that row  and column
    //Thud will not be a test method but a custom method

    public void printData(int row,int column){

        //String xPath = "//tbody//tr[9]//td[5]"; //Nj  ==> hard coding
        //String xPath2 = "//tbody//tr[2]//td[3]"; //12746376 ==> hard coding
        //Only the index numbers keep changing in the webtable xpath
        String xPath = "//tbody//tr["+row+"]//td["+column+"]";
        WebElement data= driver.findElement(By.xpath(xPath));  //just one xpath i want
        System.out.println(data.getText()); //if i dont use getText() it just gives me reference number

    }

    @Test
    public void printDataTest(){
        login();
        printData(2,3);
        printData(5,4);

    }





}

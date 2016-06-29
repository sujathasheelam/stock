package com.stockAccounting.Examples;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.stockAccounting.Master.StockMaster;

public class Purchases_test {
	WebDriver driver;
	 WebElement datePicker;
	 List<WebElement> noOfColumns;
	 List<String> monthList = Arrays.asList("January ", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
	// Expected Date, Month and Year
	 int expMonthYear;
	 int expYear;
	 String expDate = null;
	 // Calendar Month and Year
	 String calMonthYear = null;
	 String calYear = null;
	 boolean dateNotFound;

	 @BeforeTest
	public void purchase() throws IOException, InterruptedException
	{
		StockMaster m = new StockMaster();
		
		m.stockAccount_Launch(m.URL);
		m.stockAccount_Login(m.uname, m.pword);
		Thread.sleep(5000);
	}
	
	@Test
	public void purchaseCreation() throws InterruptedException
	{

		StockMaster m = new StockMaster();
		m.driver.findElement(By.xpath(".//*[@id='mi_a_purchases']/a")).click();
		Thread.sleep(5000);
		
	m.driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		Thread.sleep(5000);
		
		m.driver.findElement(By.id("x_Purchase_Date")).clear();
		  m.driver.findElement(By.xpath(".//*[@id='el_a_purchases_Purchase_Date']/div/span/button")).click();
		  dateNotFound = true;
		  
		  //Set your expected date, month and year.  
		  expDate = "18";
		  expMonthYear = 5;
		 
		  
		  //This loop will be executed continuously till dateNotFound Is true.
		  while(dateNotFound)
		  { 
		   //Retrieve current selected month name from date picker popup.
		   calMonthYear = driver.findElement(By.xpath("html/body/div[16]/table/thead/tr[1]/td[2]")).getText();
		  
		   
		   
		   //If current selected month and year are same as expected month and year then go Inside this condition.
		   if(monthList.indexOf(calMonthYear)+1 == expMonthYear)
		   {
		    //Call selectDate function with date to select and set dateNotFound flag to false.
		    selectDate(expDate);
		    dateNotFound = false;
		   }
		   //If current selected month and year are less than expected month and year then go Inside this condition.
		   else if(monthList.indexOf(calMonthYear)+1 < expMonthYear)
		   {
		    //Click on next button of date picker.
		    driver.findElement(By.xpath("html/body/div[17]/table/thead/tr[2]/td[4]/div")).click();
		   }
		   //If current selected month and year are greater than expected month and year then go Inside this condition.
		   else if(monthList.indexOf(calMonthYear)+1 > expMonthYear)
		   {
		    //Click on previous button of date picker.
		    driver.findElement(By.xpath("html/body/div[17]/table/thead/tr[2]/td[2]/div")).click();
		   }
		  }
		  Thread.sleep(3000);
		 } 
		 
		 public void selectDate(String date)
		 {
		  datePicker = driver.findElement(By.className("calendar")); 
		  noOfColumns=datePicker.findElements(By.tagName("td"));

		  //Loop will rotate till expected date not found.
		  for (WebElement cell: noOfColumns){
		   //Select the date from date picker when condition match.
		   if (cell.getText().equals(date)){
		    cell.findElement(By.linkText(date)).click();
		    break;
		   }
		  }
		
		
	}

}

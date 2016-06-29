package com.stockAccounting.Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

public class Supplier {

	public static void main(String[] args) throws Exception {
		// String expVal,actVal;
		// expVal = "Add succeeded";
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\Users\\sujatha\\Downloads\\chromedriver.exe");
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile myprofile = profile.getProfile("StockAcc");
		WebDriver driver = new FirefoxDriver(myprofile);
		driver.get("http://webapp.qedgetech.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='username']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("master");
		driver.findElement(By.id("btnsubmit")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='mi_a_suppliers']/a")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a"))
				.click();
		Thread.sleep(5000);
		driver.findElement(By.id("x_Supplier_Name")).sendKeys("qedgetech");
		driver.findElement(By.id("x_Address")).sendKeys("ameerpet");
		driver.findElement(By.id("x_City")).sendKeys("Hyderabad");
		driver.findElement(By.id("x_Country")).sendKeys("India");
		driver.findElement(By.id("x_Contact_Person")).sendKeys("xyz");
		driver.findElement(By.id("x_Phone_Number")).sendKeys("1111111111");
		driver.findElement(By.id("x__Email")).sendKeys("xyz@gmail.com");
		driver.findElement(By.id("x_Mobile_Number")).sendKeys("2222222222");
		driver.findElement(By.id("x_Notes")).sendKeys("provides trainings");
		WebElement b = driver.findElement(By.cssSelector("#btnAction"));
		Actions act = new Actions(driver);
		act.moveToElement(b).build().perform();
		act.doubleClick().build().perform();
		driver.findElement(By.id("")).click();
		Thread.sleep(5000);
		// actVal =
		// driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
		// System.out.println(actVal);
		/*WebElement a = driver.findElement(By
				.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]"));
		Actions act1 = new Actions(driver);
		act1.moveToElement(a).build().perform();
		act1.doubleClick().build().perform();*/
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button"))
				.click();
		Thread.sleep(5000);
		WebElement table = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[3]/form/div/div[2]/table/tbody"));  
	      String sRowValue="Supplier-00000000146"; 
	 List<WebElement> rows = table.findElements(By.tagName("tr"));  
	     for (int r = 0; r < rows.size(); r++)
	     {  
	       String sValue=null;
	       sValue=driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[3]/form/div/div[2]/table/tbody/tr[r]")).getText();
	       if(sValue.equalsIgnoreCase(sRowValue))
	       {
	       List<WebElement> columns = rows.get(r).findElements(By.tagName("td"));  
	       for (int col = 0; col < columns.size(); col++) 
	       { 
	    	   
	       }  
	       }  

	}
}
}
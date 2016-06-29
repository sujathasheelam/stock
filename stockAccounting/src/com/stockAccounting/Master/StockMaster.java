package com.stockAccounting.Master;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

public class StockMaster {
	public static String URL = "http://webapp.qedgetech.com";
	public static String uname = "admin";
	public static String pword = "master";
	public static String expVal, actVal;
	public static WebDriver driver;
	public static Properties pr;
	public static FileInputStream fi;
	public static String prop = "C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\properties\\StockAccPr.properties";

	
	
	public String stockAccount_Launch(String URL) throws IOException
	{
		 pr = new Properties();
			
		 fi = new FileInputStream(prop);
		
		 pr.load(fi);
		
		expVal = "Login";
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actVal = driver.findElement(By.id(pr.getProperty("login"))).getText();
		if (expVal.equalsIgnoreCase(actVal)) {
			return "Pass";
		} else {
			return "Fail";
		}
	}

	public String stockAccount_Login(String uName, String pWord)
	{
         
		expVal = "administrator";
		System.out.println(pr.getProperty("username"));
		System.out.println(pr.getProperty("password"));
		//System.out.println(pr.getProperty("btnsubmit"));
		
		
		//driver.findElement(By.id(pr.getProperty("username"))).clear();
		driver.findElement(By.id("username")).clear();
		
		//driver.findElement(By.id(pr.getProperty("username"))).sendKeys(uName);
		driver.findElement(By.id("username")).sendKeys(uName);
		
		//driver.findElement(By.id(pr.getProperty("password"))).clear();
		driver.findElement(By.id("password")).clear();
		
		//driver.findElement(By.id(pr.getProperty("password"))).sendKeys(pWord);
		driver.findElement(By.id("password")).sendKeys(pWord);
		
		driver.findElement(By.id("btnsubmit")).click();
		actVal = driver.findElement(
				By.xpath(".//*[@id='msUserName']/font/strong")).getText();
		if (expVal.equalsIgnoreCase(actVal)) {
			return "Pass";
		} else {
			return "Fail";
		}
	}

	public String stockAcc_Supplier(String supname, String sadd, String scity,
			String cntry, String sname, String spno, String semail,
			String smno, String snotes) {
		expVal = "Add succeeded";
		driver.findElement(By.linkText("Suppliers")).click();
		driver.findElement(
				By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a"))
				.click();

		driver.findElement(By.id("x_Supplier_Name")).sendKeys(supname);
		driver.findElement(By.id("x_Address")).sendKeys(sadd);
		driver.findElement(By.id("x_City")).sendKeys(scity);
		driver.findElement(By.id("x_Country")).sendKeys(cntry);
		driver.findElement(By.id("x_Contact_Person")).sendKeys(sname);
		driver.findElement(By.id("x_Phone_Number")).sendKeys(spno);
		driver.findElement(By.id("x__Email")).sendKeys(semail);
		driver.findElement(By.id("x_Mobile_Number")).sendKeys(smno);
		driver.findElement(By.id("x_Notes")).sendKeys(snotes);
		driver.findElement(By.id("btnAction")).click();
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]"))
				.click();
		Sleeper.sleepTightInSeconds(5);
		actVal = driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div"))
				.getText();
		System.out.println(actVal);
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button"))
				.click();

		if (expVal.equalsIgnoreCase(actVal)) {
			return "Pass";
		} else {
			return "Fail";
		}

	}

	public String stocK_Category_Creation(String catName)
			throws InterruptedException {
		expVal = "Add succeeded";
		WebElement wb = driver.findElement(By
				.xpath(".//*[@id='mi_a_stock_items']/a"));
		Actions a = new Actions(driver);
		a.moveToElement(wb).build().perform();
		driver.findElement(By.xpath(".//*[@id='mi_a_stock_categories']/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='x_Category_Name']")).sendKeys(
				catName);
		driver.findElement(By.name("btnAction")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]"))
				.click();
		Thread.sleep(2000);
		actVal = driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div"))
				.getText();
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button"))
				.click();
		Thread.sleep(2000);
		if (expVal.equalsIgnoreCase(actVal)) {
			return "Pass";
		} else {
			return "Fail";
		}
	}

	public String stock_UnitMeasurement_Creation(String id, String des)
			throws InterruptedException {
		expVal = "Add succeeded";
		WebElement wb = driver.findElement(By
				.xpath(".//*[@id='mi_a_stock_items']/a"));
		Actions a = new Actions(driver);
		a.moveToElement(wb).build().perform();
		driver.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.id("x_UOM_ID")).sendKeys(id);
		driver.findElement(By.id("x_UOM_Description")).sendKeys(des);
		driver.findElement(By.name("btnAction")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]"))
				.click();
		Thread.sleep(2000);
		actVal = driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div"))
				.getText();
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button"))
				.click();
		if (expVal.equalsIgnoreCase(actVal)) {
			return "Pass";
		} else {
			return "Fail";
		}

	}

	public String stockAccount_Logout() throws InterruptedException {
		expVal = "Login";
		driver.findElement(By.xpath(".//*[@id='logout']")).click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]"))
				.click();
		Thread.sleep(5000);
		actVal = driver.findElement(
				By.xpath(".//*[@id='msLoginDialog']/div/div/div[1]/h4"))
				.getText();
		if (expVal.equalsIgnoreCase(actVal)) {
			return "Pass";
		} else {
			return "Fail";
		}

	}

	public void stockAccount_Close() {
		driver.quit();
	}
	public String stockAcc_stockcatCreation(String catname)
	{
		boolean flag=false;
		WebElement sitem=driver.findElement(By.linkText("Stock Items"));
		
		Actions act=new Actions(driver);
		act.moveToElement(sitem).build().perform();
		
		driver.findElement(By.linkText("Stock Categories")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		driver.findElement(By.id("x_Category_Name")).sendKeys(catname);
		driver.findElement(By.id("btnAction")).click();
		Sleeper.sleepTightInSeconds(10);
		List<WebElement> button=driver.findElements(By.tagName("button"));
//		System.out.println(button.size());
		for (int i = 0; i < button.size(); i++) 
		{
			String text=button.get(i).getText();
			
			if (text.equalsIgnoreCase("OK!"))
			{
				button.get(i).click();
				break;
			}
			
		}
//		actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
//		System.out.println(actval);
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
		Sleeper.sleepTightInSeconds(5);
		//validation
		String count=driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[2]/form/div[2]/span[2]")).getText();
		String[] split=count.split(" ");
	System.out.println(split.length);
		int count1=Integer.parseInt(split[2]);
		int pcount=0;
	System.out.println(split[0]+"--"+split[1]+"--"+split[2]);
		
		do 
		{
			List<WebElement> rows=driver.findElements(By.xpath("//*[@id='tbl_a_stock_categorieslist']/tbody/tr"));
			for (int i = 0; i < rows.size(); i++) 
			{
				List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
				String acttext=cols.get(3).getText();
//				System.out.println(acttext);
				if (acttext.equalsIgnoreCase(catname)) 
				{
//					System.out.println("category available");
					flag=true;
					break;
				}
			
			}
			if (flag==false) 
			{
				driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/div/div/div[2]/a[1]")).click();
			}
			pcount++;
			
		} 
		while (pcount<=count1);
		if (flag==true) 
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}

}
	public String stockAcc_UnitofMcreation(String Uid,String Udesc)
	{
	
		WebElement sitem=driver.findElement(By.linkText("Stock Items"));
		
		Actions act=new Actions(driver);
		act.moveToElement(sitem).build().perform();
		
		driver.findElement(By.linkText("Unit of Measurement")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		driver.findElement(By.id("x_UOM_ID")).sendKeys(Uid);
		driver.findElement(By.id("x_UOM_Description")).sendKeys(Udesc);
		driver.findElement(By.id("btnAction")).click();
		Sleeper.sleepTightInSeconds(10);
		List<WebElement> button=driver.findElements(By.tagName("button"));
		System.out.println(button.size());
		for (int i = 0; i < button.size(); i++) 
		{
			String text=button.get(i).getText();
			
			if (text.equalsIgnoreCase("OK!"))
			{
				button.get(i).click();
				break;
			}
			
		}
		String actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
//		System.out.println(actval);
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
		Sleeper.sleepTightInSeconds(5);
		String count=driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[2]/form/div[2]/span[2]")).getText();
		String[] split=count.split(" ");
//		System.out.println(split.length);
		int count1=Integer.parseInt(split[2]);
		int pcount=0;
		System.out.println(split[0]+"--"+split[1]+"--"+split[2]);
		boolean flag = false;
		do 
		{
			List<WebElement> rows=driver.findElements(By.xpath(".//*[@id='tbl_a_unit_of_measurementlist']/tbody/tr"));
			for (int i = 0; i < rows.size(); i++) 
			{
				List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
				String acttext=cols.get(2).getText();
//				System.out.println(acttext);
				if (acttext.equalsIgnoreCase(Uid)) 
				{
					System.out.println("category available");
					flag=true;
					break;
				}
			
			}
			if (flag==false) 
			{
				driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/div/div/div[2]/a[1]")).click();
			}
			pcount++;
			
		} 
		while (pcount<=count1);

		if (flag==true) 
		{
			return "Pass";
		}
		else
		{
			return "Fail";
		}
	}
	
	
	
	public void StockItem_Creation() throws InterruptedException
	{
		WebElement w = driver.findElement(By
				.xpath(".//*[@id='mi_a_stock_items']/a"));
		Actions a = new Actions(driver);
		
		driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a"))
				.click();
		Thread.sleep(5000);
		Select dropdown = new Select(driver.findElement(By
				.xpath(".//*[@id='x_Category']")));
		dropdown.selectByVisibleText("computer");

		Select dropdown1 = new Select(driver.findElement(By
				.xpath(".//*[@id='x_Supplier_Number']")));
		dropdown1.selectByVisibleText("Notes");
		driver.findElement(By.id("x_Stock_Name")).sendKeys("Items");
		Select dropdown2 = new Select(driver.findElement(By
				.xpath(".//*[@id='x_Unit_Of_Measurement']")));
		dropdown2.selectByVisibleText("12");
		driver.findElement(By.id("x_Purchasing_Price")).sendKeys("3000");
		driver.findElement(By.xpath(".//*[@id='x_Selling_Price']")).sendKeys(
				"4000");
		driver.findElement(By.id("x_Notes")).sendKeys("test");
		driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]"))
				.click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button"))
				.click();
		Thread.sleep(5000);
	}

}


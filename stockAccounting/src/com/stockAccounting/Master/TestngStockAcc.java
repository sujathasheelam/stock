package com.stockAccounting.Master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngStockAcc {
	public static WebDriver driver;
	public static String URL = "http://webapp.qedgetech.com";
	public FileInputStream fi;
	public Properties pr;
	public static String expVal, actVal;
	public String supname="abcdef", sadd="Ameerpet", scity="Hyderabad";
	public String cntry="India", sname="xyzwc";
	public String spno="1234567890", semail="xyz@gmail.com";
	public String smno="8765432189", snotes="vcghv";
	public String uid="U0099",udesc="25";
	public String catname="pc";
	public boolean flag=false;
	@BeforeSuite
	public void stockAcc_Launch() throws IOException {
		fi = new FileInputStream("C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\properties\\StockAccPr.properties");
		pr = new Properties();
		pr.load(fi);
		expVal = "btnsubmit";
		String br = pr.getProperty("browser");
		if (br.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (br.equalsIgnoreCase("chrome")) {
			System.setProperty(
					"webdriver.chrome.driver",
					"C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\jars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		actVal = driver.findElement(By.id("btnsubmit")).getAttribute("id");
		Assert.assertEquals(actVal, expVal, "Launch Has Failed");
	}

	@AfterSuite
	public void stockAcc_Close() {
		driver.quit();
	}

	@BeforeTest
	public void stockAcc_Login() throws InterruptedException {
		expVal = "Administrator";
		driver.findElement(By.id(pr.getProperty("username"))).clear();
		driver.findElement(By.id(pr.getProperty("username"))).sendKeys("admin");
		driver.findElement(By.id(pr.getProperty("password"))).clear();
		driver.findElement(By.id(pr.getProperty("password")))
				.sendKeys("master");
		driver.findElement(By.id(pr.getProperty("login"))).click();
		actVal = driver.findElement(
				By.xpath(".//*[@id='msUserName']/font/strong")).getText();
		Assert.assertEquals(actVal, expVal, "Login Has Failed");

	}
	@AfterTest
	public void stockAcc_Logout() throws InterruptedException
	{
		expVal = "Login  ";
		driver.findElement(By.xpath(".//*[@id='logout']")).click();
		Thread.sleep(2000);
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
		//driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		Thread.sleep(5000);
		actVal = driver.findElement(By.xpath(".//*[@id='msLoginDialog']/div/div/div[1]/h4")).getText();
		System.out.println(actVal);
		Assert.assertEquals(actVal, expVal, "Logout Has Failed");
	}
	
}

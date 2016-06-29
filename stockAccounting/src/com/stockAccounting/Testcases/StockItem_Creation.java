package com.stockAccounting.Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.stockAccounting.Master.StockMaster;

public class StockItem_Creation {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		WebDriver driver = new FirefoxDriver();
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

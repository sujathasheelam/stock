package com.stockAccounting.Examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Unitmsrment {

	public static void main(String[] args) throws InterruptedException {
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
		WebElement wb=driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"));
		Actions a = new Actions(driver);
		a.moveToElement(wb).build().perform();
		driver.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("x_UOM_ID")).sendKeys("132");
		driver.findElement(By.id("x_UOM_Description")).sendKeys("books1");
		driver.findElement(By.name("btnAction")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
		Thread.sleep(5000);
	}

}

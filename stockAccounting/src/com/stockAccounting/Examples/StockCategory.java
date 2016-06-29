package com.stockAccounting.Examples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class StockCategory {

	public static void main(String[] args) throws InterruptedException {

		String catname = "books";
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
				"books");
		driver.findElement(By.name("btnAction")).click();
		Thread.sleep(2000);
		List<WebElement> button = driver.findElements(By.tagName("button"));
		// System.out.println(button.size());
		for (int i = 0; i < button.size(); i++) {
			String text = button.get(i).getText();

			if (text.equalsIgnoreCase("OK!")) {
				button.get(i).click();
				break;
			}

		}
		// actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
		// System.out.println(actval);
		driver.findElement(
				By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button"))
				.click();
		Sleeper.sleepTightInSeconds(5);
		// validation
		String count = driver
				.findElement(
						By.xpath(".//*[@id='ewContentColumn']/div[3]/div[2]/form/div[2]/span[2]"))
				.getText();
		String[] split = count.split(" ");
		System.out.println(split.length);
		int count1 = Integer.parseInt(split[2]);
		int pcount = 0;
		 System.out.println(split[0]+"--"+split[1]+"--"+split[2]);

		boolean flag = false;
		do {
			List<WebElement> rows = driver.findElements(By
					.xpath("//*[@id='tbl_a_stock_categorieslist']/tbody/tr"));
			for (int i = 0; i < rows.size(); i++) {
				List<WebElement> cols = rows.get(i).findElements(
						By.tagName("td"));
				String acttext = cols.get(3).getText();
				System.out.println(acttext);
				if (acttext.equalsIgnoreCase(catname)) {
					 System.out.println("category available");
					flag = true;
					break;
				}

			}
			if (flag == false) {
				driver.findElement(
						By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/div/div/div[2]/a[1]"))
						.click();
			}
			pcount++;

		} while (pcount <= count1);
		if (flag == true) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");			
		}
	}

}

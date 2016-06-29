package com.stockAccounting.Testcases;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.stockAccounting.Master.TestngStockAcc;

public class TestngStockItem extends TestngStockAcc {
	@Test
	public void stockItem_Creation() throws InterruptedException {
		boolean flag = false;
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
		dropdown.selectByVisibleText("computers");

		Select dropdown1 = new Select(driver.findElement(By
				.xpath(".//*[@id='x_Supplier_Number']")));
		dropdown1.selectByVisibleText("Notes");
		driver.findElement(By.id("x_Stock_Name")).sendKeys("Items1");
		Select dropdown2 = new Select(driver.findElement(By
				.xpath(".//*[@id='x_Unit_Of_Measurement']")));
		dropdown2.selectByVisibleText("1kg");
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

		String count = driver
				.findElement(
						By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/span[2]"))
				.getText();
		String[] split = count.split(" ");
		System.out.println(split.length);
		int count1 = Integer.parseInt(split[2]);
		int pcount = 0;
		// System.out.println(split[0]+"--"+split[1]+"--"+split[2]);

		do {
			List<WebElement> rows = driver
					.findElements(By
							.xpath("html/body/div[2]/div[3]/div/div/div[3]/form/div/div[2]/table/tbody/tr"));
			
			System.out.println(rows.size());
			for (int i = 0; i < rows.size(); i++) {
				List<WebElement> cols = rows.get(i).findElements(
						By.tagName("td"));
				System.out.println(cols.size());
				String acttext = cols.get(8).getText();
				System.out.println(acttext);
				if (acttext.equalsIgnoreCase("Items1")) {
					// System.out.println("category available");
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

		Assert.assertEquals(flag, true);

	}
}

package com.stockAccounting.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stockAccounting.Master.TestngStockAcc;

public class TestngSuppCreation extends TestngStockAcc{
@Test
public void stockAcc_SupplCreation()
{
	expVal = "Add succeeded";
	driver.findElement(By.linkText("Suppliers")).click();
	driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();

	driver.findElement(By.id("x_Supplier_Name")).sendKeys(supname);
	driver.findElement(By.id("x_Address")).sendKeys(sadd);
	driver.findElement(By.id("x_City")).sendKeys(scity);
	driver.findElement(By.id("x_Country")).sendKeys(cntry);
	driver.findElement(By.id("x_Contact_Person")).sendKeys(sname);
	driver.findElement(By.id("x_Phone_Number")).sendKeys(spno);
	driver.findElement(By.id("x__Email")).sendKeys(semail);
	driver.findElement(By.id("x_Mobile_Number")).sendKeys(smno);
	driver.findElement(By.id("x_Notes")).sendKeys(snotes);
	//driver.findElement(By.id("btnAction")).click();
	
	driver.findElement(By.xpath(".//*[@class='form-group']/div/button[1]")).click();
	Sleeper.sleepTightInSeconds(5);
	driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	Sleeper.sleepTightInSeconds(5);
	actVal=driver.findElement(By.xpath("//*[@class='ajs-dialog']/div[3]/div/div")).getText();
	driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	Assert.assertEquals(actVal, expVal,"Supplier creation Failed");
}
}

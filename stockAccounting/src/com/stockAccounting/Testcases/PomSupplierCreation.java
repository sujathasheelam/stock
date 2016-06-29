package com.stockAccounting.Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PomSupplierCreation {
	@Test
public void pomSupplier()
{
		WebDriver driver = new FirefoxDriver();
		PomLoginPage lp=PageFactory.initElements(driver, PomLoginPage.class);
		PomAdminHomePage am=PageFactory.initElements(driver, PomAdminHomePage.class);
		PomSupplierdata sp=PageFactory.initElements(driver,PomSupplierdata.class);
		driver.get(lp.url);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		lp.s_Login(lp.u, lp.p);
		Sleeper.sleepTightInSeconds(5);
		sp.supplierCreation(sp.supname, sp.sadd, sp.scity, sp.cntry, sp.sname, sp.spno, sp.semail, sp.smno, sp.snotes);
		am.logoutclick();
		Sleeper.sleepTightInSeconds(5);
		driver.close();
}
}

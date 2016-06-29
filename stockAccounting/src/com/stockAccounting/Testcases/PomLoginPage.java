package com.stockAccounting.Testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomLoginPage {
public static String url="http://webapp.qedgetech.com";
public static String u="admin", p="master";
@FindBy(id="username")
WebElement username;

@FindBy(id="password")
WebElement password;

@FindBy(id="btnsubmit")
WebElement login;

@FindBy(id="btnreset")
WebElement reset;

public void s_Login(String u,String p)
{
//	reset.click();
	username.clear();
	username.sendKeys(u);
	password.clear();
	password.sendKeys(p);
	login.click();
}
}

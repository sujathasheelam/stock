package com.stockAccounting.Testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomSupplierdata {
	public String supname="abcdef", sadd="Ameerpet", scity="Hyderabad";
	public String cntry="India", sname="xyzwc";
	public String spno="1234567890", semail="xyz@gmail.com";
	public String smno="8765432189", snotes="vcghv";
	public String expVal= "Add Succeeded";
	public String actVal;
@FindBy(id="x_Supplier_Name")
WebElement suppliername;

@FindBy(id="x_Address")
WebElement address;

@FindBy(id="x_City")
WebElement city;

@FindBy(id="x_Country")
WebElement country;

@FindBy(id="x_Contact_Person")
WebElement contactPerson;

@FindBy(id="x_Phone_Number")
WebElement phoneNumber;

@FindBy(id="x__Email")
WebElement email;

@FindBy(id="x_Mobile_Number")
WebElement mobileNumber;

@FindBy(id="x_Notes")
WebElement notes;

@FindBy(linkText="Suppliers")
WebElement suppliers;

@FindBy(xpath=".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")
WebElement addButton;

@FindBy(id="btnAction")
WebElement okButton;

@FindBy(xpath="html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")
WebElement p1;

@FindBy(xpath="html/body/div[17]/div[2]/div/div[3]/div/div")
WebElement p2;

@FindBy(xpath="html/body/div[17]/div[2]/div/div[4]/div[2]/button")
WebElement p3;

public void suppliersclick()
{
	suppliers.click();
}



public String supplierCreation(String supname, String sadd, String scity,
		String cntry, String sname, String spno, String semail,
		String smno, String snotes) 
		
{
	suppliersclick();
	addButton.click();
	suppliername.sendKeys(supname);
	address.sendKeys(sadd);
	city.sendKeys(scity);
	country.sendKeys(cntry);
	contactPerson.sendKeys(sname);
	phoneNumber.sendKeys(spno);
	email.sendKeys(semail);
	mobileNumber.sendKeys(smno);
	notes.sendKeys(snotes);
	okButton.click();
	
	p1.click();
	String actVal = p2.getText();
	p3.click();
	if (expVal.equalsIgnoreCase(actVal)) {
		return "Pass";
	} else {
		return "Fail";
	}

}
	
	
	
	
	
}




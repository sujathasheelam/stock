package com.stockAccounting.Examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Functionseg {
	public static WebDriver driver;
	public static String srcpath = "C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Screenshots";

	public static void main(String[] args) throws IOException {
		// driver = new FirefoxDriver();
		// driver.get("http://www.google.com");
		Functionseg f = new Functionseg();
		// f.takingScreenshot("google.bmp");
		f.excelRead(
				"C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Testdata",
				"Book1.xlsx", "Sheet1");
	}

	public void takingScreenshot(String name) throws IOException {
		File srcfile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File(srcpath + "\\" + name));
	}

	public void excelRead(String fPath, String fName, String shtName)
			throws IOException {
		String xl = fPath + "\\" + fName;
		FileInputStream f = new FileInputStream(xl);
		XSSFWorkbook wb = new XSSFWorkbook(f);
		XSSFSheet wsh = wb.getSheet("shtName");
		int RC = wsh.getLastRowNum();
		for (int i = 1; i <= RC; i++) {
			int CC = wsh.getRow(i).getLastCellNum();
			for (int j = 0; j < CC; j++) {
				System.out.println(wsh.getRow(i).getCell(j)
						.getStringCellValue());

			}
		}

	}
}

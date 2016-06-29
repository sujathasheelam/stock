package com.stockAccounting.Testcases;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.stockAccounting.Master.StockMaster;

public class UomXl {
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		StockMaster sm = new StockMaster();
		String xlPath = "C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Testdata\\UomData.xlsx";
		String xlRes = "C:\\Users\\sujatha\\workspace\\stockAccounting\\src\\com\\stockAccounting\\Results\\uomresult.xlsx";
		FileInputStream fi = new FileInputStream(xlPath);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("UOM");
		/* XSSFRow R=ws.getRow(3);
		 XSSFCell C11=R.getCell(0);
		
		 System.out.println(C11.getStringCellValue());*/

		int RC = ws.getLastRowNum();
		System.out.println(RC);
		sm.stockAccount_Launch(sm.URL);
		System.out.println("sm.stockAccount_Launch(sm.URL);");
		sm.stockAccount_Login("admin","master");
		System.out.println("sm.stockAccount_Login(sm.uname, sm.pword);");
		for (int i = 1; i<= RC; i++) {
			XSSFRow R1 = ws.getRow(i);
			XSSFCell C = R1.getCell(0);
			XSSFCell C1 = R1.getCell(1);

			XSSFCell C2 = R1.createCell(2);

			String Uid = C.getStringCellValue();
			String Udesc = C1.getStringCellValue();

			System.out.println(Uid + "-----" + Udesc);
			
			String res = sm.stockAcc_UnitofMcreation(Uid, Udesc);
			C2.setCellValue(res);

		}

		FileOutputStream fo = new FileOutputStream(xlRes);
		wb.write(fo);
		wb.close();
		sm.stockAccount_Logout();
		sm.stockAccount_Close();

	}

}
